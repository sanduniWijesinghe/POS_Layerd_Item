package lk.ijse.pos.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.pos.AppInitializer;

import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.bo.impl.BOFactory;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.view.tblmodel.CustomerTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class ManageCustomerFormController implements Initializable {

    boolean addnew = true;

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField txtCustomerId;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXTextField txtCustomerAddress;
    @FXML
    private TableView<CustomerTM> tblCustomers;

    private final CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);

    private void loadAllCustomers() {

        try {
            /*  get all customers*/

            ArrayList<CustomerDTO> allCustomers = this.customerBO.getAllCustomers();
            ArrayList<CustomerTM> allCustomersForTable = new ArrayList<>();

            for (CustomerDTO customer : allCustomers) {
                allCustomersForTable.add(new CustomerTM(customer.getId(), customer.getName(), customer.getAddress()));
            }
            ObservableList<CustomerTM> olCustomers = FXCollections.observableArrayList(allCustomersForTable);
            tblCustomers.setItems(olCustomers);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCustomers.getColumns().get(0).setStyle("-fx-alignment:center");
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        tblCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observable, CustomerTM oldValue, CustomerTM newValue) {

                if (newValue == null) {
                    clearTextFields();
                    addnew = true;
                    return;
                }

                txtCustomerId.setText(newValue.getId());
                txtCustomerName.setText(newValue.getName());
                txtCustomerAddress.setText(newValue.getAddress());

                addnew = false;

            }
        });

        loadAllCustomers();
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent event) {

        Alert confirmAlert = new Alert(Alert.AlertType.WARNING, "Are you sure whether you want to delete the customer?", ButtonType.YES, ButtonType.NO);

        Optional<ButtonType> result = confirmAlert.showAndWait();

        if (result.get() == ButtonType.YES) {

            String customerID = tblCustomers.getSelectionModel().getSelectedItem().getId();

            try {
                /*Delete operation*/
                boolean b = customerBO.deleteCustomer(customerID);

                if (b) {
                    loadAllCustomers();
                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR, "Failed to delete the customer", ButtonType.OK);
                    a.show();
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private void clearTextFields() {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
    }

    @FXML
    private void btnAddNewCustomer_OnAction(ActionEvent event) {
        txtCustomerId.requestFocus();
        tblCustomers.getSelectionModel().clearSelection();
        addnew = true;
    }

    @FXML
    private void btnSave_OnAction(ActionEvent event) {

        if (addnew) {
            try {
                /* Add Operation*/
                boolean b = customerBO.addCustomer(new CustomerDTO(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText()));
                if (b) {
                    loadAllCustomers();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Unable to add new customer", ButtonType.OK).show();
                }
            } catch (Exception ex) {
                Logger.getLogger(ManageCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                //Update Operation
                boolean b = customerBO.updateCustomer(new CustomerDTO(txtCustomerId.getText(), txtCustomerName.getText(), txtCustomerAddress.getText()));
                if (b) {
                    loadAllCustomers();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Unable to update the customer", ButtonType.OK).show();
                }


            } catch (Exception ex) {
                Logger.getLogger(ManageCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

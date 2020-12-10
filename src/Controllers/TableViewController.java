//Sky Florence 1109038 2020-12-10#3d3d3d
package Controllers;

import Models.Customer;
import Models.Product;
import Models.SearchResult;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import utils.JSONFileUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private Label saleLabel;

    @FXML
    private Label msrpLabel;

    @FXML
    private Label savingsLabel;

    @FXML
    private Label rowsInTableLabel;

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idColumn;

    @FXML
    private TableColumn<Customer, String> firstNameColumn;

    @FXML
    private TableColumn<Customer, String> lastNameColumn;

    @FXML
    private TableColumn<Customer, String> phoneColumn;

    @FXML
    private TableColumn<Customer, String> totalPurchaseColumn;

    @FXML
    private ListView<Product> purchaseListView;

    @FXML
    private ImageView imageView;

    @FXML
    private void top10Customers()
    {
        System.out.println("called method top10Customers()");
        rowsInTableLabel.setText(tableView.getItems().size() + "");
    }

    @FXML
    private void customersSavedOver5()
    {
        System.out.println("called method customersSavedOver5()");
        rowsInTableLabel.setText(tableView.getItems().size() + "");
    }

    @FXML
    private void loadAllCustomers()
    {
        tableView.getItems().addAll(JSONFileUtil.getCustomers("src/customers.json"));
        rowsInTableLabel.setText(tableView.getItems().size() + "");
        System.out.println("called method loadAllCustomers");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("Id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("purchases"));

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (object,oldValue,newValue)->{
                    if (oldValue != null)
                    purchaseListView.getItems().removeAll(oldValue.getPurchases());
                    purchaseListView.getItems().addAll(newValue.getPurchases());
                }
        );
        loadAllCustomers();
    }
}

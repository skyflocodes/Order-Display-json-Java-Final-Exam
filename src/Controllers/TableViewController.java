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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.JSONFileUtil;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

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

    private ArrayList<Customer> allCustomer;

    @FXML
    private ImageView imageView;

    @FXML
    private void top10Customers()
    {
        System.out.println("called method top10Customers()");
    }

    @FXML
    private void customersSavedOver5()
    {
        System.out.println("called method customersSavedOver5()");
    }

    @FXML
    private void loadAllCustomers()
    {
        int columnSize = 0;
        purchaseListView.getItems().clear();
        tableView.getItems().clear();
        tableView.getItems().addAll(allCustomer);
        System.out.println("called method loadAllCustomers");
        columnSize = tableView.getItems().size();
        rowsInTableLabel.setText(columnSize + "");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allCustomer = JSONFileUtil.getCustomers("src/customers.json");
        idColumn.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("Id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("lastName"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("phoneNumber"));
        totalPurchaseColumn.setCellValueFactory(new PropertyValueFactory<Customer,String>("totalPurchases"));

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (object,oldValue,newValue)->{
                    imageView.setImage(null);
                    if (oldValue != null)
                    purchaseListView.getItems().removeAll(oldValue.getPurchases());
                    purchaseListView.getItems().addAll(newValue.getPurchases());
                    msrpLabel.setText("Total MSRP:" + newValue.getTotalPrice() + "");
                    saleLabel.setText("Total Paid:" + newValue.getTotalSale() + "");
                    savingsLabel.setText("Total Saved:" + newValue.getTotalSaved() + "");
                });

        purchaseListView.getSelectionModel().selectedItemProperty().addListener(
                (object,oldValue,newValue)->{
                    if (purchaseListView == null)
                        imageView.setImage(null);
                    imageView.setImage(new Image(newValue.getImages()));
                });

        loadAllCustomers();
    }
}

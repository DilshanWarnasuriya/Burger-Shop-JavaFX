package controller;

import DB.OrderList;
import Model.Orders;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewDeliveredOrdersController implements Initializable {
    @FXML
    private TableView tblDeliveredOrders;
    @FXML
    private Button btnBack;
    @FXML
    private TableColumn colOrderId;
    @FXML
    private TableColumn colCustomerId;
    @FXML
    private TableColumn colCustomerName;
    @FXML
    private TableColumn colQty;
    @FXML
    private TableColumn colValue;

    private final OrderList orderList = OrderList.getInstance();
    private final int DELIVERED=1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("OrderId"));
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("CustomerId"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colValue.setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<Orders> list = orderList.getOrdersByStatus(DELIVERED);
        tblDeliveredOrders.setItems(list);

    }
    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage thiStage = (Stage) btnBack.getScene().getWindow();
        thiStage.close();

        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewOrders.fxml"))));
        stage.show();
    }


}

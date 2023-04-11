package gui.software1project;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.lang.Integer;
public class mainFormController implements Initializable {
    //Table List
    @FXML TableView<Part> partList;
    @FXML TableColumn<Part, Integer> partId;
    @FXML TableColumn<Part, String> partName;
    @FXML TableColumn<Part, Integer> inventoryLevel;
    @FXML TableColumn<Part, Double> partPrice;

    //Search Bar
    @FXML TextField partSearchBar;



    private Stage stage;
    private Scene scene;
    private Parent root;

    public void addPartButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-part-form-inhouse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addProductButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-product-form.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void modifyPartButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("modify-part-form-inhouse.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void searchBarPart(ActionEvent event) throws IOException{

        String partName = partSearchBar.getText();

        ObservableList<Part> filteredParts = Inventory.lookupPart(partName);

        if(filteredParts.size() == 0){
            try {
                int partId = Integer.parseInt(partName);
                Part p = Inventory.lookupPart(partId);

                if (p != null) {
                    filteredParts.add(p);
                }
            }
            catch (NumberFormatException e){
                //ignore
            }
        }
        partList.setItems(filteredParts);

    }


    public void exitButton(ActionEvent event) throws IOException {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partList.setItems(Inventory.getAllParts());
        partId.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partName.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        inventoryLevel.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));
        partPrice.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));

    }


}

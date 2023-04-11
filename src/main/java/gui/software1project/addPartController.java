package gui.software1project;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;


public class addPartController {
    @FXML TextField textFieldId;
    @FXML TextField textFieldName;
    @FXML TextField textFieldInventory;
    @FXML TextField textFieldPrice;
    @FXML TextField textFieldMax;
    @FXML TextField textFieldMin;
    @FXML TextField textFieldMachineId;
    @FXML TextField textFieldCompanyName;
    @FXML Button saveButton;
    @FXML RadioButton partRadioInhouse;
    @FXML RadioButton partRadioOutsourced;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void savePartButton(ActionEvent event) throws IOException {
        int id = (int)(Math.random() * 1000);
        String name = textFieldName.getText();
        double price = Double.parseDouble(textFieldPrice.getText());
        int stock = Integer.parseInt(textFieldInventory.getText());
        int min = Integer.parseInt(textFieldMin.getText());
        int max = Integer.parseInt(textFieldMax.getText());


        if(partRadioInhouse.isSelected()){
            int machineId = Integer.parseInt(textFieldMachineId.getText());
            InHouse Part = new InHouse(id, name, price, stock, min, max, machineId);
            Inventory.addPart(Part);
        }

        if(partRadioOutsourced.isSelected()){
            String companyName = textFieldCompanyName.getText();
            Outsourced Part = new Outsourced(id, name, price, stock, min, max, companyName);
            Inventory.addPart(Part);
        }

        root = FXMLLoader.load(getClass().getResource("main-form.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void cancelButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main-form.FXML"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void partInhouseButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-part-form-inhouse.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void partOutsourcedButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("add-part-form-outsourced.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
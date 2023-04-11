package gui.software1project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;



public class modifyPartController implements Initializable {

    @FXML
    TextField textFieldModPartId;
    @FXML
    TextField textFieldModPartName;
    @FXML TextField textFieldModPartInventory;
    @FXML TextField textFieldModPartPrice;

    @FXML TextField textFieldModPartMax;
    @FXML TextField textFieldModPartMin;
    @FXML TextField textFieldModPartCompanyName;
    @FXML TextField textFieldModPartMachineId;

    private int currentIndex = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void resultsUpdate(int selectedIndex,Part selectedPart){
        currentIndex = selectedIndex;
 /*       if(selectedPart instanceof InHouse){
            //Set Inhouse RadioButton setTrue

        }
        else{
            //Set Outsourced RadioButton setTrue

       }
*/
        textFieldModPartId.setText(String.valueOf(selectedPart.getId()));
        textFieldModPartName.setText(String.valueOf(selectedPart.getName()));
        textFieldModPartInventory.setText(String.valueOf(selectedPart.getStock()));
        textFieldModPartPrice.setText(String.valueOf(selectedPart.getPrice()));
        textFieldModPartMax.setText(String.valueOf(selectedPart.getMax()));
        textFieldModPartMin.setText(String.valueOf(selectedPart.getMin()));
        //textFieldModPartMachineId.setText(String.valueOf();
    }



}

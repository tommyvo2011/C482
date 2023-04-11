package gui.software1project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class Inventory {

    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public static void addPart(Part newPart) {

       allParts.add(newPart);

    }

    public static Part lookupPart(int partId) {
        ObservableList<Part> searchedPart = FXCollections.observableArrayList();

        for(Part p: allParts){
            if(p.getId() == partId){
                return p;
            }
        }


        return null;
    }

    public static ObservableList<Part> lookupPart(String name) {
        ObservableList<Part> searchedPart = FXCollections.observableArrayList();

        for(Part p : allParts) {
            if(p.getName().contains(name)) {
                searchedPart.add(p);
            }
        }
        return searchedPart;
    }

    public void updatePart(int index, Part selectedPart) {

    }
/*
    public boolean deletePart(Part selectedPart) {

    }
*/

    public static ObservableList<Part> getAllParts() {

        return allParts;
    }

}

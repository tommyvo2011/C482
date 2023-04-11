module gui.software1project {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui.software1project to javafx.fxml;
    exports gui.software1project;
}
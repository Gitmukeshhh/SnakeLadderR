module com.example.projectsnake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectsnake to javafx.fxml;
    exports com.example.projectsnake;
}
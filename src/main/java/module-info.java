module org.example.ejea {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejea to javafx.fxml;
    exports org.example.ejea;
}
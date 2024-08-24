module org.example.oop_project3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires javafx.media;

    opens org.example.oop_project3 to javafx.fxml;
    exports org.example.oop_project3;
}
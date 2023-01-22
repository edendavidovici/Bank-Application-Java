module com.example.bank {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bank to javafx.fxml;
    exports com.example.bank;
}
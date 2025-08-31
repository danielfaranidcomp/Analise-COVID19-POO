module COVID19 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens COVID19 to javafx.fxml;
    exports COVID19;
}

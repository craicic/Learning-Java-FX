module me.vaalp.learningjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.vaalp.learningjavafx to javafx.fxml;
    exports me.vaalp.learningjavafx;
}
module chess.aiassistedchessproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens chess.aiassistedchessproject to javafx.fxml;
    exports chess.aiassistedchessproject;
}
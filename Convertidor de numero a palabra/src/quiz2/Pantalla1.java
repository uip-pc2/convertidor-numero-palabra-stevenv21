package quiz2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Pantalla1 {
    @FXML
    TextField ingresar;
    @FXML
    Button convertir;

    public void btn_convertir (ActionEvent actionEvent) throws IOException {
        int st = 0;
        String st1 = ingresar.getText();
        if (st1.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error al Ingresar");
            alerta.setHeaderText("Mira, hubo un error...");
            alerta.setContentText("El espacio no debe estar vacio.");
            alerta.showAndWait();
            ingresar.setText("");
            return;

        } else {
            try {
                st = Integer.parseInt(st1);
                if (st >= 0 && st <= 9999){
                    Stage stage = (Stage) convertir.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pantalla2.fxml"));
                    Parent root = null;
                    try {
                        root = (Parent) fxmlLoader.load();
                    } catch (Exception e) {
                        Alert alerta = new Alert(Alert.AlertType.ERROR);
                        alerta.setTitle("Error de Aplicacion");
                        alerta.setHeaderText("Mira, hubo un error...");
                        alerta.setContentText("Lo siento. Llama al administrador.");
                        alerta.showAndWait();
                        Platform.exit();
                    }
                    Pantalla2 sc = fxmlLoader.<Pantalla2>getController();
                    sc.setResultado(st);
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Error al Ingresar");
                    alerta.setHeaderText("Mira, hubo un error...");
                    alerta.setContentText("El número debe ser de 0 a 9999.");
                    alerta.showAndWait();
                    ingresar.setText("");
                    return;}
            } catch (NumberFormatException e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Error al Ingresar");
                alerta.setHeaderText("Mira, hubo un error...");
                alerta.setContentText("Debe escribir un numero entero.");
                alerta.showAndWait();
                ingresar.setText("");
                return;
            }
        }

    }
}
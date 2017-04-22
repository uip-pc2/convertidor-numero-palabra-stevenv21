package quiz2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class Pantalla2 {
    @FXML
    Label resultado;
    @FXML
    Button btn_volver;
    @FXML
    Button btn_salir;


    public String conversión(int r) {
        int numero = r;
        int U1000 = numero / 1000;
        numero = numero - (U1000 * 1000);
        int U100 = numero / 100;
        numero = numero - (U100 * 100);
        int U10 = numero / 10;
        numero = numero - (U10 * 10);
        int U = numero;

        switch (U) {
            case 0:
                if ((U1000 + U100 + U10) == 0) {
                    return " cero";
                } else {
                    return millarEnTexto(U1000) + ((U1000 <= 9999) ? " " : "")  + centenaEnTexto(U100) + " " + decenaEnTexto(U10) + ((U > 0) ? " y " : "") +
                            unidadEnTexto(U);
                }
        }

        if ((U1000 + U100 + U10) == 100) {
            return "Cien ";
        }
        if ((U == 0) && (U10 > 0)) {
            return decenaEnTexto(U10);
        } else if (U10 == 1) {
            return decenas(10 + U);

        } else if ((U100 <= 999)) {
            return millarEnTexto(U1000) + ((U <= 9999) ? " " : "") + centenaEnTexto(U100) + " " + decenaEnTexto(U10) + ((U <= 999) ? " " : "") +
                    ((U > 0) ? " y " : "") + unidadEnTexto(U);
        }
        if (U1000 <= 9999) {
            return millarEnTexto(U1000) + ((U <= 9999) ? " " : "")  + centenaEnTexto(U100) + " " + decenaEnTexto(U10) + ((U > 0) ? " y " : "") +
                    unidadEnTexto(U);
        }
        return null;
    }





    public static String unidadEnTexto(int r) {

        switch (r) {
            case 1:
                return "uno";
            case 2:
                return "dos";
            case 3:
                return "tres";
            case 4:
                return "cuatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "siete";
            case 8:
                return "ocho";
            case 9:
                return "nueve";
            case 0:
                return " ";
            default:
                return " ";
        }
    }

    public static String decenaEnTexto(int iDecena) {
        switch (iDecena) {
            case 1:
                return "diez";
            case 2:
                return "veinte";
            case 3:
                return "treinta";
            case 4:
                return "cuarenta";
            case 5:
                return "cincuenta";
            case 6:
                return "sesenta";
            case 7:
                return "setenta";
            case 8:
                return "ochenta";
            case 9:
                return "noventa";
            default:
                return "";
        }
    }
    public static String decenas(int iDecena) {
        switch (iDecena) {
            case 11:
                return "once";
            case 12:
                return "doce";
            case 13:
                return "trece";
            case 14:
                return "catorce";
            case 15:
                return "quince";
            case 16:
                return "dieciseis";
            case 17:
                return "diecisiete";
            case 18:
                return "dieciocho";
            case 19:
                return "diecinueve";
            default:
                return "";
        }
    }

    public static String centenaEnTexto(int iCentena) {
        switch (iCentena) {
            case 1:
                return "ciento";
            case 2:
                return "doscientos";
            case 3:
                return "trecientos";
            case 4:
                return "cuatrocientos";
            case 5:
                return "quinientos";
            case 6:
                return "seiscientos";
            case 7:
                return "setecientos";
            case 8:
                return "ochociento";
            case 9:
                return "novecientos";
            default:
                return "";
        }
    }
    public static String millarEnTexto(int iMillar){

        switch (iMillar) {
            case 1:
                return "mil";
            case 2:
                return "dosmil";
            case 3:
                return "tresmil";
            case 4:
                return "cuatromil";
            case 5:
                return "cincomil";
            case 6:
                return "seismil";
            case 7:
                return "sietemil";
            case 8:
                return "ochomil";
            case 9:
                return "nuevemil";
            default:
                return "";
        }
    }

    public void setResultado (int r) {
        resultado.setText(Integer.toString(r) + "\n" + conversión(r));
    }

    public void volver(ActionEvent actionEvent) {
        Stage stage = (Stage) btn_volver.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pantalla1.fxml"));
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error de Aplicacion");
            alerta.setHeaderText("Mira, hubo un error...");
            alerta.setContentText("Lo siento. Llama al administrador.");
            alerta.showAndWait();
            Platform.exit();
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void btn_salir(ActionEvent actionEvent) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Confirmacion de Salida");
        alerta.setHeaderText("Usted esta saliendo de la aplicacion");
        alerta.setContentText("Esta seguro de esto?");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaggicriptati;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author feder
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private Button codificaBtn;
    @FXML
    private Button decodificaBtn;
    @FXML
    private TextField risultatoTxt;
    @FXML
    private TextField InserisciTxt;
    @FXML
    private Label lunghezzaMessaggioLbl;

    private final int LUNGHEZZA_MASSIMA_MESSAGGIO = 400;
    @FXML
    private Button pulisciBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lunghezzaMessaggioLbl.setText("Caratteri restanti: " + LUNGHEZZA_MASSIMA_MESSAGGIO);
        Criptatore.inizializzaChiavi();
    }

    @FXML
    private void controlloLunghezza(KeyEvent event) {
        String testo = InserisciTxt.getText();
        if (testo.length() <= LUNGHEZZA_MASSIMA_MESSAGGIO) {
            lunghezzaMessaggioLbl.setText("Caratteri restanti: " + (LUNGHEZZA_MASSIMA_MESSAGGIO - testo.length()));
        } else {
            InserisciTxt.setDisable(true);
        }

    }

    @FXML
    private void codifica(ActionEvent event) {
        risultatoTxt.setText(Criptatore.cripta(InserisciTxt.getText()));

    }

    @FXML
    private void decodifica(ActionEvent event) {
        risultatoTxt.setText(Criptatore.decripta(InserisciTxt.getText()));
    }

    @FXML
    private void pulisci(ActionEvent event) {
        risultatoTxt.clear();
        InserisciTxt.clear();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaggicriptati;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Federico Gavazzi
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
    private TextArea risultatoTxt;
    @FXML
    private TextArea InserisciTxt;
    @FXML
    private Label lunghezzaMessaggioLbl;

    private final int LUNGHEZZA_MASSIMA_MESSAGGIO = Criptatore.getLUNGHEZZA_MASSIMA_MESSAGGIO();
    @FXML
    private Button pulisciBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lunghezzaMessaggioLbl.setText("Caratteri restanti: " + LUNGHEZZA_MASSIMA_MESSAGGIO);
        try {
            Criptatore.inizializzaChiavi();
        } catch (IOException ex) {
            System.out.println("Problemi con il caricamento delle chiavi");
        }
        codificaBtn.setDisable(true);
        decodificaBtn.setDisable(true);
        pulisciBtn.setDisable(true);
        label1.setText("");
    }

    /**
     * Controllo che il testo non superi la lunghezza massima ogni volta che
     * viene premuto un tasto del mouse.
     *
     * @param event
     */
    @FXML
    private void controlloLunghezzaMouse(MouseEvent event) {
        String testo = InserisciTxt.getText();
        if (testo.length() <= LUNGHEZZA_MASSIMA_MESSAGGIO) {
            lunghezzaMessaggioLbl.setText("Caratteri restanti: " + (LUNGHEZZA_MASSIMA_MESSAGGIO - testo.length()));
        } else {
            InserisciTxt.setDisable(true);
            lunghezzaMessaggioLbl.setText("Caratteri restanti: " + 0);
            label1.setText("Verrano codificati/decodificati solo i primi " + LUNGHEZZA_MASSIMA_MESSAGGIO + " caratteri.");
        }

        if (testo.length() == 0) {
            codificaBtn.setDisable(true);
            decodificaBtn.setDisable(true);
            pulisciBtn.setDisable(true);
        } else {
            codificaBtn.setDisable(false);
            decodificaBtn.setDisable(false);
            pulisciBtn.setDisable(false);

        }
    }

    /**
     * Controllo che il testo non superi la lunghezza massima ogni volta che
     * viene premuto un tasto della tastiera.
     *
     * @param event
     */
    @FXML
    private void controlloLunghezzaTastiera(KeyEvent event) {
        String testo = InserisciTxt.getText();
        if (testo.length() <= LUNGHEZZA_MASSIMA_MESSAGGIO) {
            lunghezzaMessaggioLbl.setText("Caratteri restanti: " + (LUNGHEZZA_MASSIMA_MESSAGGIO - testo.length()));
        } else {
            InserisciTxt.setDisable(true);
            lunghezzaMessaggioLbl.setText("Caratteri restanti: " + 0);
            label1.setText("Verrano codificati/decodificati solo i primi " + LUNGHEZZA_MASSIMA_MESSAGGIO + " caratteri.");
        }

        if (testo.length() == 0) {
            codificaBtn.setDisable(true);
            decodificaBtn.setDisable(true);
            pulisciBtn.setDisable(true);
        } else {
            codificaBtn.setDisable(false);
            decodificaBtn.setDisable(false);
            pulisciBtn.setDisable(false);

        }

    }

    /**
     * Quando premo il bottone per codificare prendo il testo dal text Area di
     * inserimento, lo codifico e lo restituisco nel secondo text Area, inoltre
     * viene aggiornata la label in cui si avvisa se il messaggio è stato
     * codificato e se il campo di testo è vuoto.
     *
     * @param event
     */
    @FXML
    private void codifica(ActionEvent event) {
        if (InserisciTxt.getText().equals("")) {
            label1.setText("Messaggio vuoto");
        } else if (InserisciTxt.getText().length() > LUNGHEZZA_MASSIMA_MESSAGGIO) {

            risultatoTxt.setText(Criptatore.cripta(InserisciTxt.getText().substring(0, LUNGHEZZA_MASSIMA_MESSAGGIO - 1)));
            label1.setText("Messaggio codificato");
        } else {
            risultatoTxt.setText(Criptatore.cripta(InserisciTxt.getText()));
            label1.setText("Messaggio codificato");
        }
    }

    /**
     * Quando premo il bottone per decodificare prendo il testo dal text Area
     * di inserimento, lo decodifico e lo restituisco nel secondo text Area,
     * inoltre viene aggiornata la label in cui si avvisa se il messaggio è
     * stato codificato e se il campo di testo è vuoto.
     *
     * @param event
     */
    @FXML
    private void decodifica(ActionEvent event) {
        if (InserisciTxt.getText().equals("")) {
            label1.setText("Messaggio vuoto");
        } else if (InserisciTxt.getText().length() > LUNGHEZZA_MASSIMA_MESSAGGIO) {
            lunghezzaMessaggioLbl.setText("Caratteri restanti: " + 0);
            risultatoTxt.setText(Criptatore.decripta(InserisciTxt.getText().substring(0, LUNGHEZZA_MASSIMA_MESSAGGIO - 1)));
            label1.setText("Messaggio decodificato");
        } else {
            risultatoTxt.setText(Criptatore.decripta(InserisciTxt.getText()));
            label1.setText("Messaggio decodificato");
        }
    }

    /**
     * Pulisco la label e i text Area. Disabilito i pulsanti.
     *
     * @param event
     */
    @FXML
    private void pulisci(ActionEvent event) {
        risultatoTxt.clear();
        InserisciTxt.clear();
        label1.setText("");
        codificaBtn.setDisable(true);
        decodificaBtn.setDisable(true);
        pulisciBtn.setDisable(true);
        lunghezzaMessaggioLbl.setText("Caratteri restanti: " + LUNGHEZZA_MASSIMA_MESSAGGIO);

    }

}

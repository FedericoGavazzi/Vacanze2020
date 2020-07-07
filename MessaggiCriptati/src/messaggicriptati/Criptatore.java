/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaggicriptati;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Federico Gavazzi Classe in cui vengono caricate le chiavi di codifica
 * e decodifica, codificati e decodificati i messaggi e impostata la lunghezza
 * massima del messaggio.
 */
public class Criptatore {

    /**
     * chiave di codificazione
     */
    private static HashMap<Character, Character> chiave = new HashMap<>();
    /**
     * chiave di decodificazione
     */
    private static HashMap<Character, Character> chiaveInversa = new HashMap<>();
    private static final int LUNGHEZZA_MASSIMA_MESSAGGIO = 1000;

    /**
     * Recupero tutti i caratteri presenti mel messaggio da codificare, ricreo
     * il messaggio codificato utilizzando la chiave di decriptazione.
     *
     * @param messaggio, il messaggio da codificare.
     * @return il messaggio codificato.
     */
    public static String cripta(String messaggio) {
        String messaggioCriptato = "";
        char caratteri[] = new char[LUNGHEZZA_MASSIMA_MESSAGGIO];
        for (int i = 0; i < messaggio.length(); i++) {
            caratteri[i] = messaggio.charAt(i);
        }
        for (int i = 0; i < messaggio.length(); i++) {
            if (chiave.get(caratteri[i]) == null) {
                messaggioCriptato += caratteri[i];
            } else {
                messaggioCriptato += chiave.get(caratteri[i]);
            }
        }
        return messaggioCriptato;
    }

    /**
     * Recupero tutti i caratteri presenti mel messaggio da decodificare, ricreo
     * il messaggio decodificato utilizzando la chiave di decriptazione.
     *
     * @param messaggio, il messaggio da decodificare.
     * @return il messaggio decodificato.
     */
    public static String decripta(String messaggio) {
        String messaggioDecriptato = "";
        char caratteri[] = new char[LUNGHEZZA_MASSIMA_MESSAGGIO];
        for (int i = 0; i < messaggio.length(); i++) {
            caratteri[i] = messaggio.charAt(i);
        }
        for (int i = 0; i < messaggio.length(); i++) {
            if (chiave.get(caratteri[i]) == null) {
                messaggioDecriptato += caratteri[i];
            } else {
                messaggioDecriptato += chiaveInversa.get(caratteri[i]);
            }
        }
        return messaggioDecriptato;
    }

    /**
     * Inizializzo le mappe per la codifica e decodifica dei messaggi caricando
     * le informazioni da 4 file. 2 per le informazioni sulla codifica e 2 per
     * le informazioni sulla decodifica.
     *
     * @throws java.io.IOException
     */
    public static void inizializzaChiavi() throws IOException {
        BufferedReader br;
        //caricamento alfabeto e codifica da file
        try {
            br = new BufferedReader(new FileReader("chiaveDiCodifica.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                String caratteri[] = s.split(",");
                chiave.put(caratteri[0].charAt(0), caratteri[1].charAt(0));
            }
            //caricamento numeri e simboli e codifica da file
            br = new BufferedReader(new FileReader("altriCaratteriCodifica.txt"));
            while ((s = br.readLine()) != null) {
                String caratteri[] = s.split("a");
                chiave.put(caratteri[0].charAt(0), caratteri[1].charAt(0));
            }
            //caricamento alfabeto e decodifica da file
            br = new BufferedReader(new FileReader("chiaveDiDecodifica.txt"));
            while ((s = br.readLine()) != null) {
                String caratteri[] = s.split(",");
                chiaveInversa.put(caratteri[0].charAt(0), caratteri[1].charAt(0));
            }
            //caricamento numeri e simboli e decodifica da file
            br = new BufferedReader(new FileReader("altriCaratteriDecodifica.txt"));
            while ((s = br.readLine()) != null) {
                String caratteri[] = s.split("a");
                chiaveInversa.put(caratteri[0].charAt(0), caratteri[1].charAt(0));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Uno o più file non presenti");
        }

    }

    public static int getLUNGHEZZA_MASSIMA_MESSAGGIO() {
        return LUNGHEZZA_MASSIMA_MESSAGGIO;
    }

}

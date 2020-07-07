/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica;

import java.util.TreeMap;

/**
 *
 * @author feder
 */
public class GestoreContatti {
    private TreeMap <String, Contatto> rubrica;
    private int numeroContatti;

    public GestoreContatti() {
        rubrica = new TreeMap <>();
        numeroContatti = 0;
    }
    
    public void aggiungiContatto(String nome, String cognome, String indirizzo, String numeroTelefonico){
        rubrica.put(cognome, new Contatto(nome, cognome, indirizzo, numeroTelefonico));
        numeroContatti++;
    }
    
    public void aggiungiContatto(Contatto nuovoContatto){
        rubrica.put(nuovoContatto.getCognome(), nuovoContatto);
        numeroContatti++;
    }
    
    public void rimuoviContatto(){
       
    }
    
    public void cercaContatto(){
        
    }
    
    
    
    
    
}

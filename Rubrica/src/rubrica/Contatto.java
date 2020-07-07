/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica;

/**
 *
 * @author Federico Gavazzi
 */
public class Contatto {
    private String nome;
    private String cognome;
    private String indirizzo;
    private String numeroTelefonico;

    public Contatto(String nome, String cognome, String indirizzo, String numeroTelefonico) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

}

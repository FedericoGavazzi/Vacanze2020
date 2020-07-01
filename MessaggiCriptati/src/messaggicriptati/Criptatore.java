/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaggicriptati;

import java.util.HashMap;

/**
 *
 * @author feder
 */
public class Criptatore {

    private static HashMap<Character, Character> chiave = new HashMap<>();
    private static HashMap<Character, Character> chiaveInversa = new HashMap<>();

    public static String cripta(String messaggio) {
        String messaggioCriptato = "";
        char caratteri[] = new char[400];
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

    public static String decripta(String messaggio) {
        String messaggioDecriptato = "";
        char caratteri[] = new char[400];
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

    public static void inizializzaChiavi() {
        chiave.put('A', 'h');
        chiave.put('B', 'f');
        chiave.put('C', 'G');
        chiave.put('D', 'I');
        chiave.put('E', 'M');
        chiave.put('F', 'O');
        chiave.put('G', 'b');
        chiave.put('H', 'l');
        chiave.put('I', 'e');
        chiave.put('J', 'd');
        chiave.put('K', 'N');
        chiave.put('L', 'o');
        chiave.put('M', 'F');
        chiave.put('N', 'c');
        chiave.put('O', 'i');
        chiave.put('P', 'A');
        chiave.put('Q', 'H');
        chiave.put('R', 'D');
        chiave.put('S', 'a');
        chiave.put('T', 'E');
        chiave.put('U', 'C');
        chiave.put('V', 'g');
        chiave.put('W', 'B');
        chiave.put('X', 'm');
        chiave.put('Y', 'L');
        chiave.put('Z', 'n');
        chiave.put('a', 's');
        chiave.put('b', 'T');
        chiave.put('c', 'v');
        chiave.put('d', 'p');
        chiave.put('e', 'R');
        chiave.put('f', 'y');
        chiave.put('g', 'K');
        chiave.put('h', 'z');
        chiave.put('i', 'Q');
        chiave.put('j', 'P');
        chiave.put('k', 'J');
        chiave.put('l', 'r');
        chiave.put('m', 'V');
        chiave.put('n', 'w');
        chiave.put('o', 'S');
        chiave.put('p', 'j');
        chiave.put('q', 't');
        chiave.put('r', 'Z');
        chiave.put('s', 'k');
        chiave.put('t', 'W');
        chiave.put('u', 'x');
        chiave.put('v', 'Y');
        chiave.put('w', 'u');
        chiave.put('x', 'U');
        chiave.put('y', 'X');
        chiave.put('z', 'q');
        chiaveInversa.put('h', 'A');
        chiaveInversa.put('f', 'B');
        chiaveInversa.put('G', 'C');
        chiaveInversa.put('I', 'D');
        chiaveInversa.put('M', 'E');
        chiaveInversa.put('O', 'F');
        chiaveInversa.put('b', 'G');
        chiaveInversa.put('l', 'H');
        chiaveInversa.put('e', 'I');
        chiaveInversa.put('d', 'J');
        chiaveInversa.put('N', 'K');
        chiaveInversa.put('o', 'L');
        chiaveInversa.put('F', 'M');
        chiaveInversa.put('c', 'N');
        chiaveInversa.put('i', 'O');
        chiaveInversa.put('A', 'P');
        chiaveInversa.put('H', 'Q');
        chiaveInversa.put('D', 'R');
        chiaveInversa.put('a', 'S');
        chiaveInversa.put('E', 'T');
        chiaveInversa.put('C', 'U');
        chiaveInversa.put('g', 'V');
        chiaveInversa.put('B', 'W');
        chiaveInversa.put('m', 'X');
        chiaveInversa.put('L', 'Y');
        chiaveInversa.put('n', 'Z');
        chiaveInversa.put('s', 'a');
        chiaveInversa.put('T', 'b');
        chiaveInversa.put('v', 'c');
        chiaveInversa.put('p', 'd');
        chiaveInversa.put('R', 'e');
        chiaveInversa.put('y', 'f');
        chiaveInversa.put('K', 'g');
        chiaveInversa.put('z', 'h');
        chiaveInversa.put('Q', 'i');
        chiaveInversa.put('P', 'j');
        chiaveInversa.put('J', 'k');
        chiaveInversa.put('r', 'l');
        chiaveInversa.put('V', 'm');
        chiaveInversa.put('w', 'n');
        chiaveInversa.put('S', 'o');
        chiaveInversa.put('j', 'p');
        chiaveInversa.put('t', 'q');
        chiaveInversa.put('Z', 'r');
        chiaveInversa.put('k', 's');
        chiaveInversa.put('W', 't');
        chiaveInversa.put('x', 'u');
        chiaveInversa.put('Y', 'v');
        chiaveInversa.put('u', 'w');
        chiaveInversa.put('U', 'x');
        chiaveInversa.put('X', 'y');
        chiaveInversa.put('q', 'z');
    }

    public static void test() {
        System.out.println(chiave.get('A'));
    }

}

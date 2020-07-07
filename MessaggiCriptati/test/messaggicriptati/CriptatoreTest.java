/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaggicriptati;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author feder
 */
public class CriptatoreTest {
    
    public CriptatoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        Criptatore.inizializzaChiavi();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of inizializzaChiavi method, of class Criptatore.
     * @throws java.lang.Exception
     */
    @Test
    public void testInizializzaChiavi() throws Exception {
        System.out.println("inizializzaChiavi");
        Criptatore.inizializzaChiavi();
    }
    
    /**
     * Test of cripta method, of class Criptatore.
     */
    @Test
    public void testCripta() {
        System.out.println("cripta");
        String messaggio = "Messaggio Di Test";
        String expResult = "FRkksKKQS IQ E RkW";
        String result = Criptatore.cripta(messaggio);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of decripta method, of class Criptatore.
     */
    @Test
    public void testDecripta() {
        System.out.println("decripta");
        String messaggio = "FRkksKKQS IQ ERkW";
        String expResult = "Messaggio Di Test";
        String result = Criptatore.decripta(messaggio);
        assertEquals(expResult, result);
        
    }

    
}
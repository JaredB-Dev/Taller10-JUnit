/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculatorsmp;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Selim
 */
public class OperationsTest {
    
    public OperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        String expResult = "";
        String result = Operations.MakeFormula();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    //Se asume que las operaciones son entre numeros enteros
    @Test
    // @DisplayName("Validar si aplica ley de signos al momento de hacer multiplicaciones entre numeros enteros")
    public void test_LeyDeSignos() {
        System.out.println("Solve");
        String formula = "10-*10";
        
        String expResult = "-100";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    //DisplayName("Validar si permite realizar operaciones con suma y multiplicacion de numeros positivos")
    public void test_operacionNumPositivos() {
        System.out.println("Solve");
        String formula = "79+27*17";
        String expResult = "538";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    //DisplayName("Validar si identifica multiples signos iguales en la operacion")
    public void test_signosRepetidos() {
        System.out.println("Solve");
        String formula = "15+++++++++++5";
        String expResult = "20";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    @Test
    //DisplayName("Verificar si permite realizar division entre ")
    public void test_DivisionConResiduo() {
        System.out.println("Solve");
        String formula = "15/2";
        String expResult = "7.5";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    @Test
    //DisplayName("Verificar si realiza las operaciones en orden(primero division,multiplicacion,suma/resta)")
    public void test_operacionJerarquia() {
        System.out.println("Solve");
        String formula = "15/5*2";
        String expResult = "6";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    @Test
    //DisplayName("")
    public void test_DivisionParaCero() {
        System.out.println("Solve");
        String formula = "1/0";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
    
    
    
}

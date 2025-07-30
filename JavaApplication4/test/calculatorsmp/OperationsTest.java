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
    @Test
    //@DisplayName("Comprobar que el resultado de la formula no es null")
    public void testMakeFormulaNotNull() {
       String formula = Operations.MakeFormula();
       assertNotNull(formula,"El resultado de la formula generada no puede ser null");
    }
    
    @Test
    //@DisplayName("Comprobar que la formula no contiene operandos seguidos")
    public void testMakeFormulaDobleOperando(){
        String formula = Operations.MakeFormula();
        for (int i = 0; i < formula.length() - 1; i++) {
        char currentChar = formula.charAt(i);
        char nextChar = formula.charAt(i + 1);
       if ((currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') &&
            (nextChar == '+' || nextChar == '-' || nextChar == '*' || nextChar == '/'))
            fail("Se encontro fallo por operadores seguidos " + currentChar + nextChar);
        }
    }

    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula = "";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}

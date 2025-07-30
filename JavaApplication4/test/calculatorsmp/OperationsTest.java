/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculatorsmp;

import java.util.HashSet;
import java.util.Set;
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
    }

    @Test
    // @DisplayName("Comprobar que el resultado en formato String no es vacio Ex: [" "] para evitar operaciones en Solve")
    public void testMakeFormulaNoVacio() {

        System.out.println("MakeFormula");
        String result = Operations.MakeFormula();
        assertFalse("La fórmula generada está vacía", result.trim().isEmpty());

    }

    @Test
    // @DisplayName("Comprobar que el resultado en formato String es un valor numerico excluyendo los operandos, para evitar ambiguedades y operaciones invalidas en Solve")
    public void testMakeFormulaStringContieneNumeros() {
        System.out.println("MakeFormula");
        String formula = Operations.MakeFormula();

        // Recorrer cada carácter y verificar que sea un dígito o un operador permitido
        for (char c : formula.toCharArray()) {
            boolean esDigito = Character.isDigit(c);
            boolean esOperador = c == '+' || c == '-' || c == '*' || c == '/';

            assertTrue("Carácter inválido en fórmula: '" + c + "'", esDigito || esOperador);
        }
    }

    @Test
    //@DisplayName("Fórmulas generadas son aleatorias")
    public void testGeneracionAleatoria() {
        Set<String> resultados = new HashSet<>();

        resultados.add(Operations.MakeFormula());
        resultados.add(Operations.MakeFormula());
        resultados.add(Operations.MakeFormula());

        assertTrue("Las fórmulas generadas son aleatorias", resultados.size() > 1);

    }

    @Test
    //@DisplayName("Comprobar si existe en la creacion de la formula una división seguida de 0")
    public void testDivisionPorCeroDirecta() {
        String formula = Operations.MakeFormula();

        for (int i = 0; i < formula.length() - 1; i++) {
            if (formula.charAt(i) == '/') {
                int j = i + 1;
                boolean divisionPorCero = j < formula.length() && formula.charAt(j) == '0';
                assertFalse("División por cero detectada en: " + formula, divisionPorCero);
            }
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

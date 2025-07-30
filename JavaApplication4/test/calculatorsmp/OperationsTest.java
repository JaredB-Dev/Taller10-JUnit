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

    //Se asume que las operaciones son entre numeros enteros
    @Test
    // @DisplayName("Validar si aplica ley de signos al momento de hacer multiplicaciones entre numeros enteros")
    public void test_LeyDeSignos() {
        System.out.println("Solve");
        String formula = "10-*10";
        
        String expResult = "-100";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    
    @Test
    //DisplayName("Validar si permite realizar operaciones con suma y multiplicacion de numeros positivos")
    public void test_operacionNumPositivos() {
        System.out.println("Solve");
        String formula = "79+27*17";
        String expResult = "538";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    
    @Test
    //DisplayName("Validar si identifica multiples signos iguales en la operacion")
    public void test_signosRepetidos() {
        System.out.println("Solve");
        String formula = "15+++++++++++5";
        String expResult = "20";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    @Test
    //DisplayName("Verificar si permite realizar division cuyo resultado den residuo")
    public void test_DivisionConResiduo() {
        System.out.println("Solve");
        String formula = "15/2";
        String expResult = "7.5";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    @Test
    //DisplayName("Verificar si realiza las operaciones en orden(primero division,multiplicacion,suma/resta)")
    public void test_operacionJerarquia() {
        System.out.println("Solve");
        String formula = "15/5*2";
        String expResult = "6";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    @Test
    //DisplayName("Verificar Division Para Cero")
    public void test_DivisionParaCero() {
        System.out.println("Solve");
        String formula = "1/0";
        String expResult = "";
        String result = Operations.Solve(formula);
        assertEquals(expResult, result);
    }
    
}

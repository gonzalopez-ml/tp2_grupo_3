package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

public class MatrizAdyacenciaTest {
	private MatrizAdyacencia matriz;
	
	@Before
	public void Antes() {
		System.out.println("Comienza test");
		matriz = new MatrizAdyacencia(4);		
	}
	//a. Crear un metodo llamado agregarElementoTest, que verifique que
	//  luego de agregar un elemento este elemento exista dentro de la matriz
	
	@Test
	public void agregarElementoTest() {		 
		
		matriz.agregarElemento(1, 3);
		int cant = matriz.getCantidadElementos();
		assertEquals(1, cant);
	}
	
	// b. Crear un metodo llamado agregarElementoSimetriaTest, que
	// verifique que luego de agregar un elemento, ese exista en su posicion
	// opuesta/simetrica. Ejemplo, si agrego un elemento en la posicion [2,3],
	// verificar que se haya agregado el elemento [3,2]
	
	@Test
	public void agregarElementoSimetriaTest() {		
		matriz.agregarElemento(2, 3);
		boolean exist = matriz.existeElemento(3, 2);
		assertTrue(exist);
	}
	
	/* 
	 c. Crear un metodo llamado eliminarElementoTest, que verifique que
		  luego de eliminar un elemento este elemento no exista dentro de la
		  matriz*/

	
	@Test
	public void eliminarElementoTest() {
		matriz.agregarElemento(1, 3);
		matriz.eliminarElemento(1, 3);
		int cant = matriz.getCantidadElementos();
		assertEquals(0, cant);
	}

/* 
	d. Crear un método llamado eliminarElementoSimetricoTest, que 	verifique que luego de eliminar un elemento también elimine su simétrico.
	Ejemplo, si elimino el elemento de la posición [2,3], verificar que se haya
	eliminado el elemento [3,2] */
	@Test
	public void eliminarElementoSimetricoTest() {
		
		matriz.agregarElemento(2, 3);
		matriz.eliminarElemento(2, 3);
		assertFalse(matriz.existeElemento(2, 3));
		assertFalse(matriz.existeElemento(3, 2));
	}
	/*
	e. Crear un método llamado contarRelacionesTest que verifique que el método getCantidadRelaciones de la clase MatrizAdyacencia. Ejemplo:
Si agregamos tres elementos [2,3] [1,4] y [1,2] ... hay un total de tres relaciones. */
	@Test
	public void contarRelacionesTest() {
		matriz = new MatrizAdyacencia(5);		
	    matriz.agregarElemento(2, 3);
	    matriz.agregarElemento(1, 4);
	    matriz.agregarElemento(1, 2);
	    int cantidadRelaciones = matriz.getCantidadElementos();
	    assertEquals(3, cantidadRelaciones);
	}
	
	/*
	f. Crear un método llamado existenTodosLosElementoTest Verificar que si se completan todos las posiciones de la matriz, todos estos elementos
se hayan guardado correctamente en su posición original y en su simetrico. */
	@Test
	public void existenTodosLosElementoTest() {
		
		matriz.agregarElemento(0, 1);
		matriz.agregarElemento(0, 2);
		matriz.agregarElemento(0, 3);
		matriz.agregarElemento(1, 2);
		matriz.agregarElemento(1, 3);
		matriz.agregarElemento(2, 3);

		assertEquals(6, matriz.getCantidadElementos());

		assertTrue(matriz.existeElemento(0, 1));
		assertTrue(matriz.existeElemento(1, 0));
		assertTrue(matriz.existeElemento(0, 2));
		assertTrue(matriz.existeElemento(2, 0));
		assertTrue(matriz.existeElemento(0, 3));
		assertTrue(matriz.existeElemento(3, 0));
		assertTrue(matriz.existeElemento(1, 2));
		assertTrue(matriz.existeElemento(2, 1));
		assertTrue(matriz.existeElemento(1, 3));
		assertTrue(matriz.existeElemento(3, 1));
		assertTrue(matriz.existeElemento(2, 3));
		assertTrue(matriz.existeElemento(3, 2));
	}		  

	
	/*
	 g. Crear un metodo llamado agregarElementoFilaNegativaTest
		que verifique que, si uno quiere agregar un elemento en una fila
		negativa, este arroje una excepcion.*/
	
	@Test(expected = IndexOutOfBoundsException.class) 
	public void agregarElementoFilaNegativaTest(){
		matriz.agregarElemento(-1, 3);
	}

/*
	 h. Crear un método llamado agregarElementoColumnaNegativaTest
que verifique que, si uno quiere agregar un elemento en una columna
negativa, éste arroje una excepción.
*/

    @Test(expected = IndexOutOfBoundsException.class) 
	public void agregarElementoColumnaNegativaTest(){
		matriz.agregarElemento(1, -3);
	}
    
    
/*
 * Crear un método llamado agregarElementoFueraRangoTest que
	verifique que, si uno quiere agregar un elemento en una columna fuera
	del rango, éste arroje una excepción. Ejemplo: si tenemos una matriz de
	2x2,(dos filas, dos columnas) probar que si uno quiere agregar en la
	columna 3 o fila 3, se arroje una excepción
 
 */
    
    
	@Test(expected = IndexOutOfBoundsException.class) 
	public void agregarElementoFueraRangoTest() {
		
		matriz.agregarElemento(5, 5);

	}		

}

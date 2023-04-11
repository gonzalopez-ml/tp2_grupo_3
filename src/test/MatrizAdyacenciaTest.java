package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

public class MatrizAdyacenciaTest {
	
	
	//a. Crear un método llamado agregarElementoTest, que verifique que
	//  luego de agregar un elemento este elemento exista dentro de la matriz
	
	@Test
	public void agregarElementoTest() {
		MatrizAdyacencia matriz = new MatrizAdyacencia(4);
		
		matriz.agregarElemento(1, 3);
		int cant = matriz.getCantidadElementos();
		assertEquals(1, cant);
	}
	
	// b. Crear un método llamado agregarElementoSimetriaTest, que
	// verifique que luego de agregar un elemento, ese exista en su posición
	// opuesta/simétrica. Ejemplo, si agrego un elemento en la posición [2,3],
	// verificar que se haya agregado el elemento [3,2]
	
	@Test
	public void agregarElementoSimetriaTest() {
		MatrizAdyacencia matriz = new MatrizAdyacencia(4);
		
		matriz.agregarElemento(2, 3);
		boolean exist = matriz.existeElemento(3, 2);
		assertTrue(exist);
	}

}

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
	 g. Crear un metodo llamado agregarElementoFilaNegativaTest
		que verifique que, si uno quiere agregar un elemento en una fila
		negativa, este arroje una excepcion.*/
	
	@Test(expected = IndexOutOfBoundsException.class) 
	public void agregarElementoFilaNegativaTest(){
		matriz.agregarElemento(-1, 3);
	}

}

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class UtilidadesTest {

	@Test
	void testPedirCadena() {
		String cadena = Utilidades.PedirCadena("Escribe una cadena ");
		String cadena2 ="hola";
		assertTrue(cadena.equals(cadena2));
	}

	
	@SuppressWarnings("deprecation")
	@Test
	void testPedirNumero() {
		int num1 = Utilidades.PedirNumero("Escribe un numero ");
		int num2 = 5;
		assertEquals(num1, num2);
		
		assertFalse(num1 != num2);
		
		
	}

	@Test
	void testFormateafechas() {
		 Utilidades.Formateafechas("2010-10-01");
		 
	}

	@Test
	void testCrearfechas() {
		LocalDate fechaCreada = Utilidades.Crearfechas();
		assertEquals("2020, 01, 01", fechaCreada);
		
		
	}

	

}

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



class UsuarioTest {

	@Test
	void testBuscarPeli() {
		Usuario u1 = new Usuario("398749L", "Mario");
		int posicion = -1;
		int resultado = u1.BuscarPeli(Utilidades.PedirCadena(Utilidades.mensaje1));
		Assert.assertTrue(posicion == resultado);
	}
	@Test
	void testBuscarPelifalse() {
		Usuario u1 = new Usuario("398749L", "Mario");
		Pelicula p = new Pelicula(1,"Tron", "Sci-fi", LocalDate.parse("1984-01-01"));
		u1.AddPeli(p);
		int posicion = -1;
		int resultado = u1.BuscarPeli(Utilidades.PedirCadena(Utilidades.mensaje1));
		Assert.assertFalse(posicion == resultado);
	}


	@Test
	void testBorrarPeli() {
		Usuario u1 = new Usuario("398749L", "Mario");
		Pelicula p = new Pelicula(1,"Tron", "Sci-fi", LocalDate.parse("1984-01-01"));
		u1.AddPeli(p);
		int posicion = -1;
		u1.BorrarPeli(u1.BuscarPeli(Utilidades.PedirCadena(Utilidades.mensaje1)));
		int resultado = u1.BuscarPeli(Utilidades.PedirCadena(Utilidades.mensaje1));
		Assert.assertFalse(posicion != resultado);
	}

}

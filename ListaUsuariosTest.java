import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ListaUsuariosTest {

	@Test
	void testBusquedaUsuario() {
		ListaUsuarios lu = new ListaUsuarios();
		int num = -1;
		int num2 = lu.BusquedaUsuario("Lola");
		assertEquals(num, num2);
	}
	
/*
	@Test
	void testMostrarBusquedaUsuario() {
		ListaUsuarios lu = new ListaUsuarios();
		lu.AddUsuario(new Usuario("90808Y", "Pepe"));
		//lu.MostrarBusquedaUsuario(lu.BusquedaUsuario("Pepe"));
		//("Usuario [dni=90808Y, nombreUsuario=Pepe, misPelis=[]]", lu.MostrarBusquedaUsuario(lu.BusquedaUsuario("Pepe")));
		assetTrue(("Usuario [dni=90808Y, nombreUsuario=Pepe, misPelis=[]]").equals("lu.MostrarBusquedaUsuario(lu.BusquedaUsuario(\"Pepe\"))");
		
	}
*/
	@Test
	void testObtenerUsuario() {
		ListaUsuarios lu = new ListaUsuarios();
		lu.AddUsuario(new Usuario("90808Y", "Pepe"));
		String cadena1 = "Pepe";
		String cadena2 = lu.ObtenerUsuario("Pepe");
		assertTrue(cadena1.equals(cadena2));
	}

	@Test
	void testAddPeliUsuario() {
		ListaUsuarios lu = new ListaUsuarios();
		Pelicula p =new Pelicula(1, "Tron", "scifi",LocalDate.parse("1986-01-01"));
		lu.AddUsuario(new Usuario("90808Y", "Pepe"));
		lu.AddPeliUsuario("Pepe",  p);
		String actual = lu.toString();
		String esperado = "ListaUsuarios [misSocios=[Usuario [dni=90808Y, nombreUsuario=Pepe, misPelis=[Pelicula [idPelicula=1, nombre=Tron, genero=scifi, fechaEstreno=1986-01-01]]]]]\r\n"
				+ "";
		assertTrue(actual.equals(esperado));
	}
/*
	@Test
	void testUpdateUsuario() {
		fail("Not yet implemented");
	}
	/*
	@Test
	void testDeleteUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testBusquedaPeliUser() {
		fail("Not yet implemented");
	}

	@Test
	void testBorrarPeliUser() {
		fail("Not yet implemented");
	}
*/
}

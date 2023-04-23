import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ListaPeliculasTest {

	@Test
	void testAddPeliculaCartelera() {
		ListaPeliculas lp = new ListaPeliculas();
		Pelicula p = new Pelicula(3, "Tron", "Sci-fi", LocalDate.parse("1984-01-01"));
		lp.AddPeliculaCartelera(p);
		Pelicula p2 = lp.ObtenerPelicula();
		Assert.assertEquals(p, p2);
		assertTrue(p.equals(p2));
	}

	@Test
	void testSearchPeliculaCartelera() {
		Pelicula p = new Pelicula(2, "Star Wars", "Sci-fi", LocalDate.parse("1977-10-12"));
		ListaPeliculas lp = new ListaPeliculas();
		lp.AddPeliculaCartelera(p);
		Pelicula p2 = lp.ObtenerPelicula();
		Assert.assertEquals(p, p2);
	}


	@Test
	void testBuscarUltimoIDCartelera() {
		Pelicula p = new Pelicula(2, "Star Wars", "Sci-fi", LocalDate.parse("1977-10-12"));
		ListaPeliculas lp = new ListaPeliculas();
		lp.AddPeliculaCartelera(p);
		int posicionDeseada = 1;
		int resultado = lp.BuscarUltimoIDCartelera();
		Assert.assertTrue(posicionDeseada != resultado);
	}
	@Test
	void testDeletePeliculaCartelera() {
		ListaPeliculas lp = new ListaPeliculas();
		Pelicula p = new Pelicula(1, "Tron", "Sci-fi", LocalDate.parse("1984-01-01"));
		Pelicula p2 = new Pelicula(2, "Cristal Oscuro", "fantasia", LocalDate.parse("1984-01-01"));
		lp.AddPeliculaCartelera(p);
		lp.AddPeliculaCartelera(p2);
		lp.DeletePeliculaCartelera(1);
		Pelicula p3 =lp.ObtenerPelicula();
		assertTrue(p.equals(p3));
	}

}

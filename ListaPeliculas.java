
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaPeliculas {
	private ArrayList<Pelicula> cartelera = new ArrayList<Pelicula>();

	public ListaPeliculas() {
		super();
	}

	public ArrayList<Pelicula> getCartelera() {
		return cartelera;
	}

	public void setCartelera(ArrayList<Pelicula> cartelera) {
		this.cartelera = cartelera;
	}

	@Override
	public String toString() {
		return "ListaPeliculas [cartelera=" + cartelera + "]";
	}
//---------------------- CREAR/AÑADIR PELÍCULA A LA LISTA
	public Pelicula CrearPelicula() {
		String titulo = Utilidades.PedirCadena(Utilidades.mensaje1);
		String genero = Utilidades.PedirCadena(Utilidades.mensaje5);
		LocalDate fecha = LocalDate.parse("1900-01-01");
		try{
		 fecha = Utilidades.Crearfechas();
		}catch(java.time.format.DateTimeParseException e) {
			System.out.println("La fecha introducida es incorrecta. Por favor intentelo de nuevo");
			CrearPelicula();
			
		}
		int id = BuscarUltimoIDCartelera();
		id +=1;
		Pelicula p = new Pelicula(id, titulo, genero, fecha);
		return p;
	}
	//--------------------AÑADIR PELICULA A LA LISTA -----------------
	
	public void AddPeliculaCartelera(Pelicula p) {
		cartelera.add(p);
		
	}
//-------------------------OBTENER UNA PELICULA
	public Pelicula ObtenerPelicula() {
		String cadena = Utilidades.PedirCadena(Utilidades.mensaje1);
		int posicion = SearchPeliculaCartelera(cadena);
		Pelicula p = new Pelicula(cartelera.get(posicion).getIdPelicula(), cartelera.get(posicion).getNombre(),
				cartelera.get(posicion).getGenero(), cartelera.get(posicion).getFechaEstreno());
		return p;

	}

	//--------------------------BUSCAR POR CADENA
	
	public int SearchPeliculaCartelera(String cadena) {
		int i = 0;
		int posicion = -1;
		boolean interruptor = true;
		while (interruptor && i < cartelera.size()) {
			if (cartelera.get(i).getNombre().equals(cadena)) {
				System.out.println("Película en la lista");
				posicion = i;
				interruptor = false;
			} else if (cartelera.get(i).getGenero().equals(cadena)) {
				System.out.println("Película en la lista");
				posicion = i;
				interruptor = false;
			} else {
				i++;
			}
		}
		
		return posicion;
	}
	//------------------ MOSTRAR BÚSQUEDA CADENA (título y género)
	
	public void MostrarBusquedaPeli(String cadena) {
		cadena = Utilidades.PedirCadena(Utilidades.mensaje1);
		int posicion = SearchPeliculaCartelera(cadena);
		if (posicion != -1) {
			System.out.println(cartelera.get(posicion));
		} else {
			System.out.println("La pelìcula no está en la base de datos.");
		}
	}

	//------------------------- BUSCAR POR IDPELICULA
	
	public void SearchPeliculaCartelera(int num) {
		int i = 0;
		boolean interruptor = true;
		while (interruptor && i < cartelera.size()) {
			if (cartelera.get(i).getIdPelicula() == num) {
				System.out.println("Película en la lista");
				interruptor = false;
			} else {
				i++;
			}
		}
		if (i == cartelera.size()) {
			System.out.println("Película no encontrada");
		}
	}

	//-----------------------BUSCAR LA ÚLTIMA PELICULA AÑADIDA
	public int BuscarUltimoIDCartelera() {
		int i = cartelera.size()-1;
		int posicion = -1;
		posicion = cartelera.get(i).getIdPelicula();
		return posicion;
		
	}
	
	//--------------------BUSCAR POR FECHA
	
	public void SearchPeliculaCartelera(LocalDate fecha) {
		int i = 0;
		boolean interruptor = true;
		while (interruptor && i < cartelera.size()) {
			
			if (cartelera.get(i).getFechaEstreno().equals(fecha)) {
				System.out.println("Película en la lista");
				interruptor = false;
			} else {
				i++;
			}
		}
		if (i == cartelera.size()) {
			System.out.println("Película no encontrada");
		}
	}
	//----------------------------------------
	public void UpdatePeliculaCartelera() {
		int posicion = SearchPeliculaCartelera(Utilidades.PedirCadena(Utilidades.mensaje1));
		if (posicion != -1) {
			boolean condicion = true;
			while (condicion) {
				try {
					
					String NEWnombrePelicula = Utilidades.PedirCadena(Utilidades.mensaje1);
					String NEWgenero = Utilidades.PedirCadena(Utilidades.mensaje5);
					LocalDate NEWfechaEstreno = Utilidades.Crearfechas();
					cartelera.get(posicion).setNombre(NEWnombrePelicula);
					cartelera.get(posicion).setGenero(NEWgenero);
					cartelera.get(posicion).setFechaEstreno(NEWfechaEstreno);
					System.out.println("Película actualizada");
					condicion = false;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Error al introducir datos. pruebe de nuevo");
				}
			}
		} else {
			System.out.println("Película no encontrada");
		}
	}

	//----------------------DELETE película
	public void DeletePeliculaCartelera(String cadena) {
		int posicion = SearchPeliculaCartelera(Utilidades.PedirCadena(Utilidades.mensaje1));
		if (posicion != -1) {
			cartelera.remove(posicion);
			System.out.println("La película ha sido borrada de la cartelera");
		} else {
			System.out.println("La película no está en la cartelera");
		}
	}

}


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
	/**
	 * 
	 * @return un objeto de tipo Pelicula
	 * Pide datos para generar una película. Utiliza la clase utilidades para crear la fecha. 
	 */
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
	/**
	 * 
	 * @param p
	 * Requiere un parámetro que sea un objeto de la clase Pelicula. Lo añade a la cartelera.
	 */
	
	public void AddPeliculaCartelera(Pelicula p) {
		cartelera.add(p);
		
	}
//-------------------------OBTENER UNA PELICULA
	/**
	 * 
	 * @return un objeto de la clase Pelicula
	 * Busca una película en el ArrayList ListaPeliculas, si lo obtiene lo retorna, si no retorna la lista.
	 */
	public Pelicula ObtenerPelicula() {
		
		String cadena = Utilidades.PedirCadena(Utilidades.mensaje1);
		int posicion = SearchPeliculaCartelera(cadena);
		
		while(posicion == -1) {
			System.out.println("La pelicula no está en la lista. A continuación le mostramos la cartelera para que pueda elegir:");
			System.out.println(cartelera.toString());
			 cadena = Utilidades.PedirCadena(Utilidades.mensaje1);
			posicion = SearchPeliculaCartelera(cadena);
		}

		Pelicula p = new Pelicula(cartelera.get(posicion).getIdPelicula(), cartelera.get(posicion).getNombre(),
				cartelera.get(posicion).getGenero(), cartelera.get(posicion).getFechaEstreno());

		return p;
		
	}
	
	//-------------------------OBTENER UNA PELICULA RANDOM
	/**
	 * 
	 * @return un objeto de la clase película.
	 * Lo hace utilizando una función random.
	 */
	public Pelicula ObtenerPeliculaRandom() {
		int posicion = (int) (Math.random() * cartelera.size() + 0);
		Pelicula p = new Pelicula(cartelera.get(posicion).getIdPelicula(), cartelera.get(posicion).getNombre(),
				cartelera.get(posicion).getGenero(), cartelera.get(posicion).getFechaEstreno());
		return p;
	}

	//--------------------------BUSCAR POR CADENA
	/**
	 * 
	 * @param cadena  en el ArrayList cartelera.
	 * @return la posición de la cadena en el ArrayList cartelera.
	 */
	
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
	/**
	 * 
	 * @param posicion  en el ArrayList cartelera.
	 * Imprime la posición o un mensaje de película no encontrada.
	 */
	public void MostrarBusquedaPeli(int posicion) {
		
		//cadena = Utilidades.PedirCadena(Utilidades.mensaje1);
		//int posicion = SearchPeliculaCartelera(cadena);
		if (posicion != -1) {
			System.out.println(cartelera.get(posicion));
		} else {
			System.out.println("La pelìcula no está en la base de datos.");
		}
	}

	//-----------------------BUSCAR LA ÚLTIMA PELICULA AÑADIDA
	/**
	 * 
	 * @return la posición del id de la última película en el ArrayList cartelera.
	 */
	public int BuscarUltimoIDCartelera() {
		int i = cartelera.size()-1;
		int posicion = -1;
		posicion = cartelera.get(i).getIdPelicula();
		return posicion;
	}

	//------------------------------- UPDATE PELI
	/**
	 * 
	 * @param posicion  en el ArrayList cartelera.
	 * @return posicion  en el ArrayList cartelera.
	 * recibe la posicion, ejecuta la actualización si la posción es diferente de - 1 en el ArrayList cartelera, y retorna la posicion modificada.
	 */
	public int UpdatePeliculaCartelera(int posicion) {
		if (posicion != -1) {
			boolean condicion = true;
			while (condicion) {
				try {
					
					String NEWnombrePelicula = Utilidades.PedirCadena(Utilidades.mensaje9);
					String NEWgenero = Utilidades.PedirCadena(Utilidades.mensaje10);
					LocalDate NEWfechaEstreno = Utilidades.Crearfechas();
					cartelera.get(posicion).setNombre(NEWnombrePelicula);
					cartelera.get(posicion).setGenero(NEWgenero);
					cartelera.get(posicion).setFechaEstreno(NEWfechaEstreno);
					System.out.println("Película actualizada");
					condicion = false;
				} catch (java.util.InputMismatchException e) {
					System.out.println("Error al introducir datos. pruebe de nuevo");
				}catch (Exception e) {
				      System.out.println("Error al introducir datos. pruebe de nuevo");
			    }
			}
		} else {
			System.out.println("Película no encontrada");
		}
		return posicion;
	}

	//----------------------DELETE película
	/**
	 * 
	 * @param posicion  en el ArrayList cartelera.
	 * Recibe un parámetro posicion y si es diferente a - 1, ejecuta el borrado.
	 */
	public void DeletePeliculaCartelera(int posicion) {
		
		if (posicion != -1) {
			cartelera.remove(posicion);
			System.out.println("La película ha sido borrada de la cartelera");
		} else {
			System.out.println("La película no está en la cartelera");
		}
	}

}

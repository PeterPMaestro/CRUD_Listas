import java.util.ArrayList;

public class ListaUsuarios {
	private ArrayList<Usuario> misSocios = new ArrayList<Usuario>();

	public ListaUsuarios() {
		super();
	}

	public ArrayList<Usuario> getMisSocios() {
		return misSocios;
	}

	public void setMisSocios(ArrayList<Usuario> misSocios) {
		this.misSocios = misSocios;
	}

	@Override
	public String toString() {
		return "ListaUsuarios [misSocios=" + misSocios + "]";
	}

	// ----------------------- CREAR UN USUARIO
	/**
	 * 
	 * @param u
	 * Recibe como par�metro un objeto de la clase Usuario
	 * A�ade ese objeto al ArrayList misSocios.
	 */

	public void AddUsuario(Usuario u) {
		misSocios.add(u);
	}
	/**
	 * No recibe par�metros
	 * @return un objeto de la clase Usuario.
	 */
	public Usuario PedirUsuario() {
		String dni = Utilidades.PedirCadena("Escriba el dni del nuevo usuario: ");
		String nombre = Utilidades.PedirCadena("Escriba el nombre del nuevo usuario: ");
		Usuario u1 = new Usuario(dni,nombre);
		return u1;		
	}

//------------------------------ METODO DE B�SQUEDA USUARIO
	/**
	 * 
	 * @param cadena
	 * @return un int, una posici�n o bien del ArrayList MisSocios o bien -1 si no lo ha encontrado.
	 */
	public int BusquedaUsuario(String cadena) {
		int posicion = -1;
		int i = 0;
		boolean interruptor = true;
		while (interruptor && i < misSocios.size()) {
			if (misSocios.get(i).getNombreUsuario().equals(cadena)) {
				posicion = i;
				interruptor = false;
			} else if (misSocios.get(i).getDni().equals(cadena)) {
				posicion = i;
				interruptor = false;
			} else {
				i++;
			}
		}
		return posicion;
	}

	// ------------------ MOSTRAR BUSQUEDA DE USUARIO
	/**
	 * 
	 * @param posicion
	 * Recibe un par�metro de posici�n del usuario e imprime por pantalla, si est�, esa posici�n del arrayList MisSocios.
	 */
	
	public void MostrarBusquedaUsuario(int posicion) {
		if(posicion != -1 && posicion< misSocios.size()) {
		System.out.println(misSocios.get(posicion).toString());
		}
		else {
			System.out.println("El socio no est� en la base de datos");
		}
	}
	
	//-------------------OBTENER USUARIO
	/**
	 * 
	 * @param cadena
	 * @return retorna la cadena y un mensaje tanto si el usuario se encuentra como si no.
	 */
	public String ObtenerUsuario(String cadena) {
		int posicion = BusquedaUsuario(cadena);
		if (posicion != -1) {
			System.out.println("El socio est� en la base de datos");
		} else {
			System.out.println("El socio no est� en la base de datos");
		}
		return cadena;
	}

	// ----------------------- A�ADIR PELI A USUARIO DE LA CARTELERA
	/**
	 * 
	 * @param cadena
	 * @param p
	 * Este m�todo recibe una cadena, que va a buscar en usuarios, y una pelicula que a�adir� a ese usuario.
	 */
	public void AddPeliUsuario(String cadena, Pelicula p) {
		int posicion = BusquedaUsuario(cadena);
		if (posicion != -1) {
			misSocios.get(posicion).AddPeli(p);
		} else {
			System.out.println("El socio no est� en la base de datos");
		}

	}

	// --------------------UPDATE DATOS USUARIO  
	/**
	 * 
	 * @param posicion
	 * @return la posicion
	 * Recibe un par�metro que indica la posicion que debe modificar. Si el par�metro es - 1 no se ejecuta la modificaci�n.
	 * Devuelve la posicion que se ha modificado en forma de int.
	 */
	public int UpdateUsuario(int posicion) {
		int posicion1 = posicion;
		if (posicion != -1) {
			String NEWdni = Utilidades.PedirCadena(Utilidades.mensaje7);
			String NEWnombreUser = Utilidades.PedirCadena(Utilidades.mensaje8);
			misSocios.get(posicion).setDni(NEWdni);
			misSocios.get(posicion).setNombreUsuario(NEWnombreUser);
			System.out.println(misSocios.get(posicion));
		} 
		return posicion1;
	}

	// -------------------------DELETE USUARIO 
	/**
	 * 
	 * @param posicion
	 * Recibe un int como par�metro que indica la posici�n que se debe borrar, si es - 1 no ejecuta el borrado. Imprime un mensaje con el resultado.
	 */
	public void DeleteUsuario(int posicion) {
		
		if (posicion != -1) {
			System.out.println("Usuario borrado");
			misSocios.remove(posicion);
		} else {
			System.out.println("El socio no est� en la base de datos");
		}
	}


	// ------------------------ BUSCAR PELICULA EN USUARIO
	/**
	 * 
	 * @param cadena
	 * @param nombreUsuario
	 * Recibe dos par�metros, una cadena que utilizar� para buscar en el ArrayList de ListaPeliculas y otra cadena que utilizar� para buscar
	 * en el ArrayList ListaUsuarios.
	 * Muestra los resultados de esa b�squeda por pantalla.
	 */
	public void BusquedaPeliUser(String cadena, String nombreUsuario) {
		int posicion = -1;
		int posicionU = BusquedaUsuario(nombreUsuario);
		if (posicionU != -1) {
			posicion = misSocios.get(posicionU).BuscarPeli(cadena);
			if (posicion != -1) {
				System.out.println("La pel�cula est� en la lista de pel�culas de " + nombreUsuario);
				misSocios.get(posicionU).MostrarBuscarPeli(posicion);
			} else {
				System.out.println("La pel�cula no est� en la lista de pel�culas de " + nombreUsuario);
			}
		} else {
			System.out.println("La pel�cula no est� en su lista de pel�culas.");
		}
	}

	// -----------------------------DELETE PELI EN USUARIO
	/**
	 * 
	 * @param cadena
	 * @param nombreUsuario
	 * Recibe dos par�metros, una cadena que utilizar� para buscar en el ArrayList de ListaPeliculas y otra cadena que utilizar� para buscar
	 * en el ArrayList ListaUsuarios.
	 * Ejecuta o no el borrado y muestra los resultados de esa b�squeda por pantalla.
	 */

	public void BorrarPeliUser(String cadena, String nombreUsuario) {
		int posicion = -1;
		int posicionU = BusquedaUsuario(nombreUsuario);
		if (posicionU != -1) {
			posicion = misSocios.get(posicionU).BuscarPeli(cadena);
			if (posicion != -1) {
				System.out.println("La pel�cula se borrar� de la lista de pel�culas de " + nombreUsuario);
				misSocios.get(posicion).BorrarPeli(posicion);
			} else {
				System.out.println("La pel�cula no est� en la lista de pel�culas de " + nombreUsuario);
			}
		} else {
			System.out.println("El Usuario no est� en su lista.");
		}
	}

}

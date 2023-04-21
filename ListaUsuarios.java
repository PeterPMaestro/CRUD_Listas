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

	public void AddUsuario(Usuario u) {
		misSocios.add(u);
	}
	public Usuario PedirUsuario() {
		String dni = Utilidades.PedirCadena("Escriba el dni del nuevo usuario");
		String nombre = Utilidades.PedirCadena("Escriba el nombre del nuevo usuario");
		Usuario u1 = new Usuario(dni,nombre);
		return u1;		
	}

//------------------------------ METODO DE BÚSQUEDA USUARIO
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

	// ------------------ MOSTRAR BUSQUEDA
	
	public void MostrarBusquedaUsuario(int posicion) {
		if(posicion != -1) {
		System.out.println(misSocios.get(posicion).toString());
		}
		else {
			System.out.println("El socio no está en la base de datos");
		}
	}
	
	//-------------------OBTENER USUARIO
	public String ObtenerUsuario(String cadena) {
		String usuario = "";
		int posicion = BusquedaUsuario(cadena);
		if (posicion != -1) {
			usuario = misSocios.get(posicion).toString();
		} else {
			System.out.println("El socio no está en la base de datos");
		}
		return usuario;
	}

	// ----------------------- AÑADIR PELI A USUARIO DE LA CARTELERA
	// ------------------

	public void AddPeliUsuario(String cadena, Pelicula p) {
		int posicion = BusquedaUsuario(cadena);
		if (posicion != -1) {
			misSocios.get(posicion).AddPeli(p);
		} else {
			System.out.println("El socio no está en la base de datos");
		}

	}

	// --------------------UPDATE DATOS USUARIO
	public void UpdateUsuario(int posicion) {
		if (posicion != -1) {
			String NEWdni = Utilidades.PedirCadena(Utilidades.mensaje3);
			String NEWnombreUser = Utilidades.PedirCadena(Utilidades.mensaje2);
			misSocios.get(posicion).setDni(NEWdni);
			misSocios.get(posicion).setNombreUsuario(NEWnombreUser);
			System.out.println(misSocios.get(posicion));
		} else {
			System.out.println("El socio no está en la base de datos");
		}
	}

	// -------------------------DELETE USUARIO
	public void DeleteUsuario(String cadena) {
		int posicion = BusquedaUsuario(cadena);
		if (posicion != -1) {
			misSocios.remove(posicion);
		} else {
			System.out.println("El socio no está en la base de datos");
		}
	}


	// ------------------------ BUSCAR PELICULA EN USUARIO
	public void BusquedaPeliUser(String cadena, String nombreUsuario) {
		int posicion = -1;
		int posicionU = BusquedaUsuario(nombreUsuario);
		if (posicionU != -1) {
			posicion = misSocios.get(posicionU).BuscarPeli(cadena);
			if (posicion != -1) {
				System.out.println("La película está en la lista de películas de " + nombreUsuario);
				misSocios.get(posicionU).MostrarBuscarPeli(posicion);
			} else {
				System.out.println("La película no está en la lista de películas de " + nombreUsuario);
			}
		} else {
			System.out.println("La película no está en su lista de películas.");
		}
	}

	// -----------------------------DELETE PELI EN USUARIO

	public void BorrarPeliUser(String cadena, String nombreUsuario) {
		int posicion = -1;
		int posicionU = BusquedaUsuario(nombreUsuario);
		if (posicionU != -1) {
			posicion = misSocios.get(posicionU).BuscarPeli(cadena);
			if (posicion != -1) {
				System.out.println("La película se borrará de la lista de películas de " + nombreUsuario);
				misSocios.get(posicion).BorrarPeli(posicion);
			} else {
				System.out.println("La película no está en la lista de películas de " + nombreUsuario);
			}
		} else {
			System.out.println("El Usuario no está en su lista.");
		}
	}

}

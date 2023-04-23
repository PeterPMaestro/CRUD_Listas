import java.util.ArrayList;

public class Usuario {
	private String dni;
	private String nombreUsuario;
	
	private ArrayList<Pelicula> misPelis = new ArrayList<Pelicula>();

	public Usuario(String dni, String nombreUsuario) {
		super();
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public ArrayList<Pelicula> getMisPelis() {
		return misPelis;
	}

	public void setMisPelis(ArrayList<Pelicula> misPelis) {
		this.misPelis = misPelis;
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombreUsuario=" + nombreUsuario + ", misPelis=" + misPelis + "]";
	}
	//------------------
	
	public void AddPeli(Pelicula p) {
		misPelis.add(p);
	}
//------------------------BUSCAR EN MIS PELIS
	public int BuscarPeli(String cadena) {
		int posicionPeli = -1;
		int i = 0;
		boolean interruptor = true;

		while (interruptor && i < misPelis.size()) {
			// System.out.println();
			if (misPelis.get(i).getNombre().equals(cadena)) {
				posicionPeli = i;
				interruptor = false;

			} else {
				i++;
			}
		}
		return posicionPeli;
	}
//--------------------------MOSTRAR
	public void MostrarBuscarPeli(int posicion) {
		if (posicion != -1) {
			System.out.println(misPelis.get(posicion));
		} else {
			System.out.println("La peli no está en tu lista");
		}
	}
	public void BorrarPeli(int posicion) {
		if (posicion != -1) {
			System.out.println(misPelis.remove(posicion));
		} else {
			System.out.println("La peli no está en tu lista");
		}
	}
}

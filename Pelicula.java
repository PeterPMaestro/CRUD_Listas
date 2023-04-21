import java.time.LocalDate;

public class Pelicula {
	private int idPelicula;
	private String nombrePelicula;
	private String genero;
	private LocalDate fechaEstreno;
	
	public Pelicula(int idPelicula, String nombrePelicula, String genero, LocalDate fechaEstreno) {
		super();
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.genero = genero;
		this.fechaEstreno = fechaEstreno;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {
		return nombrePelicula;
	}

	public void setNombre(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", nombre=" + nombrePelicula + ", genero=" + genero + ", fechaEstreno="
				+ fechaEstreno + "]";
	}
	
	
	
}

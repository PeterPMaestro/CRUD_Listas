import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posicion = -1;
		String eleccion = "";
		String eleccion2 = "";
		String eleccion3 = "";
		boolean boton3 = true;
		boolean boton2 = true;
		boolean boton = true;
		ListaPeliculas listaP = new ListaPeliculas();
		ListaUsuarios lista1 = new ListaUsuarios();
			
		// DATOS DE PRUEBA
		
		lista1.AddUsuario(new Usuario("30948038L","Lola"));
		lista1.AddUsuario(new Usuario("763547653P","Pepe"));
		listaP.AddPeliculaCartelera(new Pelicula(1,"Oblivion","Sci-fi", LocalDate.parse("2013-04-15")));
		listaP.AddPeliculaCartelera(new Pelicula(2,"Star Wars","Sci-fi",LocalDate.parse("1977-10-12")));
		listaP.AddPeliculaCartelera(new Pelicula(3,"Tron","Sci-fi",LocalDate.parse("1984-10-12")));
	
		Utilidades.DiferenciaFechas(listaP.ObtenerPeliculaRandom());
		while(boton) {
			eleccion = Utilidades.PedirCadena(Utilidades.menu1);

			switch (eleccion) {
			
			case ("1"):
				while (boton2) {
					eleccion2 = Utilidades.PedirCadena(Utilidades.menu2);
					/*
					 * USUARIO
					 *"\n 1. A�adir Usuario" + "\n 2. Buscar Usuario"  + "\n 3. Mostrar Usuarios" 
							+ "\n 4. Buscar Usuario"  + "\n 4. Modificar Usuario"  + "\n 5. Insertar pel�cula en la cuenta del Usuario"
							+ "\n 6. Borrar Usuario" + "\n 7. Buscar en las pelis del usuario" +  "\n 8. Borrar una pel�cula de la lista del usuario" + "\n 9. Salir" +"\n Elija una opci�n "; 
					 * */

					switch (eleccion2) {
					case ("1"):
						lista1.AddUsuario(lista1.PedirUsuario());
						System.out.println("Usuario a�adido");
						break;
					case ("2"):
						lista1.MostrarBusquedaUsuario(lista1.BusquedaUsuario(Utilidades.PedirCadena(Utilidades.mensaje2)));
						break;
					case ("3"):
						System.out.println(lista1.toString());
						break;
					case ("4"):
						 posicion = lista1.UpdateUsuario(lista1.BusquedaUsuario(Utilidades.PedirCadena(Utilidades.mensaje2)));
						break;
					case ("5"):
						lista1.AddPeliUsuario(lista1.ObtenerUsuario(Utilidades.PedirCadena(Utilidades.mensaje2)), listaP.ObtenerPelicula());
						break;
					case ("6"):
						lista1.DeleteUsuario(lista1.BusquedaUsuario(Utilidades.PedirCadena(Utilidades.mensaje2)));
						break;
					case ("7"):
						lista1.BusquedaPeliUser(Utilidades.PedirCadena(Utilidades.mensaje1), Utilidades.PedirCadena(Utilidades.mensaje2));
						break;
					case ("8"):
						lista1.BorrarPeliUser(Utilidades.PedirCadena(Utilidades.mensaje1), Utilidades.PedirCadena(Utilidades.mensaje2));
						break;
					case ("9"):
						boton2 = false;
						break;
					default:
						System.out.println("La opci�n elegida es incorrecta, por favor elija de nuevo");
					}
				}
				break;
				
				
			case ("2"):				
				while(boton3) {
					/*
					 * PEL�CULAS EN CARTELERA
					 * "1. A�adir pel�cula a la cartelera" + "\n 2. Mostrar cartelera" + "\n 3. Buscar pel�cula" 
							+ "\n 4. Modificar pel�cula"+ "\n 5. borrar pel�cula" + "\n 6. Salir" + "\n Elija una opci�n ";
					 * */
					eleccion3 = Utilidades.PedirCadena(Utilidades.menu3);
					switch (eleccion3) {
					case ("1"):
						listaP.AddPeliculaCartelera(listaP.CrearPelicula());
						System.out.println("Pel�cula a�adida");
						break;
					case ("2"):
						System.out.println(listaP.toString());
						break;
					case ("3"):
						listaP.MostrarBusquedaPeli((listaP.SearchPeliculaCartelera(Utilidades.PedirCadena(Utilidades.mensaje1))));;
						break;
					case ("4"):
						posicion = listaP.SearchPeliculaCartelera(Utilidades.PedirCadena(Utilidades.mensaje1));
						posicion = listaP.UpdatePeliculaCartelera(posicion);
						listaP.MostrarBusquedaPeli(posicion);
						break;
					case ("5"):
						listaP.DeletePeliculaCartelera(listaP.SearchPeliculaCartelera(Utilidades.PedirCadena(Utilidades.mensaje1)));
						break;
					case ("6"):
						boton3 = false;
						break;
					}
				}
				break;
			case ("3"):
				Utilidades.sc.close();
				boton = false;
				System.out.println("PROGRAMA FINALIZADO");
				break;
			default:
				System.out.println("La opci�n elegida es incorrecta, por favor elija de nuevo");
				break;
			}

		}
	}
}

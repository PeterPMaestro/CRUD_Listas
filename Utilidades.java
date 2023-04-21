import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.text.DateFormatter;

public class Utilidades {
	static Scanner sc = new Scanner(System.in);
	static String mensaje1 = "introduzca el nombre de la pel�cula: ";
	static String mensaje2 = "introduzca el nombre del usuario o el dni: ";
	static String mensaje3 = "introduzca el dni del usuario: ";
	static String mensaje4 = "introduzca el id de la pel�cula: ";
	static String mensaje5 = "introduzca el g�nero de la pel�cula: ";
	static String mensaje6 = "introduzca la fecha de estreno de la pel�cula de la manera que se indica (2001-01-02): ";
	static String mensaje7 = "introduzca el nuevo dni del usuario: ";
	static String mensaje8 = "introduzca el nuevo nombre del usuario: ";
	static String menu1 = "\n 1. Usuarios" + "\n 2. Cartelera" + "\n 3. Salir" + "\n Elija una opci�n ";
	static String menu2 = "\n 1. A�adir Usuario" + "\n 2. Buscar Usuario"  + "\n 3. Mostrar Usuarios" 
			+  "\n 4. Update Usuario"  + "\n 5. Insertar pel�cula en la cuenta del Usuario"
			+ "\n 6. Borrar Usuario" + "\n 7. Buscar en las pelis del usuario" +  "\n 8. Borrar una pel�cula de la lista del usuario" + "\n 9. Salir" +"\n Elija una opci�n ";
	static String menu3 = "\n 1. A�adir pel�cula a la cartelera" + "\n 2. Mostrar cartelera" + "\n 3. Buscar pel�cula"
			+ "\n 4. Update pel�cula" + "\n 5. borrar pel�cula" + "\n 6. Salir" + "\n Elija una opci�n ";

	public static String PedirCadena(String mensaje) {
		System.out.print(mensaje);
		String cadena;
		cadena = sc.nextLine();
		//sc.nextLine();
		return cadena;
	}

	public static int PedirNumero(String mensaje) {
		System.out.print(mensaje);
		int num;
		num = sc.nextInt();
		//sc.nextLine();
		return num;
	}

	public static void Formateafechas(String date) {
		LocalDate fecha = LocalDate.parse(date); // Parseo String ----> LocalDate
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("YYYY, MM, dd");
		System.out.println(fecha.format(f1));
	}
	public static LocalDate Crearfechas() {
		String year = Utilidades.PedirCadena("Escriba el a�o de estreno:"); 
		String month = Utilidades.PedirCadena("Escriba el mes de estreno:");
		String day = Utilidades.PedirCadena("Escriba el d�a de estreno:");
		LocalDate fecha = LocalDate.parse(year+ "-" + month + "-" + day); // Parseo String ----> LocalDate
		
		return fecha;
	}
	public static void DiferenciaFechas(Pelicula p) {
		LocalDate fechaPeli = p.getFechaEstreno();
		LocalDate hoy = LocalDate.now();
		long resultado = ChronoUnit.YEARS.between(fechaPeli, hoy);
		JOptionPane.showMessageDialog(null, "Hoy hace " + resultado + " a�os del estreno de" + p.getNombre());
	}
	//int numero = (int)(Math.random()*10+1); // 10 es l�mite superior y 1 el inferior
}

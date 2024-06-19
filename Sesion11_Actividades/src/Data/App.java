package Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	        HashA<String> hash = new HashA<>(10);

	        hash.insert(1, "Valor 1");
	        hash.insert(11, "Valor 11");
	        hash.insert(21, "Valor 21");

	        System.out.println("Buscar clave 1: " + hash.search(1)); // Valor 1
	        System.out.println("Buscar clave 11: " + hash.search(11)); // Valor 11
	        System.out.println("Buscar clave 21: " + hash.search(21)); // Valor 21
	        System.out.println("Buscar clave 2: " + hash.search(2)); // null
	        
	        
	        
	        HashEmpleado hashEmpleado = new HashEmpleado(calcularMDesdeArchivo("EMPLEADO.TXT"));

	        // Leer el archivo EMPLEADO.TXT e insertar los empleados en la tabla hash
	        try (BufferedReader br = new BufferedReader(new FileReader("EMPLEADO.TXT"))) {
	            String linea;
	            int contador = 0;
	            while ((linea = br.readLine()) != null) {
	                if (contador > 0) { // Saltar la primera línea que tiene la cantidad de empleados
	                    String[] partes = linea.split(",");
	                    int codigo = Integer.parseInt(partes[0].trim());
	                    String nombre = partes[1].trim();
	                    String direccion = partes[2].trim();
	                    Empleado empleado = new Empleado(codigo, nombre, direccion);
	                    hashEmpleado.insertar(empleado);
	                } else {
	                    contador++;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Mostrar la tabla hash con sus respectivas direcciones hash y reales
	        hashEmpleado.mostrarTabla();
	        
	        //Para el ejerccio 6
	        
	            TablaHashCoordenadas tabla = new TablaHashCoordenadas(10);
	            tabla.insertar(1, 2, "valor1");
	            tabla.insertar(3, 4, "valor2");

	            System.out.println(tabla.buscar(1, 2)); 
	            System.out.println(tabla.buscar(3, 4)); 

	            System.out.println(tabla.eliminar(1, 2)); 
	            System.out.println(tabla.buscar(1, 2)); 
	        
	            //Para el ejercicio 5
	            
	            int[] lista = {1, 2, 3, 4, 5};
	            int suma = 6;

	            TablaHashSuma tabla6 = new TablaHashSuma(10);
	            tabla6.encontrarPares(lista, suma);
	            
	            
	    }
	
	
    private static int calcularMDesdeArchivo(String nombreArchivo) {
        int cantidadElementos = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String primeraLinea = br.readLine();
            cantidadElementos = Integer.parseInt(primeraLinea.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Calcular m como un primo cercano a la cantidad de elementos más un 40% adicional
        int cantidadCon40PorCientoAdicional = (int) (cantidadElementos * 1.4);
        return encontrarPrimoCercano(cantidadCon40PorCientoAdicional);
    }

    private static int encontrarPrimoCercano(int numero) {
        while (!esPrimo(numero)) {
            numero++;
        }
        return numero;
    }

    private static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        int i = 5;
        while (i * i <= numero) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

}

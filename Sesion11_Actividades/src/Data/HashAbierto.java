package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashAbierto {
    private ListaEnlazada[] tabla;
    private int m; // Tamaño de la tabla hash

    public HashAbierto(int m) {
        this.m = m;
        this.tabla = new ListaEnlazada[m];
        for (int i = 0; i < m; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    private int hash(int codigo) {
        return codigo % m;
    }

    public void insertar(Empleado empleado) {
        int indice = hash(empleado.getCodigo());
        tabla[indice].agregar(empleado);
    }

    public Empleado buscar(int codigo) {
        int indice = hash(codigo);
        return tabla[indice].buscar(codigo);
    }

    public void mostrarTabla() {
        for (int i = 0; i < m; i++) {
            System.out.printf("Lista en posición %d:\n", i);
            tabla[i].mostrar();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashAbierto hashAbierto = inicializarDesdeArchivo("EMPLEADO.TXT");

   
        System.out.println("Tabla Hash con Encadenamiento:");
        hashAbierto.mostrarTabla();
    }

    private static HashAbierto inicializarDesdeArchivo(String nombreArchivo) {
        int cantidadRegistros = 0;
        HashAbierto hashAbierto = null;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String primeraLinea = br.readLine();
            cantidadRegistros = Integer.parseInt(primeraLinea.trim());

            hashAbierto = new HashAbierto(cantidadRegistros);

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                String direccion = partes[2].trim();
                Empleado empleado = new Empleado(codigo, nombre, direccion);
                hashAbierto.insertar(empleado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashAbierto;
    }
}
package Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashEmpleado {
	
    private Empleado[] tabla;
    private int m; // Tamanio de la tabla hash
    private int n; // Cantidad de empleados

    public HashEmpleado(int m) {
        this.m = m;
        this.tabla = new Empleado[m];
        this.n = 0;
    }

    private int hash(int codigo) {
        return codigo % m;
    }

    private int buscarPosicion(int codigo) {
        int hashInicial = hash(codigo);
        int hash = hashInicial;
        int k = 0;
        while (tabla[hash] != null && tabla[hash].getCodigo() != codigo) {
            k++;
            hash = (hashInicial + k * k) % m;
        }
        return hash;
    }

    public void insertar(Empleado empleado) {
        if (n == m) {
            System.out.println("Tabla hash llena. No se puede insertar más elementos.");
            return;
        }
        int posicion = buscarPosicion(empleado.getCodigo());
        tabla[posicion] = empleado;
        n++;
    }

    public void mostrarTabla() {
        System.out.println("Tabla Hash de Empleados:");
        System.out.println("Código\tNombre\t\tDirección\tHash\tDirección Real\tLongitud de Búsqueda");
        for (int i = 0; i < m; i++) {
            if (tabla[i] != null) {
                int hash = hash(tabla[i].getCodigo());
                System.out.printf("%d\t%s\t%s\t%d\t%d\t\t%d\n", tabla[i].getCodigo(), tabla[i].getNombre(),
                        tabla[i].getDireccion(), hash, i, calcularLongitudDeBusqueda(tabla[i].getCodigo()));
            } else {
                System.out.printf("-\t-\t-\t-\t-\t-\n");
            }
        }
    }

    private int calcularLongitudDeBusqueda(int codigo) {
        int hashInicial = hash(codigo);
        int hash = hashInicial;
        int k = 0;
        while (tabla[hash] != null && tabla[hash].getCodigo() != codigo) {
            k++;
            hash = (hashInicial + k * k) % m;
        }
        return k + 1; // Se agrega 1 porque se cuenta el primer intento tambien
    }
}
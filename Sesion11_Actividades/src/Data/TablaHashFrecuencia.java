package Data;

public class TablaHashFrecuencia {
    private int tamaño;
    private String[][] tabla;

    public TablaHashFrecuencia(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new String[tamaño][];
    }

    private int hash(String clave) {
        return Math.abs(clave.hashCode()) % tamaño;
    }

    public void insertar(String clave) {
        int indice = hash(clave);
        if (tabla[indice] == null) {
            tabla[indice] = new String[]{clave, "1"}; // Inicializa con frecuencia 1
        } else {
            boolean encontrado = false;
            for (int i = 0; i < tabla[indice].length; i += 2) {
                if (tabla[indice][i].equals(clave)) {
                    int nuevaFrecuencia = Integer.parseInt(tabla[indice][i + 1]) + 1;
                    tabla[indice][i + 1] = String.valueOf(nuevaFrecuencia);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                // Añadir nueva clave con frecuencia 1 al final del bucket
                String[] nuevoBucket = new String[tabla[indice].length + 2];
                System.arraycopy(tabla[indice], 0, nuevoBucket, 0, tabla[indice].length);
                nuevoBucket[nuevoBucket.length - 2] = clave;
                nuevoBucket[nuevoBucket.length - 1] = "1";
                tabla[indice] = nuevoBucket;
            }
        }
    }

    public int frecuencia(String clave) {
        int indice = hash(clave);
        if (tabla[indice] != null) {
            for (int i = 0; i < tabla[indice].length; i += 2) {
                if (tabla[indice][i].equals(clave)) {
                    return Integer.parseInt(tabla[indice][i + 1]);
                }
            }
        }
        return 0; // Clave no encontrada
    }
}

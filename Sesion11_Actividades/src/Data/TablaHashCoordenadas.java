package Data;

public class TablaHashCoordenadas {
    private int tamaño;
    private String[][] tabla;

    public TablaHashCoordenadas(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new String[tamaño][];
    }

    private int hash(int x, int y) {
        return (x * 31 + y) % tamaño;
    }

    public void insertar(int x, int y, String valor) {
        int indice = hash(x, y);
        if (tabla[indice] == null) {
            tabla[indice] = new String[]{x + "," + y + ":" + valor};
        } else {
            String[] bucket = tabla[indice];
            String[] newBucket = new String[bucket.length + 1];
            System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
            newBucket[bucket.length] = x + "," + y + ":" + valor;
            tabla[indice] = newBucket;
        }
    }

    public String buscar(int x, int y) {
        int indice = hash(x, y);
        if (tabla[indice] != null) {
            for (String elemento : tabla[indice]) {
                if (elemento.startsWith(x + "," + y + ":")) {
                    return elemento.substring(elemento.indexOf(":") + 1);
                }
            }
        }
        return null;
    }
    public String eliminar(int x, int y) {
        int indice = hash(x, y);
        if (tabla[indice] != null) {
            for (int i = 0; i < tabla[indice].length; i++) {
                if (tabla[indice][i].startsWith(x + "," + y + ":")) {
                    String valor = tabla[indice][i].substring(tabla[indice][i].indexOf(":") + 1);
                    String[] newBucket = new String[tabla[indice].length - 1];
                    System.arraycopy(tabla[indice], 0, newBucket, 0, i);
                    System.arraycopy(tabla[indice], i + 1, newBucket, i, tabla[indice].length - i - 1);
                    tabla[indice] = newBucket;
                    return valor;
                }
            }
        }
        return null;
    }

}

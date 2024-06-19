package Data;

public class TablaHashSuma {
    private int tamaño;
    private int[][] tabla;

    public TablaHashSuma(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new int[tamaño][];
    }

    private int hash(int clave) {
        return clave % tamaño;
    }

    public void insertar(int clave) {
        int indice = hash(clave);
        if (tabla[indice] == null) {
            tabla[indice] = new int[]{clave};
        } else {
            int[] bucket = tabla[indice];
            int[] newBucket = new int[bucket.length + 1];
            System.arraycopy(bucket, 0, newBucket, 0, bucket.length);
            newBucket[bucket.length] = clave;
            tabla[indice] = newBucket;
        }
    }

    public void encontrarPares(int[] lista, int suma) {
        for (int i = 0; i < lista.length; i++) {
            int complemento = suma - lista[i];
            int indice = hash(complemento);
            if (tabla[indice] != null) {
                for (int j = 0; j < tabla[indice].length; j++) {
                    if (tabla[indice][j] == complemento) {
                        System.out.println("(" + complemento + ", " + lista[i] + ")");
                    }
                }
            }
            insertar(lista[i]);
        }
    }

}

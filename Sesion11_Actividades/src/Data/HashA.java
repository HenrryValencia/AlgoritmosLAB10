package Data;

public class HashA<E> {
	
    private static class Entry<E> {
        int key;
        E value;

        public Entry(int key, E value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry<E>[] table;
    private int m; // Tamaño de la tabla
    private int size; // Cantidad de elementos almacenados

    public HashA(int size) {
        this.m = size;
        this.table = new Entry[m];
        this.size = 0;
    }

    private int hashFunction(int key) {
        return key % m;
    }

    public void insert(int key, E value) {
        if (size == m) {
            System.out.println("Tabla hash llena. No se puede insertar.");
            return;
        }

        int hash = hashFunction(key);

        while (table[hash] != null && table[hash].key != key) {
            hash = (hash + 1) % m; // Sonda lineal
        }

        if (table[hash] == null) {
            table[hash] = new Entry<>(key, value);
            size++;
        } else {
            table[hash].value = value; // Actualizar valor si la clave ya existe
        }
    }

    public E search(int key) {
        int hash = hashFunction(key);

        while (table[hash] != null) {
            if (table[hash].key == key) {
                return table[hash].value;
            }
            hash = (hash + 1) % m; // Sonda lineal
        }

        return null; // Clave no encontrada
    }

    public boolean delete(int key) {
        int hash = hashFunction(key);

        while (table[hash] != null) {
            if (table[hash].key == key) {
                table[hash] = null;
                size--;
                return true; // Elemento se ah eliminado
            }
            hash = (hash + 1) % m; 
        }

        return false; // Elemento no encontrado
    }	
    // Método del cuadrado para la función hash
    private int hashSquare(int key) {
        int square = key * key;
        String squareString = String.valueOf(square);
        int midIndex = squareString.length() / 2;
        String hashString = squareString.substring(midIndex - 1, midIndex + 1);
        return Integer.parseInt(hashString) % m;
    }

    // Metodo de pliegue aplicando suma para la funcion haash
    
    private int hashFoldingSum(int key) {
        String keyString = String.valueOf(key);
        int sum = 0;

        // Suma los digitos de la clave
        
        for (int i = 0; i < keyString.length(); i++) {
            sum += Character.getNumericValue(keyString.charAt(i));
        }

        return sum % m;
    }
    

}

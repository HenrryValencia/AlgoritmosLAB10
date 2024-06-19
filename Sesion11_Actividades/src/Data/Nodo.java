package Data;

public class Nodo {
    private String clave;
    private int frecuencia;

    public Nodo(String clave) {
        this.clave = clave;
        this.frecuencia = 1;
    }

    public String getClave() {
        return clave;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void incrementarFrecuencia() {
        frecuencia++;
    }
 
    
}

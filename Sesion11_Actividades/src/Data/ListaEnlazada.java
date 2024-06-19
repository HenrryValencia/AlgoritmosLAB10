package Data;

public class ListaEnlazada {
    private Nodo primero;

    private class Nodo {
        Empleado empleado;
        Nodo siguiente;

        public Nodo(Empleado empleado) {
            this.empleado = empleado;
            this.siguiente = null;
        }
    }

    public void agregar(Empleado empleado) {
        Nodo nuevo = new Nodo(empleado);
        if (primero == null) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    public Empleado buscar(int codigo) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.empleado.getCodigo() == codigo) {
                return actual.empleado;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void mostrar() {
        Nodo actual = primero;
        while (actual != null) {
            System.out.println(actual.empleado);
            actual = actual.siguiente;
        }
    }
    
  
    

}
package Data;
import java.util.*;

public class Hash <E extends Comparable<E>>
{
	//Declaramos la clase elemento que sera los datos que ingresamos a nuestro hash ya con su identificador
	protected class Element{
		int mark;
		Register<E> reg;
		public Element(int mark, Register<E> reg) 
		{
			this.mark = mark;
			this.reg = reg;
		}
	}
	
	protected ArrayList<Element> table;
	protected int m;
	
	//Recien se inicia la clase Hash...
	
	//Se crea el arreglo que se usara en el hash...
	public Hash(int n) 
	{
		this.m = n;
		this.table = new ArrayList<Element>(m);
		
		for (int i = 0; i<m;i++) 
		{
			this.table.add(new Element(0,null));
		}
	}
	private int funcionHashLineal(int key) {
		return key % m;
	}
	private int linearProbing(int dressHash, int key) {
		
		int i = dressHash;
        while (table.get(i).mark == 1 && table.get(i).reg.getKey() != key) {
            i = (i + 1) % m;
            if (i == dressHash) { // Si damos la vuelta completa, la tabla esta llena y pues se retorna -1 o null
                return -1;
            }
        }
        return i;
	}
	public void insert(int key, E reg) {
		 int dressHash = funcionHashLineal(key);
	        int pos = linearProbing(dressHash, key);
	        
	        if (pos != -1) {
	            table.set(pos, new Element(1, new Register<E>(key, reg)));
	        } else {
	            System.out.println("La tabla hash esta llena, no se puede insertar el elemento...");
	        }
	}
	public E search(int key) {
		
		int dressHash = funcionHashLineal(key);
        int i = dressHash;
        
        while (table.get(i).mark != 0) {
            if (table.get(i).mark == 1 && table.get(i).reg.getKey() == key) {
                return table.get(i).reg.getValue();
            }
            i = (i + 1) % m;
            if (i == dressHash) { // Es la misma condicion en para incertar, si esta llena no existe el dato...
                break;
            }
        }
        return null;
	}
	
}

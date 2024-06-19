package Data;

public class LinkedQueue<E> {
    private class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Añadir un elemento al final de la cola
    public void enqueue(E data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Eliminar y devolver el elemento del frente de la cola
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    // Devolver el elemento del frente de la cola sin eliminarlo
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // Verificar si la cola está vacía
    public boolean isEmpty() {
        return front == null;
    }

    // Devolver el tamaño de la cola
    public int size() {
        return size;
    }

    // Vaciar la cola
    public void clear() {
        front = rear = null;
        size = 0;
    }
}
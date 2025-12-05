// Double-Ended Queue Implementation (Java)
public class ArrayDeque {
    private int[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    
    public ArrayDeque(int size) {
        items = new int[size];
        front = -1;
        rear = 0;
        size = 0;
        capacity = size;
    }
    
    public void addFront(int item) {
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front--;
        }
        items[front] = item;
        size++;
    }
    
    public void addRear(int item) {
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear++;
        }
        items[rear] = item;
        size++;
    }
    
    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return -1;
        }
        int item = items[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front++;
        }
        size--;
        return item;
    }
    
    public int removeRear() {
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return -1;
        }
        int item = items[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear--;
        }
        size--;
        return item;
    }
    
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return items[front];
    }
    
    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return items[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int getSize() {
        return size;
    }
    
    public void print() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return;
        }
        System.out.println("Deque contents (front to rear):");
        int i = front;
        int count = 0;
        while (count < size) {
            System.out.println(items[i]);
            i = (i + 1) % capacity;
            count++;
        }
    }

    public static void main(String[] args) {
        ArrayDeque deque = new ArrayDeque(5);
        deque.addRear(10);
        deque.addFront(20);
        deque.addRear(30);
        System.out.println("Front element: " + deque.peekFront()); // 20
        System.out.println("Rear element: " + deque.peekRear());   // 30
        System.out.println("Deque size: " + deque.getSize());      // 3
        deque.print();
        deque.removeFront();
        System.out.println("After removeFront, front element: " + deque.peekFront()); // 10
    }
}
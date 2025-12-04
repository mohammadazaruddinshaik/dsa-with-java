class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;

    CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        for (int i = 0; i < capacity; i++) arr[i] = -1;
        this.rear = this.front = -1;
    }

    // Insert element
    public void push(int val) {
        if (isFull()) {
            System.out.println("Queue is Overflow");
            return;
        }

        if (isEmpty()) {           // first element
            front = 0;
            rear = 0;
            arr[rear] = val;
            return;
        }

        // move rear circularly and insert
        rear = (rear + 1) % capacity;
        arr[rear] = val;
    }

    // Remove element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return -1;
        }

        int poppedElement = arr[front];
        arr[front] = -1; // optional: mark freed slot

        if (front == rear) { // queue becomes empty
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        return poppedElement;
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % capacity) == front;
    }

    // Current number of elements
    public int size() {
        if (isEmpty()) return 0;
        if (rear >= front) return rear - front + 1;
        return capacity - (front - rear - 1);
    }

    // Print queue contents in order from front -> rear
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.push(10);
        q.push(20);
        q.push(30);
        q.push(40);
        q.display();            // 10 20 30 40

        System.out.println("Popped: " + q.pop()); // 10
        System.out.println("Peek: " + q.peek());  // 20

        q.push(50);
        q.push(60);             // fills queue
        q.display();            // 20 30 40 50 60

        q.push(70);             // should print Overflow

        System.out.println("Popped: " + q.pop()); // 20
        System.out.println("Popped: " + q.pop()); // 30

        q.push(70); // demonstrates wrap-around insertion
        q.push(80);
        q.display();            // shows wrap-around order

        System.out.println("Size: " + q.size());
        System.out.println("Is full? " + q.isFull());
        System.out.println("Is empty? " + q.isEmpty());
    }
}

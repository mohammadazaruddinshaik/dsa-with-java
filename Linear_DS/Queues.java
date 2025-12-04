class MyQueues {
    private int[] arr;
    int capacity;
    int front;
    int rear;

    MyQueues(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.front = this.rear = -1;
    }

    void enqueue(int val){
        if (front == -1) {
            front = rear = 0;
            arr[rear] = val;
            return;
        } 
        if (rear == capacity - 1) {
            System.out.println("queue overflow.");
            return;
        }
        arr[++rear] = val;
    }

    int dequeue(){
        if (front == -1) { // empty
            System.out.println("queue underflow.");
            return -1;
        }
        int poppedElement = arr[front];
        // shift elements left
        for (int i = 1; i <= rear; i++) {
            arr[i - 1] = arr[i];
        }
        rear -= 1;
        // if queue became empty, reset indices
        if (rear < 0) {
            front = rear = -1;
        }
        return poppedElement;
    }

    int peek(){
        if (front == -1) {
            return -1;
        }
        return arr[front];
    }

    boolean isEmpty(){
        return front == -1; 
    }

    boolean isFull(){
        return rear == capacity - 1;
    }

    int size(){
        if (front == -1) return 0;
        return rear - front + 1; 
    }

    void Traversal(){
        if (front == -1) {
            System.out.println("Queue is empty.");
            return;
        }
        for (int i = front; i <= rear; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {

        /*
            Queues follows FIFO principle.
            It used as buffer in computer systems.
            It used in OS too for cpu scheduling and memory management.
            It used in many standard algorithms such as bfs, level order traversal.

            Enqueue() - O(1)
            Dequeue() = O(1) to return but for shifting the elements O(N)
            peek() -  O(1)

            Types of Queues: 
            a)Simple Queue
            b)Double Ended Queue
                ->Input restricted Queue
                ->Output restricted Queue
            c)Priority Queue
                ->Asc PQ
                ->Desc PQ
            d)Circular Queue
            
            Applications of Queue:
            CPU Scheduling 
            Job Scheduling
            Networking
            Buffer Management 

        */
        MyQueues queue = new MyQueues(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5); // overflow

        System.out.println("queue is empty? : "+queue.isEmpty());
        System.out.println("queue is full? : "+queue.isFull());

        System.out.println("Peek Element: "+queue.peek());
        queue.Traversal();

        queue.dequeue();
        queue.Traversal();

        System.out.println("Peek Element: "+queue.peek());
        System.out.println("Size of the queue: "+queue.size());


        /*
            Queue<Integer> queue = new LinkedList<>();
            Queue is a interface.   
            It implements collections interface.
            public interface Queue<E>
                extends Collection<E>

            methods:
            queue.add(Element)
            queue.offer(Element)

            queue.element()
            queue.peek()

            queue.poll()
            queue.remove()

            queue.size()

        */        
    }
}

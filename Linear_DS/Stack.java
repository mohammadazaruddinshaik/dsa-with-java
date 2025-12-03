import java.util.*;

class myStack {
    private int[] arr;
    private int capacity;
    private int top;

    public myStack(int cap){
        this.capacity = cap;
        arr = new int[capacity];
        top = -1;
    }

    void push(int val){
        if(top==capacity-1){
            System.out.println("Stack Overflow...");
            return;
        }
       arr[++top] = val;
    }

    void pop(){
        if(top==-1){
            System.out.println("Stack Underflow...");
            return;
        }
        arr[top] = 0;
        top--;
    }

    void traversal(){
        for(int i=0;i<=top;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    int top(){
        if(top==-1) return -1;
        return arr[top];
    }

    boolean isEmpty(){
        return top==-1;
    }

    boolean isFull(){
        return top==capacity-1;
    }

    int size(){
        return top+1;
    }
}

class Main {
    public static void main(String[] args) {
        /*
            *Stack follows LIFO Principle 
            *The insertion and deletion from one end.
            *It follows a particular order.
            *Types of stack a)Fixed b)Dynamic 

            *Fixed:It can occupy certain capacity.
                eg. size = 5 
                *We can store element's upto at max 5.
                *Underflow: if stack is empty and we try to remove an element
                *Overflow: if stack is full and we try to add an element.
                *Implemented using static array
            *Dynamic:
                *A dynamic size stack can grow and shrink automatically as needed.
                *If the stack is full, its capacity expands to allow more elements.
                *As elements are removed, memory usage can shrink as well.
                *Implemented using LinkedList, ArrayList.

            Common Operations:
                -> push(), pop(), top(), isEmpty(), size()

            Application's of Stack:
            1)Recursion 2)Function calls 3)Undo/Redo Operations 4)Syntax parsing 5)Recursion Management 

            Advantages of Stack:
            Simplicity, LIFO Order, Efficency 
        */
        myStack s = new myStack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        s.traversal();        
        s.pop();

        s.traversal();

        s.push(5);
        s.pop(); 

        s.push(6);
        int popElement = s.top();

        s.push(7);
        s.push(8);
        System.out.println("Popped Element: "+popElement);
        System.out.println("Stack is Empty: "+s.isEmpty());
        System.out.println("Stack is Full: "+s.isFull());
        System.out.println("Size of Stack: "+s.size());

        //Stack collection in java
        /*
            Hiearchy of Stack : 
            Stack extends Vector
            Vector implements List
            List extends Collection
            Collection extends Iterable

        */
        Stack<Integer> myStack = new Stack<>();
        myStack.push(200);
        myStack.push(300);
        System.out.println(myStack);
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.search(200));//return index 


        //Implementation of Stack using LinkedList. 
    }
}
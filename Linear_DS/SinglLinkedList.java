class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}

public class SingleLinkedList {

    public static Node convertArrayToLL(int[] arr){
        if(arr.length==0) return null;
        Node head = new Node(arr[0]);
        Node cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static int getLLSize(Node head){
        int count = 0;
        Node cur = head;
        while(cur!=null){
            count+=1;
            cur = cur.next;
        }
        return count;
    }

    public static void Traversal(Node head){
        Node cur = head;
        System.out.print("Elements: ");
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //Insertion at head:
    public static Node InsertAtHead(Node head, int value){
        Node newHead = new Node(value);
        if(head==null) return newHead;
        newHead.next = head;
        head = newHead;
        return head;
    }

    //Insertion at tail:
    public static Node InsertAtTail(Node head, int value){
        Node newElement  = new Node(value);
        if(head==null) return newElement;
        Node cur = head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = newElement;
        return head;
    }


    //Insertion at K-Position:
    public static Node InsertAtKPosition(Node head, int value, int k){
        Node newElement = new Node(value);
        if(k==0){
            head = InsertAtHead(head, value);
            return head;
        }
        Node cur = head;
        int pos = 0;
        while(cur!=null){
            if(pos+1==k){
                break;
            }
            pos+=1;
            cur = cur.next;
        }
        if(cur!=null){
            newElement.next = cur.next;
            cur.next = newElement;
            return head;
        }
        return head;
    }

    //Deletion at Head:
    public static Node DeleteAtHead(Node head){
        if(head==null) return null;
        head = head.next;
        return head;
    }

    //Deletion at Tail:

    public static Node DeleteAtTail(Node head){
        if(head==null) return null;
        Node cur = head;
        while(cur.next.next!=null){
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    //Deletion at K-Position:

    public static Node DeleteAtKPosition(Node head, int k){
        if(k==0){
            head = DeleteAtHead(head);
            return head;
        }
        int i = 0;
        Node cur = head;
        while(cur!=null){
            if(i+1==k){
                break;
            }
            i+=1;
            cur = cur.next;
        }
        if(cur!=null){
            if(cur.next==null){
                return head;
            }
            else if(cur.next.next!=null){
                cur.next = cur.next.next;
                return head;
            }else{
                cur.next = null;
            }
        }
        return head;
    }


    public static void main(String[] args) {


        /* 
            *Linked List are non-primitive category.
            *It stores collection of items with similar type
            *It access an individual element in O(n)
            *It stores in non-contigous memory
            *Dynamic size
            *Insertion & Deletion is easy & fast
            *Types: Singly, Doubly, Circular Linked List
            *Used in: stacks, queues, graphs, hash tables etc.
            *Drawbacks: no direct access to elements, extra memory for pointers
            *Used when frequent insertion & deletion required.
            *Used when size is unknown or changes frequently.
            *Used in implementing other data structures like stacks & queues.
            *Used in applications like music playlists, image viewers etc.
            *Used in memory management & file systems.
            *Preferred over arrays when dynamic size & frequent insertions/deletions needed.
           
           *Structure of Singly Linked List:
                class Node{
                    int data;
                    Node next;

                    Node(int data){
                        this.data = data;
                        this.next = null;
                    }
                    Node(int data,Node next){
                        this.data = data;
                        this.next = next;
                    }
                }
            
            *Time Complexity for Single Linked List Operations:
                -Traversal: O(n)
                -Insertion at head: O(1)
                -Insertion at tail: O(n) or O(1) with tail pointer
                -Insertion at K position: O(n)
                -Deletion at head: O(1)
                -Deletion at tail: O(n)
                -Deletion at K position: O(n)
                

            *Structure of Doubly Linked List:
                class DNode{
                    int data;
                    DNode next;
                    DNode prev; 
                    DNode(int data){
                        this.data = data;
                        this.next = null;
                        this.prev = null;
                    }
                    DNode(int data,DNode next,DNode prev){
                        this.data = data;
                        this.next = next;
                        this.prev = prev;
                    }   
                }    

            *Time Complexity for Doubly Linked List Operations:
                -Traversal: O(n)
                -Insertion at head: O(1)
                -Insertion at tail: O(1) with tail pointer
                -Insertion at K position: O(n)
                -Deletion at head: O(1)
                -Deletion at tail: O(1) with tail pointer
                -Deletion at K position: O(n)

            *Structure of Circular Linked List:
                class CNode{
                    int data;
                    CNode next; 
                    CNode(int data){
                        this.data = data;
                        this.next = this; //points to itself
                    }
                    CNode(int data,CNode next){
                        this.data = data;
                        this.next = next;
                    }       
                }
            *Time Complexity for Circular Linked List Operations:
                -Traversal: O(n)
                -Insertion at head: O(1)
                -Insertion at tail: O(n) or O(1) with tail pointer
                -Insertion at K position: O(n)
                -Deletion at head: O(1)
                -Deletion at tail: O(n)
                -Deletion at K position: O(n)
        */

        Node head = new Node(10);

        System.out.println("Head: "+head.data);

        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        //Traversal:
        Node cur = head;
        System.out.print("Elements: ");
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();


        //Conversion of Array into LL
        int[] arr = {100,200,300,400,500,600};
        head = convertArrayToLL(arr);
        Traversal(head);
        System.out.println("Size of LL: "+getLLSize(head));

    //Insertion:
        //Insertion at head:
        head = InsertAtHead(head, 50);
        Traversal(head);

        //Insertion at tail:
        head = InsertAtTail(head, 700);
        Traversal(head);

        //Insertion at K position:
        head = InsertAtKPosition(head, 350, 14);
        Traversal(head);

    //Deletion:
        //Deletion at Head:
        head = DeleteAtHead(head);
        Traversal(head);

        //Deletion at Tail:
        head = DeleteAtTail(head);
        Traversal(head);

        //Deletion at K Posistion:
        head = DeleteAtKPosition(head,4);
        Traversal(head);

    }
}
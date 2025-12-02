class DLLNode{
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int data){
        this.data = data;
        this.next = null;
        this.prev = prev;
    }
}

public class DoublyLinkedList{

    public static void Traversal(DLLNode head){
        DLLNode cur = head;
        System.out.print("Elements: ");
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static DLLNode getTailNode(DLLNode head){
        DLLNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        return tail;
    }

    public static void RightTraversal(DLLNode tail){
        DLLNode cur = tail;
        System.out.print("Elements: ");
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur = cur.prev;
        }
        System.out.println();
    }

    public static DLLNode convertArrayToDLL(int[] arr){
        if(arr.length==0) return null;
        DLLNode head = new DLLNode(arr[0]);
        DLLNode cur = head;
        for(int i=1;i<arr.length;i++){
            DLLNode newElement = new DLLNode(arr[i]);
            cur.next = newElement;
            newElement.prev = cur;
            cur = newElement;
        }
        return head;
    }

    public static DLLNode InsertAtHead(DLLNode head, int val){
        DLLNode newElement = new DLLNode(val);
        if(head==null) return newElement;
        newElement.next = head;
        head.prev = newElement;
        head = newElement;
        return head;
    }

    public static DLLNode InsertAtTail(DLLNode head, int val){
        DLLNode newElement = new DLLNode(val);
        if(head==null) return newElement;
        DLLNode cur = head;

        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = newElement;
        newElement.prev = cur;
        cur = newElement;
        return head;
    }

    public static DLLNode InsertAtKPosition(DLLNode head, int k, int val){
        DLLNode newElement = new DLLNode(val);
        if(k==0){
            head = InsertAtHead(head,val);
            return head;
        }
        DLLNode cur = head;
        int i = 0;
        while(cur!=null){
            if(i+1==k){
                break;
            }
            i+=1;
            cur = cur.next;
        }
        if(cur!=null){
            DLLNode nextNodeTemp = cur.next;
            nextNodeTemp.prev = nextNodeTemp;
            newElement.next = nextNodeTemp;
            newElement.prev = cur;
            cur.next = newElement;
        }
        return head;
    }

    public static DLLNode DeleteAtHead(DLLNode head){
        if(head==null){
            return null;
        }
        head = head.next;
        head.prev = null;
        return head;
    }

    public static DLLNode DeleteAtTail(DLLNode head){
        if(head==null){
            return null;
        }
        DLLNode cur = head;
        while(cur.next.next!=null){
            cur = cur.next;
        }
        DLLNode nextNodeTemp = cur.next;
        nextNodeTemp.prev = null;
        cur.next = null;
        return head;
    }

     public static DLLNode DeleteAtKPosition(DLLNode head,int k){
        if(k==0){
            head = DeleteAtHead(head);
            return head;
        }
        DLLNode cur = head;
        int i = 0;
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
            }else if(cur.next.next!=null){
                DLLNode previousNode = cur;
                cur.next = cur.next.next;
                cur = cur.next;
                cur.prev = previousNode;
            }else{
                cur.next = null;
            }
        }
        return head;
    }

    public static void main(String[] args){
        DLLNode head = new DLLNode(10);
        System.out.println("Head: "+head.data);

        DLLNode secNode = new DLLNode(20);
        head.next = secNode;
        secNode.prev = head;

        DLLNode thirdNode = new DLLNode(30);
        secNode.next = thirdNode;
        thirdNode.prev = secNode;

        DLLNode tail = new DLLNode(40);
        thirdNode.next = tail;
        tail.prev = thirdNode;


        Traversal(head);
        RightTraversal(tail);

        int[] arr = {100,200,300,400,500,600};
        head = convertArrayToDLL(arr);
        Traversal(head);

    //Insertion:
        //Insertion at Head:
        head = InsertAtHead(head,50);
        Traversal(head);

        //Insertion at Tail:
        head = InsertAtTail(head,700);
        Traversal(head);

        //Insertion at K-Position:
        head = InsertAtKPosition(head,4,350);
        Traversal(head);  

     //Deletion:
        //Deletion at Head:
        head = DeleteAtHead(head);
        Traversal(head);

        //Deletion at Tail:
        head = DeleteAtTail(head);
        Traversal(head);

        //Deletion at K-Position:
        head = DeleteAtKPosition(head,6);
        Traversal(head);        

    }
}
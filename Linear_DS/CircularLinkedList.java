class CLLNode {
    int data;
    CLLNode next;

    CLLNode(int data) {
        this.data = data;
        this.next = null;
    }
    CLLNode(int data,CLLNode next) {
        this.data = data;
        this.next = next;
    }
}


class Main {

    public static CLLNode insertAtHead(CLLNode head, int val){
        CLLNode newVal = new CLLNode(val);
        if(head==null){
            head = newVal;
            newVal.next = newVal;
            return head;
        }
        CLLNode temp = head;
        while(temp.next!=head){
            temp = temp.next;
        }
        newVal.next = head;
        temp.next = newVal;
        head = newVal;
        return head;

    }

    public static CLLNode insertAtTail(CLLNode head, int val){
        CLLNode newVal = new CLLNode(val);
        if(head==null){
            head = newVal;
            newVal.next = newVal;
            return head;
        }
        CLLNode temp = head;
        while(temp.next!=head){
            temp = temp.next;
        }
        temp.next = newVal;
        newVal.next = head;
        return head;

    }

    public static CLLNode insertAtKPosistion(CLLNode head, int k, int val){
        CLLNode newVal = new CLLNode(val);
        if(k==0){
            head = insertAtHead(head, val);
            return head;
        }
        CLLNode temp = head;
        int i = 0;
        while(temp.next!=head){
            if(i+1==k){
                break;
            }
            temp = temp.next;
            i+=1;
        }
        if(temp.next==head){
            head = insertAtTail(head, val);
            return head;
        }else if(temp.next!=null){
            newVal.next = temp.next;
            temp.next = newVal;
        }
        return head;
    }


    public static CLLNode convertArrayToCircularLL(int[] arr){
        if(arr.length==0) return null;
        CLLNode head = new CLLNode(arr[0]);
        CLLNode cur = head;
        for(int i=1;i<arr.length;i++){
            if(i+1==arr.length){
                cur.next = new CLLNode(arr[i],head);
                cur = cur.next;
                break;
            }
            cur.next = new CLLNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }
    public static void Traversal(CLLNode head){
        if(head==null) return;
        CLLNode cur = head;
        do {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }while(cur!=head);
        System.out.println();
    }
    public static void main(String[] args) {
        CLLNode head = new CLLNode(10);
        head.next = new CLLNode(20);
        head.next.next = new CLLNode(30, head);
        Traversal(head);

        //Conversion of array to CLL
        int[] arr = {100,200,300,400,500};
        head = convertArrayToCircularLL(arr);
        Traversal(head);

        //Insert at head:
        head = insertAtHead(head, 50);
        Traversal(head);

        //Insert at tail:
        head = insertAtTail(head, 600);
        Traversal(head);

        //Insert at k posistion:
        head = insertAtKPosistion(head, 6,700);
        Traversal(head);
    }
}
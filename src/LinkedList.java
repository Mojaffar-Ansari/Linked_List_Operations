public class LinkedList {
    Node head;
    public void insert(int data){
        Node node = new Node();
        node.data=data;
        node.next=null;
        if(head==null){
            head=node;
            return;
        }
            Node temp=head;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=node;
    }
    public void display_forword(){
        Node temp=head;
        if(temp==null){
            System.out.println("List is empty");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }
    public void display_backword(Node temp){ //recursive approach
        if(temp==null){
            System.out.println("Empty list");
            return;
        }
        display_backword(temp.next);
        System.out.print(temp.data + " ");
    }
    public void insert_at_head(int data){
        Node temp=new Node();
        temp.data=data;
        temp.next=null;
        if(head==null){
            head=temp;
            return;
        }
        temp.next=head;
        head=temp;
    }
    public void reverse(){
        Node current=head;
        Node next;
        Node prev=null;
        if(current==null){
            System.out.println("Empty list");
            return;
        }
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    public void recursive_reverse(Node p){
        if(p.next==null){
            head=p;
            return;
        }
        recursive_reverse(p.next);
        Node q=p.next;
        q.next=p;
        p.next=null;
    }
    public void insert_at_position(int position,int key){
        Node temp=new Node();
        temp.data=key;
        temp.next=null;
        if(position==1){
            temp.next=head;
            head=temp;
            return;
        }
        Node head=this.head;
        for(int i=0;i<position-2;i++){
            head=head.next;
        }
        temp.next=head.next;
        head.next=temp;
    }
    public int length(){
        if(head==null){
            return 0;
        }
        Node temp=head;
        int len=0;
        while(temp!=null){
            temp=temp.next;
            len++;
        }
        return len;
    }
    public int length(Node temp){ // Recursive approach
        if(temp==null)
        return 0;
        return 1 + length(temp.next);

    }
}

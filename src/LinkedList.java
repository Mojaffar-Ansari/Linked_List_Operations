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
}

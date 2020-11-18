import java.util.*;

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
    public Node reverse(Node head){
        Node current=head;
        Node next=null;
        Node prev=null;
        if(current==null){
            System.out.println("Empty list");
        }
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
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
    public void delete_at_position(int position){
        Node temp1=this.head;
        Node temp2;
        if(temp1==null){
            System.out.println("Empty list");
            return;
        }
        if(position==1){
            head=temp1.next;
            return;
        }
        for(int i=0;i<position-2;i++){
            temp1=temp1.next;//(n-1)th node
        }
        temp2=temp1.next;// n'th node
        temp1.next=temp2.next;//(n+1)th node
    }
    public void delete_key(int key){
        if(this.head==null){
            System.out.println("Empty list");
            return;
        }
        Node current=this.head;
        Node temp=current;
        if(temp!=null && temp.data==key){
            this.head=temp.next;
            return;
        }
        Node previous=null;
        while(temp!=null && temp.data!=key){
            previous=temp;
            temp=temp.next;
        }
        if(temp==null){
            System.out.println(key+ "is not present in the list");
            return;
        }
        previous.next=temp.next;
    }
    public void search(int key){
        Node temp=this.head;
        if(temp==null){
            System.out.println("Empty list");
            return;
        }
        if(temp.data==key){
            System.out.println("Found");
            return;
        }
        while(temp!=null){
            if(temp.data==key){
                System.out.println("Found");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Not found");
    }
    public Node reverse_in_group_of_given_size(Node head,int k){
        Node current=head;
        Node next=null;
        Node prev=null;
        int count =0;
        while(current!=null && count<k){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        if(next!=null){
            head.next=reverse_in_group_of_given_size(next,k);
        }
        return prev;
    }
    public void make_loop(int k){
        Node k_position=this.head;
        Node l_position=this.head;
        int count=1;
        while(count<k){// finding k'th position node
            k_position=k_position.next;
            count++;
        }
        while(l_position.next!=null){// finding last node
            l_position=l_position.next;
        }
        l_position.next=k_position;
    }
    public Node detect_loop(){
        Node hare=this.head;
        Node tortoise=this.head;
        while (hare!=null && tortoise!=null && hare.next!=null){
            tortoise=tortoise.next;
            hare=hare.next.next;
            if(hare==tortoise){
                return hare;
            }
        }
        return null;
    }
    public void start_of_loop(Node p){ // here p is the node return from detect_loop()
        if(p==null){
            System.out.println("There is no loop in the list");
            return;
        }
        Node q=this.head;
        while(p!=q){
            p=p.next;
            q=q.next;
        }
        System.out.println(p.data + " is the start node of the loop");
    }
    public void remove_loop(Node p){ // here p is return from detect_loop()
        Node q=this.head;
        Node temp=p;
        if(p==null){
            System.out.println("Thre is no loop in the list");
            return;
        }
        int count=0;
        while (p!=q){
            p=p.next;
            q=q.next;
            count++;// length of head to start node of loop
        }
        int i=1;
        while(i<count){
            temp=temp.next;
            i++;
        }
        temp.next=null;
    }
    public Node mid_node(Node head){ // part of maerge sort
        if(head==null){
            return head;
        }
        Node s=head;
        Node f=head;
        while(f.next!=null && f.next.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    /*public Node merge(Node l,Node h){//Iterative approach
        Node new_head=null;
        Node sorting= new Node();
        if(l==null)
            return h;
        if(h==null)
            return l;
        if(l!=null && h!=null){
            if(l.data<=h.data){
                sorting=l;
                l=sorting.next;
            }else {
                sorting=h;
                h=sorting.next;
            }
        }
        new_head=sorting;
        while(l!=null && h!=null){
            if(l.data<=h.data){
                sorting.next=l;
                sorting=l;
                l=sorting.next;
            }
            else {
                sorting.next=h;
                sorting=h;
                h=sorting.next;
            }
        }
        if(l==null)
            sorting.next=h;
        if(h==null)
            sorting.next=l;
        return new_head;
    }*/
    public Node merge(Node l,Node h){
        Node result=null;
        if(l==null)
            return h;
        if(h==null)
            return l;
        if(l.data<=h.data){
            result=l;
            result.next=merge(l.next,h);
        }
        else{
            result=h;
            result.next=merge(l,h.next);
        }
        return result;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node mid=mid_node(head);
        Node secondHalf=mid.next;
        mid.next=null;
        return merge(mergeSort(head),mergeSort(secondHalf));
    }
    public Node make_circular(Node head){// make a simple linked list into circular linked list
        Node p=head;
        while(head.next!=null){
            head=head.next;
        }
        head.next=p;
        return p;
    }
    public boolean circular(Node head){ //check a linked is circular or not
        Node p=head;
        while(p!=null){
            p=p.next;
            if(p==head)
                return true;
        }
        return false;
    }
    public Node middle_node(Node head){ // return middle node of the linked list
        if(head==null||head.next==null)
            return head;
        Node p=head;
        Node q=head;
        int count=0;
        while(p!=null){
            p=p.next;
            count++;
        }
        int i=0;
        while(i<count/2){
            q=q.next;
            i++;
        }
        return q;
    }
    public Node endNode(Node head){
        Node end=head;
        while(end.next!=null){
            end=end.next;
        }
        return end;
    }
    public Node partition(Node start,Node end){
        if(start==end || start==null || end==null)
            return start;
        Node prev_pivot=start;
        Node current=start;
        int pivot=end.data;
        while(start!=end){
            if(start.data<pivot){
                prev_pivot=current;
                int temp=current.data;
                current.data=start.data;
                start.data=temp;
                current=current.next;
            }
            start=start.next;
        }
        int temp=current.data;
        current.data=pivot;
        end.data=temp;
        return prev_pivot;
    }
    public void quickSort(Node start,Node end){
        if(start==end)
            return;
        Node prev_pivot=partition(start,end);
        quickSort(start,prev_pivot);
        if(prev_pivot!=null && prev_pivot==start){
            quickSort(prev_pivot.next,end);
        }
        else if(prev_pivot!=null && prev_pivot.next!=null){
            quickSort(prev_pivot.next.next,end);
        }
    }
    public void remove_duplicates(Node head){// for sorted list
        Node p=head;
        Node q;
        while(p!=null && p.next!=null){
            if(p.data==p.next.data){
                q=p.next.next;
                if(q==null){
                    p.next=null;
                    break;
                }
                p.next=q;
            }
            if(p.data!=p.next.data)
                p=p.next;
        }
    }
    public void remove_duplicates_unsorted(Node head) { // for unsorted list
    Node current=head;
    Node previous=null;
    Set<Integer> set = new HashSet<>();
    while(current!=null){
        if(set.contains(current.data)){
            previous.next=current.next;
        }
        else{
            set.add(current.data);
            previous=current;
        }
        current=previous.next;
    }
    }
    public Node moveLastToFront(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node p=head;
        Node q=null;
        while(p.next!=null){
            q=p;
            p=p.next;
        }
        q.next=null;
        p.next=head;
        head=p;
        return head;
    }
    public  Node add_1_to_number(Node head){
        head=reverse(head);
        int carry=1;
        Node temp=null;
        Node p=head;
        while(carry!=0 && p!=null){
            int sum=p.data+1;
            p.data=sum%10;
            carry=sum/10;
            temp=p;
            p=p.next;
        }
        if(carry!=0){
            Node q=new Node();
            q.data=carry;
            temp.next=q;
        }
        return reverse(head);
        }
    }


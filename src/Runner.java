import java.util.Scanner;

public class Runner {
    public static void main(String []args){
        LinkedList list = new LinkedList();
        while(true){
            Scanner s = new Scanner(System.in);
            System.out.println("\n1.Insert at end\n2.Display forword\n3.Insert at head" +
                    "\n4.Display reverse\n5.Exit\n6.Iterative reverse\n7.Recursive reverse" +
                    "\n8.Insert at given position\n9.Iterative length of list\n10.Recursive length of list" +
                    "\n11.Delete node from given position\n12.Delete a spacific value\n13.Search data" +
                    "\n14.Reverse a Linked List in groups of given size\n15.Make a loop at k'th position" +
                    "\n16.Detect loop\n17.Find start point of loop\n18.Remove loop\n19.Merge sort" +
                    "\n20.Make circular\n21.check Circular or not\n22.Middle of list\nEnter the option: ");
            int op=s.nextInt();
            switch (op){
                case 1: System.out.println("Enter the element to be inserted: ");
                        int val=s.nextInt();
                        list.insert(val);
                        break;
                case 2: list.display_forword();
                        break;
                case 3: System.out.println("Enter the element to be inserted: ");
                         val=s.nextInt();
                         list.insert_at_head(val);
                         break;
                case 4: list.display_backword(list.head);
                        break;
                case 5: System.exit(0);
                        break;
                case 6: list.reverse();
                        break;
                case 7: list.recursive_reverse(list.head);
                        break;
                case 8: System.out.println("Enter the position: ");
                        int position = s.nextInt();
                        System.out.println("Enter the element: ");
                        val=s.nextInt();
                        list.insert_at_position(position,val);
                        break;
                case 9: System.out.println("Length is: "+list.length());
                        break;
                case 10: System.out.println("Length is: "+list.length(list.head));
                         break;
                case 11: System.out.println("Enter the position: ");
                         position=s.nextInt();
                         list.delete_at_position(position);
                         break;
                case 12: System.out.println("Enter the value: ");
                         int key=s.nextInt();
                         list.delete_key(key);
                         break;
                case 13: System.out.println("Enter the value");
                          key=s.nextInt();
                         list.search(key);
                         break;
                case 14: System.out.println("Enter the group size");
                         int k=s.nextInt();
                         list.head=list.reverse_in_group_of_given_size(list.head,k);
                         break;
                case 15: System.out.println("Enter the value of k: ");
                         k=s.nextInt();
                          list.make_loop(k);
                         break;
                case 16:
                         if(list.detect_loop()!=null)
                             System.out.println("Loop found");
                         else
                             System.out.println("Loop not found");
                         break;
                case 17: list.start_of_loop(list.detect_loop());
                         break;
                case 18: list.remove_loop(list.detect_loop());
                         break;
                case 19: list.head=list.mergeSort(list.head);
                         break;
                case 20: list.head=list.make_circular(list.head);
                          break;
                case 21: if(list.circular(list.head))
                          System.out.println("Circular");
                         else
                             System.out.println("Not circular");
                         break;
                case 22: System.out.println(list.middle_node(list.head).data);
                         break;
                default:System.out.println("Wrong input");
            }
        }
    }
}

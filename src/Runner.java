import java.util.Scanner;

public class Runner {
    public static void main(String []args){
        LinkedList list = new LinkedList();
        while(true){
            Scanner s = new Scanner(System.in);
            System.out.println("\n1.Insert at end\n2.Display forword\n3.Insert at head" +
                    "\n4.Display reverse\n5.Exit\n6.Iterative reverse\n7.Recursive reverse" +
                    "\n8.Insert at given position\n9.Iterative length of list\n10.Recursive length of list" +
                    "\n\nEnter the option: ");
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
                default:System.out.println("Wrong input");
            }
        }
    }
}

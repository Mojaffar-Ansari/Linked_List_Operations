import java.util.Scanner;

public class Runner {
    public static void main(String []args){
        LinkedList list = new LinkedList();
        while(true){
            Scanner s = new Scanner(System.in);
            System.out.println("\n1.Insert at end\n2.Display forword\n3.Insert at head\n\nEnter the option: ");
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
                default:System.out.println("Wrong input");
            }
        }
    }
}

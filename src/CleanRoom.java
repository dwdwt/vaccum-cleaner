import java.util.Scanner;

public class CleanRoom {
    public static void main(String[] args) {

        System.out.println("Enter room dimensions: ");
        Scanner sc = new Scanner(System.in);
        String[] dimensions = sc.nextLine().split("\\s");

        Room room = new Room(Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]));
        Cleaner cleaner = new Cleaner(room);

        System.out.println("Enter instructions: ");
        String instructions = sc.nextLine();

        cleaner.processingInstructions(instructions);
        cleaner.printResult();

    }
}

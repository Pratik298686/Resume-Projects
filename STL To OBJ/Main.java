import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("3D File Converter");
        System.out.println("1. Convert STL to OBJ");
        System.out.println("2. Convert OBJ to STL");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter input file path: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Enter output file path: ");
        String outputFilePath = scanner.nextLine();

        if (choice == 1) {
            STLToOBJConverter.convert(inputFilePath, outputFilePath);
        } else if (choice == 2) {
            OBJToSTLConverter.convert(inputFilePath, outputFilePath);
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}

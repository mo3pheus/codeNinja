package domain.misc;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String lineRead = scanner.nextLine();
            if (lineRead.equals("Stop")) {
                System.out.println("Have a nice day - thanks for trying out scanner.");
                break;
            } else {
                System.out.println(lineRead);
            }
        }
    }
}

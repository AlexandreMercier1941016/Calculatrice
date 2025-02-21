import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Entrez l'expression: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine().replace(" ", "");
        scanner.close();
        System.out.println("Résultat: " + expression);
    }
}
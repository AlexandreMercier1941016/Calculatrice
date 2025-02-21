import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Substaction;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try{
            System.out.print("Entrez l'expression: ");
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine().replace(" ", "");
            scanner.close();

            Addition addition = new Addition();
            Substaction substaction = new Substaction();
            Multiplication multiplication = new Multiplication();
            Division division = new Division();

            double result = calculate(expression);

            System.out.println("Résultat: " + String.valueOf(result));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static double calculate(String expression){
        return 0;
    }
}
import Operations.Addition;
import Operations.Division;
import Operations.Multiplication;
import Operations.Substaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try {
            System.out.print("Entrez l'expression: ");
            Scanner scanner = new Scanner(System.in);
            String expression = scanner.nextLine().replace(" ", "");
            scanner.close();

            if(expression.contains(",")) {
                throw new Exception("Il faut utiliser un point(.) et non une virgule(,) pour les nombres décimaux.");
            }

            double result = calculate(expression);
            System.out.println("Résultat: " + String.valueOf(result));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static double calculate(String expression) throws Exception {
        List<String> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        String number = "";

        for(char character : expression.toCharArray()) {
            if(Character.isDigit(character) || character == '.') {
                number += character;
            }
            else if (character == '+' || character == '-' || character == '*' || character == '/') {
                if(number.isEmpty() && character == '-') {
                    number+=character;
                }
                else{
                    numbers.add(number);
                    number = "";
                    operators.add(Character.toString(character));
                }
            }
            else{
                throw new Exception("Il y a un caractère invalide.");
            }
        }
        if(!numbers.isEmpty()) {
            numbers.add(number);
        }
        System.out.println(numbers);
        System.out.println(operators);
        return 0;
    }
}
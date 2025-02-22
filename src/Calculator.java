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
            System.out.println("Résultat: " + result);
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
                    operators.add(String.valueOf(character));
                }
            }
            else{
                throw new Exception("Il y a un caractère invalide.");
            }
        }
        numbers.add(number);

        List<String> newNumbers = new ArrayList<>();
        List<String> newOperators = new ArrayList<>();
        String firstNumber = numbers.get(0);

        for(int i=0;i<operators.size();i++) {
            String secondNumber = numbers.get(i+1);
            if(operators.get(i).equals("*")) {
                firstNumber = String.valueOf(Multiplication.multiply(firstNumber,secondNumber));
            }
            else if(operators.get(i).equals("/")) {
                firstNumber = String.valueOf(Division.divide(firstNumber,secondNumber));
            }
            else{
                newNumbers.add(firstNumber);
                newOperators.add(operators.get(i));
                firstNumber = secondNumber;
            }
        }
        newNumbers.add(firstNumber);

        firstNumber = newNumbers.get(0);
        for(int i=0;i<newOperators.size();i++) {
            String secondNumber = newNumbers.get(i+1);
            if(newOperators.get(i).equals("+")) {
                firstNumber = String.valueOf(Addition.add(firstNumber,secondNumber));
            }
            else if(newOperators.get(i).equals("-")) {
                firstNumber = String.valueOf(Substaction.substract(firstNumber,secondNumber));
            }
        }

        return Double.parseDouble(firstNumber);
    }
}
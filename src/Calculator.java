import Operations.*;

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

            Double result = calculate(expression);
            if(result != null) {
                System.out.println("Résultat: " + result);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Double calculate(String expression) throws Exception {
        try{
            List<String> numbers = new ArrayList<>();
            List<String> operators = new ArrayList<>();
            String number = "";

            for(char character : expression.toCharArray()) {
                if(Character.isDigit(character) || character == '.') {
                    number += character;
                }
                else if (character == '+' || character == '-' || character == '*' || character == '/' || character == '^') {
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

            List<String> newNumbers1 = new ArrayList<>();
            List<String> newOperators1 = new ArrayList<>();
            String firstNumber = numbers.getFirst();

            for(int i=0;i<operators.size();i++) {
                String secondNumber = numbers.get(i+1);
                if(operators.get(i).equals("^")) {
                    firstNumber = String.valueOf(Exponent.exponent(firstNumber,secondNumber));
                }
                else{
                    newNumbers1.add(firstNumber);
                    newOperators1.add(operators.get(i));
                    firstNumber = secondNumber;
                }
            }
            newNumbers1.add(firstNumber);

            List<String> newNumbers2 = new ArrayList<>();
            List<String> newOperators2 = new ArrayList<>();
            firstNumber = newNumbers1.getFirst();

            for(int i=0;i<newOperators1.size();i++) {
                String secondNumber = newNumbers1.get(i+1);
                if(newOperators1.get(i).equals("*")) {
                    firstNumber = String.valueOf(Multiplication.multiply(firstNumber,secondNumber));
                }
                else if(newOperators1.get(i).equals("/")) {
                    if(Double.parseDouble(secondNumber)==0) {
                        throw new Exception("Il est impossible de diviser par zéro.");
                    }
                    else{
                        firstNumber = String.valueOf(Division.divide(firstNumber,secondNumber));
                    }
                }
                else{
                    newNumbers2.add(firstNumber);
                    newOperators2.add(newOperators1.get(i));
                    firstNumber = secondNumber;
                }
            }
            newNumbers2.add(firstNumber);

            firstNumber = newNumbers2.getFirst();
            for(int i=0;i<newOperators2.size();i++) {
                String secondNumber = newNumbers2.get(i+1);
                if(newOperators2.get(i).equals("+")) {
                    firstNumber = String.valueOf(Addition.add(firstNumber,secondNumber));
                }
                else if(newOperators2.get(i).equals("-")) {
                    firstNumber = String.valueOf(Substaction.substract(firstNumber,secondNumber));
                }
            }

            return Double.parseDouble(firstNumber);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
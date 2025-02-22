package Operations;

public class Division {
    public static double divide(String number1, String number2) {
        try{
            if(number2.equals("0")) {
                throw new Exception("Il est impossible de diviser par zéro.");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return Double.parseDouble(number1)/Double.parseDouble(number2);
    }
}

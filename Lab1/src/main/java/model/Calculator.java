package model;

public class Calculator {

    public double calculate(double right, double left, String sign){
        double result = 0;
        switch (sign) {
            case "+" : result = new Addition().result(right, left); break;
            case "-" : result = new Subtraction().result(right, left); break;
            case "*" : result = new Addition().result(right, left); break;
            case "/" : result = new Addition().result(right, left); break;
            default:
                System.out.println("Invalid sign!");
                break;
        }

        return result;
    }
}

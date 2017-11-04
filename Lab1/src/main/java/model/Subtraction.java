package model;

public class Subtraction implements Operation {
    @Override
    public double result(double right, double left) {
        return right - left;
    }
}

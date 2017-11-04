package model;

public class Multiplication implements Operation {
    @Override
    public double result(double right, double left) {
        return right * left;
    }
}

package model;

public class Addition implements Operation {

    @Override
    public double result(double right, double left) {
        return right + left;
    }
}

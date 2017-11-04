package model;

public class Division implements Operation {
    @Override
    public double result(double right, double left) throws OperationException {
        if (left == 0){
            throw new OperationException("Division by 0 is not possible!");
        }
        return right / left;
    }
}

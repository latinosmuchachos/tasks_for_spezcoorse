package third;

public class TokenBinaryPlus extends TokenBinaryOperation{

    @Override
    public String getSymbol() {
        return "+";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public boolean isLeftAssociative() {
        return true;
    }

    @Override
    public double performOperation(double a, double b) {
        return a + b;
    }
}

package third;

public class TokenBinaryPow extends TokenBinaryOperation{
    @Override
    public String getSymbol() {
        return "^";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public boolean isLeftAssociative() {
        return false;
    }

    @Override
    public double performOperation(double a, double b) {
        return Math.pow(a, b);
    }
}

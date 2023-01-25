package third;

public class TokenBinaryDiv extends TokenBinaryOperation{

    @Override
    public String getSymbol() {
        return "/";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public boolean isLeftAssociative() {
        return true;
    }

    @Override
    public double performOperation(double a, double b) {
        return a / b;
    }
}

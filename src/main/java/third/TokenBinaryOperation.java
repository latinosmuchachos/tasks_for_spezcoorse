package third;

abstract class TokenBinaryOperation extends Token{

    public abstract int getPriority();
    public abstract boolean isLeftAssociative();
    public abstract double performOperation(double a, double b);
    @Override
    public boolean isBooleanOperation() {
        return true;
    }

    public boolean isNumber(){
        return false;
    }

    public boolean isBracket(){
        return false;
    }
}

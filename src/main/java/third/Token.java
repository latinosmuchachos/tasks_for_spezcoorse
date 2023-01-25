package third;

abstract class Token {
    public String symbol;
    public abstract String getSymbol();
    public abstract boolean isNumber();
    public abstract boolean isBracket();
    public abstract boolean isBooleanOperation();
}

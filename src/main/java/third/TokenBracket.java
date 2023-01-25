package third;

public class TokenBracket extends Token {
    @Override
    public String getSymbol() {
        return "(";
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isBracket() {
        return true;
    }

    @Override
    public boolean isBooleanOperation() {
        return false;
    }
}

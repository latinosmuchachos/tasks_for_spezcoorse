package third;

public class TokenNumber extends Token {
    private double value;

    public double getValue(){
        return this.value;
    }

    @Override
    public String getSymbol(){
        return String.valueOf(this.value);
    }

    public void setValue(double value){
        this.value = value;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isBracket() {
        return false;
    }

    @Override
    public boolean isBooleanOperation() {
        return false;
    }

}

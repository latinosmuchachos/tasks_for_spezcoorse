package third;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Calculator {

    private boolean Error = false;

    public Deque<Token> sortingStation(String[] tokens){
        Deque<Token> queue_tokens = new ArrayDeque<Token>();
        Deque<Token> operators = new ArrayDeque<Token>();

        for (int i = 0; i < tokens.length; i++){
            char symbol = tokens[i].charAt(0);
            if (symbol >= '0' && symbol <= '9'){
                TokenNumber token_number = new TokenNumber();
                token_number.setValue(Double.parseDouble(tokens[i]));
                token_number.symbol = String.valueOf(symbol);
                queue_tokens.add(token_number);
            }
            else if( symbol == '+'){
                TokenBinaryPlus token_plus = new TokenBinaryPlus();
                token_plus.symbol = String.valueOf(symbol);
                processTokenBinaryOperation(queue_tokens, operators, (TokenBinaryOperation) token_plus);
            }
            else if( symbol == '-'){
                TokenBinaryMinus token_minus = new TokenBinaryMinus();
                token_minus.symbol = String.valueOf(symbol);
                processTokenBinaryOperation(queue_tokens, operators, (TokenBinaryOperation) token_minus);
            }
            else if( symbol == '*'){
                TokenBinaryMulti token_multiply = new TokenBinaryMulti();
                token_multiply.symbol = String.valueOf(symbol);
                processTokenBinaryOperation(queue_tokens, operators, (TokenBinaryOperation) token_multiply);
            }
            else if( symbol == '/'){
                TokenBinaryDiv token_division = new TokenBinaryDiv();
                token_division.symbol = String.valueOf(symbol);
                processTokenBinaryOperation(queue_tokens, operators, (TokenBinaryOperation) token_division);
            }
            else if( symbol == '^'){
                TokenBinaryPow token_power = new TokenBinaryPow();
                token_power.symbol = String.valueOf(symbol);
                processTokenBinaryOperation(queue_tokens, operators, (TokenBinaryOperation) token_power);
            }
            else if(symbol == '('){
                TokenBracket tokenBr = new TokenBracket();
                tokenBr.symbol = String.valueOf(symbol);
                operators.push(tokenBr);
            }
            else if(symbol == ')'){
                processCloseBracket(queue_tokens, operators);
            }
        }
        processRest(queue_tokens, operators);

        return queue_tokens;
    }

    private void processTokenBinaryOperation(Deque<Token> queue_tokens, Deque<Token> operators, TokenBinaryOperation operation){
        while (!operators.isEmpty() && !operators.peekFirst().isBracket()){
            int op1Priority = operation.getPriority();
            Token op2 = operators.peekFirst();
            int op2Priority = ((TokenBinaryOperation) op2).getPriority();
            if (op1Priority < op2Priority || ((op1Priority == op2Priority) && operation.isLeftAssociative())){
                queue_tokens.add(op2);
                operators.pop();
            }
            else{
                break;
            }
        }
        operators.push(operation);
    }

    private void processCloseBracket(Deque<Token> queue_tokens, Deque<Token> operators){
        while (!operators.isEmpty() && !operators.peekFirst().isBracket()){
            Token topOp = operators.peekFirst();
            queue_tokens.add(topOp);
            operators.pop();
        }
        if (!operators.isEmpty() && operators.peekFirst().isBracket()){
            operators.pop();
        }
        else{
            System.out.println("Некорректное выражение");
            Error = true;
        }
    }


    private void processRest(Deque<Token> queue_tokens, Deque<Token> operators){
        while(!operators.isEmpty()){
            if (operators.peekFirst().isBracket()){
                System.out.println("Некорректное выражение");
                Error = true;
                break;
            }
            Token topOp = operators.peekFirst();
            queue_tokens.add(topOp);
            operators.pop();
        }
    }

    public void answer(String input_expression){
        String[] tokens = input_expression.split(" ");
        Deque<Token> queue_tokens = sortingStation(tokens);
        double answer = stackCalculator(queue_tokens);
        if (!Error){
            System.out.println("Answer: " + answer);
        }
    }

    public double stackCalculator(Deque<Token> queue_tokens){
        Deque<Token> numbers = new ArrayDeque<Token>();
        while (!queue_tokens.isEmpty()){
            Token head = queue_tokens.peek();
            if (head.isNumber()){
                numbers.push(head);
            }
            else if(head instanceof TokenBinaryOperation binary_operation){
                Token token = numbers.pop();
                double b = ((TokenNumber) token).getValue();
                token = numbers.pop();
                double a = ((TokenNumber) token).getValue();
                double result = binary_operation.performOperation(a, b);
                TokenNumber tokenNumber = new TokenNumber();
                tokenNumber.setValue(result);
                numbers.push(tokenNumber);
            }
            queue_tokens.pop();
        }

        if (numbers.size() == 1){
            return ((TokenNumber) numbers.pop()).getValue();
        }
        else{
            Error = true;
            System.out.println("Ошибка выражения");
        }
        return 0;
    }
}

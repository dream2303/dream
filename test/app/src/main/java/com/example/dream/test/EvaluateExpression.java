package com.example.dream.test;


import java.util.List;
import java.util.Stack;

public class EvaluateExpression {
    public static double evaluateExpression(String expressionStr){
        Stack<Double> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        String expression = insertBlank(expressionStr);
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if(token.length() == 0){
                continue;
            }
            char ch1 = token.charAt(0);
            switch (ch1) {
                case '+':
                case '-':
                    while (!operatorStack.isEmpty()) {
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.push(ch1);
                    break;
                case '*':
                case '/':
                    while (!operatorStack.isEmpty() && (operatorStack.peek() != '+'&& operatorStack.peek() != '-')){
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.push(ch1);
                    break;
                case'S':
                case'C':
                case'T':
                case'L':
                case'%':
                    while(!operatorStack.isEmpty()&&(operatorStack.peek() == '+'||operatorStack.peek() == '-'||operatorStack.peek() == '*'||operatorStack.peek() == '*')){
                        processAnOperator(operandStack, operatorStack);
                    }
                    operatorStack.push(ch1);
                    break;
                default : operandStack.push(new Double(token));
            }
        }
        while (!operatorStack.isEmpty()){
            processAnOperator(operandStack, operatorStack);
        }
        return operandStack.pop();
    }

    private static void processAnOperator(Stack<Double> operandStack,Stack<Character> operatorStack){
        char opr = operatorStack.pop();
        double op1 = operandStack.pop();

        switch (opr) {
            case '+':
                operandStack.push(operandStack.pop() + op1);
                break;
            case '-':
                operandStack.push(operandStack.pop()  - op1);
                break;
            case '*':
                operandStack.push(operandStack.pop()  * op1);
                break;
            case '/':
                operandStack.push(operandStack.pop()  / op1);
                break;
            case'S':
                operandStack.push( Math.sin(op1));
                break;
            case'C':
                operandStack.push( Math.cos(op1));
                break;
            case'T':
                operandStack.push( Math.tan(op1));
                break;
            case'L':
                operandStack.push( Math.log(op1));
                break;
            case'%':
                operandStack.push(0.01*op1);
                break;
            default:
        }
    }

    private static String insertBlank(String expression){
        String result = "";
        for(int i = 0; i < expression.length(); i++){
            if( expression.charAt(i) == '/' || expression.charAt(i) == '*' || expression.charAt(i) == '-'
                    || expression.charAt(i) == '+' || expression.charAt(i) == 'S' || expression.charAt(i) == 'C'
                    || expression.charAt(i) == 'T' || expression.charAt(i) == 'L'|| expression.charAt(i) == '%'){
                result += " "+expression.charAt(i)+" ";
            }
            else {
                result += expression.charAt(i);
            }
        }
        System.out.println(result);
        return result;
    }
}
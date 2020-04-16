package com.tira.tehtava14;

import java.util.Stack;

public class Calc {
    private OperandiStack operandi;
    private OperatorStack operators;
    private String postfix;

    public Calc() {
        operandi = new OperandiStack();
        operators = new OperatorStack();
        postfix = "";
    }

    public Double calculate(String data) {
        /*
        0. format string
        1. muokkaa string infix > postfix
        2. lisää numerot operandistakkiin
        3. lisää operaattorit operatorstakkiin
        4. laske
        5. palauta tulos
         */
        String formattedData = formatString(data);
        if (formattedData.equals("")) {
            return null;
        } else {
            infixToPostfix(formattedData);
        }
        Double answer = evaluate();

        // TODO check return
        return answer;
    }
    public String formatString(String data) {
        // remove whitespace, replace commas with dots & convert -- to +
        data = data
                .replace(" ", "")
                .replace(",", ".")
                .replace("--", "+");
        // no alphabet allowed
        if (data.matches("^[a-zA-Z]*$") || data.contains("ä") || data.contains("ö") || data.contains("å") ) {
            System.out.println("No alphabet");
            data = "";
        }
        return data;
    }

    public void infixToPostfix(String data) {
        // empty old values
        postfix = "";
        operators.clear();
        operandi.clear();

        // convert to postfix
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (isADigit(c)) {
                postfix += c;
            } else if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (operators.getSize() != 0 && operators.peek() != '(') {
                    postfix += operators.pop().getChr();
                }
                if (operators.getSize() != 0 && operators.peek() != '(') {
                    System.out.println("Problems in input with ( )");
                } else {
                    operators.pop().getChr();
                }
            } else {
                while (operators.getSize() != 0 && operationValue(c) <= operationValue(operators.peek())) {
                    if (operators.peek() == '(') {
                        System.out.println("Problems in input with ( )");
                    } else {
                        postfix += operators.pop().getChr();
                    }
                }
                operators.push(c);
            }
        }
        while (operators.getSize() != 0) {
            if (operators.peek() == '(') {
                System.out.println("Problems in input with ( )");
            } else {
                postfix += operators.pop().getChr();
            }
        }
        System.out.println(postfix);
    }

    private Double evaluate() {
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (isADigit(c)) {
                operandi.push(c-'0');
            } else {
                double d1 = operandi.pop().getDbl();
                double d2 = operandi.pop().getDbl();

                switch(c) {
                    case '+':
                        operandi.push(d2+d1);
                        break;
                    case '-':
                        operandi.push(d2-d1);
                        break;
                    case '/':
                    case ':':
                        operandi.push(d2 / d1);
                        break;
                    case '*':
                        operandi.push(d2 * d1);
                        break;
                }
            }
        }
        return operandi.pop().getDbl();
    }

    private boolean isADigit(char ch){
        if((ch>='0' && ch<='9') || ch=='.')
            return true;
        return false;
    }

    static int operationValue(char ch) {
        switch (ch) {
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}

package main.t4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args){
        String input = new String();
        //input = "( 12 + 43 ) * ( 56 + 78 )";
        //input = "( a - b / c ) * ( a / k - l )";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input expression:");
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("prefix form: \n" + infToPref(input) + '\n');
        System.out.println("postfix form: \n" + infToPostf(input) + '\n');

    }

    public static String infToPref(String input){

        char[] myinput = reverse(input).toCharArray();

        for (int i = 0; i < input.length(); i++) {
            if (myinput[i] == '(') {
                myinput[i] = ')';
                i++;
            }
            else if (myinput[i] == ')') {
                myinput[i] = '(';
                i++;
            }
        }
        String preresult = infToPostf(new String(myinput));

        return reverse(preresult);
    }

    public static String infToPostf(String input){

        StringBuilder stringBuilder = new StringBuilder();
        Stack stack = new Stack(input.length());
        char[] string = input.toCharArray();

        for (int i=0; i<string.length; i++){
            char cur = string[i];
            if (Character.isLetterOrDigit(cur)){
                while (Character.isLetterOrDigit(string[i]))
                    stringBuilder.append(string[i++]);
                stringBuilder.append(' ');
            }
            else  if (cur == '(')
                stack.push(cur);
            else  if (cur == ')'){
                while (stack.peek() != '(')
                    stringBuilder.append(stack.pop()).append(' ');
                stack.pop();
            }
            else  if (isOperator(cur)){
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(cur))
                    stringBuilder.append(stack.pop()).append(' ');
                stack.push(cur);
            }
        }
        while (!stack.isEmpty())
            stringBuilder.append(stack.pop()).append(' ');
        return stringBuilder.toString();
    }

    private static String reverse(String input){
        String result = new String();
        char[] myinput = input.toCharArray();
        for (int i=myinput.length-1; i>=0; i--)
            result += myinput[i];
        return result;
    }

    private static boolean isOperator(char ch){
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    private static int priority(char ch){
        switch (ch){
            case '^' : return 3;
            case '*' : return 2;
            case '/' : return 2;
            case '+' : return 1;
            case '-' : return 1;
        }
        return 0;
    }
}

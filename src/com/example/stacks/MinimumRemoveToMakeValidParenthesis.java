package com.example.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {

    // O(n) time and O(n) space
    private static String minRemoveParentheses(String string) {
        Stack<int[]> stack = new Stack<>();
        char[] charArray = string.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (!stack.isEmpty() && stack.peek()[0] == '(' && charArray[i] == ')') {
                stack.pop();
            } else if (charArray[i] == '(' || charArray[i] == ')') {
                stack.push(new int[]{charArray[i], i});
            }
        }

        while (!stack.isEmpty()) {
            charArray[stack.pop()[1]] = ' ';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : charArray) {
            if (ch != ' ') {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        List<String> inputs = Arrays.asList("ar)ab(abc)abd(", "a)rt)lm(ikgh)", "aq)xy())qf(a(ba)q)",
                "(aw))kk())(w(aa)(bv(wt)r)",  "(qi)(kl)((y(yt))(r(q(g)s)");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". Input: " + inputs.get(i));
            System.out.println("   Valid parentheses, after minimum removal: "
                    + minRemoveParentheses(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}

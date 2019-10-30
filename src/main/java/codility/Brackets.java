package codility;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.junit.Assert;
import org.junit.Test;

public class Brackets {

    public static int solutionprofiled(String S) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        int x = solution(S);
        long elapsed = stopwatch.stop().elapsed(TimeUnit.MICROSECONDS);
        System.out.println("elapsed " + (elapsed > 999 ? stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms " : elapsed + " us "));
        return x;
    }

    public static int solution1(String S) {
        if (S.length() <= 1 || S.length() % 2 != 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            char val = S.charAt(i);
            char top = stack.peek();
            char inverted = invert(val);
            if (top == inverted) {
//                System.out.println(top + "=" + val);
                stack.pop();
            } else {
                if (wrongClosingScope(top, val)) {
                    return 0;
                }
//                System.out.println(top + "!=" + val);
                stack.push(val);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }

    public static int solution(String S) {
        if (S.length() == 0) {
            return 1;
        }
        if (S.length() % 2 != 0) {
            return 0;
        }
        if (wrongStart(S.charAt(0))) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            char val = S.charAt(i);
            char top = stack.size() > 0 ? stack.peek() : 'N';
            if (top != 'N' && closed(top, val)) {
//                System.out.println(top + "=" + val);
                stack.pop();
            } else {
//                System.out.println(top + "!=" + val);
                stack.push(val);
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }

    private static boolean closed(char top, char val) {
        if (top == '(' && val == ')')
            return true;
        if (top == '{' && val == '}')
            return true;
        return top == '[' && val == ']';
    }

    private static boolean wrongStart(char val) {
        return val == '}' || val == ']' || val == ')';
    }

    private static boolean wrongClosingScope(char top, char val) {
        //            System.out.println("wrong closing scope " + top + " not " + val);
        return (top == '{' || top == '[' || top == '(') &&
                (val == '}' || val == ']' || val == ')');
    }

    private static char invert(char val) {
        switch (val) {
            case '{':
                return '}';
            case '[':
                return ']';
            case '(':
                return ')';
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        throw new RuntimeException("unknown val" + val);
    }

    @Test
    public void test() {
        Assert.assertEquals(1, solutionprofiled("{[()()]}"));
        Assert.assertEquals(0, solutionprofiled("([)()]"));
        Assert.assertEquals(0, solutionprofiled("("));
        Assert.assertEquals(0, solutionprofiled("(]"));
        Assert.assertEquals(0, solutionprofiled("(])"));
        Assert.assertEquals(0, solutionprofiled("((((((((((((((((((((((((()))))))))))])"));
        Assert.assertEquals(1, solutionprofiled("[]"));
        Assert.assertEquals(1, solutionprofiled(""));
        Assert.assertEquals(0, solutionprofiled("]]"));
        Assert.assertEquals(0, solutionprofiled("())(()"));

        Assert.assertEquals(1, solutionprofiled("((((((((((((((((((((((((((((((()))))))))))))))))))))))))))))))"));
        Assert.assertEquals(0, solutionprofiled("((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))"));
        Assert.assertEquals(1, solutionprofiled("[][][][][][][][][]"));
        StringBuilder builder = new StringBuilder(200_000);
        for (int i = 0; i < 200_000; i++) {
            builder.append(i < 100_000 ? '(' : ')');
        }
        Assert.assertEquals(1, solutionprofiled(builder.toString()));
        Assert.assertEquals(0, solutionprofiled(builder.replace(30_000, 30_001, "[").toString()));
    }
}

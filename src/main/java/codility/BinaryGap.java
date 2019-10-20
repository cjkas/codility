package codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class BinaryGap {
    public static int solution(int N) {
        // write your code in Java SE 8
        boolean started = false;
        int max = 0;
        int curr = 0;
        char[] chars = Integer.toBinaryString(N).toCharArray();
        for (char aChar : chars) {
            if (aChar == '1') {
                if (!started) {
                    started = true;
                } else {
                    if (curr > 0) {
                        if (curr > max) {
                            max = curr;
                        }
                        curr = 0;
                    }
                }
            } else {
                if (started) {
                    curr += 1;
                }
            }
        }
        System.out.println(N + " " + new String(chars) + " fnd " + max);
        return max;
    }
}


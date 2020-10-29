package test.t3.q5;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String answer = IntStream.range(0, n).mapToObj(i -> {
            String[] input = sc.nextLine().split(" ");
            return isMatch(input[0], input[1]) ? "True" : "False";
        }).collect(Collectors.joining("\n"));

        System.out.println(answer);
    }

    public static boolean isMatch(String word, String regex) {
//        System.out.println(word + " 와 " + regex + " 를 비교합니다.");
        if (regex.isEmpty()) {
            return word.isEmpty();
        }

        if (regex.startsWith("*")) {
            for (int i = 0 ; i <= word.length() ; ++i) {
                if (isMatch(word.substring(i), regex.substring(1))) {
                    return true;
                }
            }
        } else if (regex.startsWith("?")) {
            return isMatch(word.substring(1), regex.substring(1));
        } else {
            if (word.charAt(0) == regex.charAt(0)) {
                return isMatch(word.substring(1), regex.substring(1));
            }
        }

        return false;
    }
}

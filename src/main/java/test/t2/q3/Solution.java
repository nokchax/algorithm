package test.t2.q3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution(sc.nextLine()));
    }

    public static int solution(String phoneNum) {
        Pattern pattern = Pattern.compile("(^010-\\d{4}-\\d{4}$)|(^010\\d{8}$)|(^\\+82-10-\\d{4}-\\d{4}$)");

        Matcher matcher = pattern.matcher(phoneNum);
        if (!matcher.find()) {
            return -1;
        }

        return matcher.group(1) != null ? 1 :
                matcher.group(2) != null ? 2 : 3;
    }
}

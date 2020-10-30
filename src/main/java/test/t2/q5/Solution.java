package test.t2.q5;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

public class Solution {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss", Locale.KOREA);

    public static void main(String[] args) {
        String input = "2020/05/01 00:59:19\n" +
                        "2020/06/01 01:35:20\n" +
                        "2020/08/01 02:01:22\n" +
                        "2020/08/01 02:01:23\n" +
                        "2020/08/02 03:02:35\n" +
                        "2020/10/03 04:05:40\n" +
                        "2020/10/04 06:23:10\n" +
                        "2020/10/10 08:23:20\n" +
                        "2020/10/12 08:42:24\n" +
                        "2020/10/23 08:43:26\n" +
                        "2020/11/14 08:43:29\n" +
                        "2020/11/01 10:19:02\n" +
                        "2020/12/01 11:23:10";

        System.out.println(Arrays.toString(parse(input)));
    }

    public static int[] parse(String inputs) {
        int[] answer = new int[24];
        Arrays.stream(inputs.split("\n"))
                .map(x -> LocalDateTime.parse(x, FORMAT))
                .mapToInt(time -> (time.getHour() + 9) % 24)
                .forEach(x -> answer[x]++);

        return answer;
    }
}

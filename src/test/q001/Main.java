package test.q001;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("BAAABAB")); //2
        System.out.println(s.solution("BBABAA")); //3
        System.out.println(s.solution("AABBB")); //0
        System.out.println(s.solution("AAABBBAABBAA")); //5
        System.out.println(s.solution("AAABABAABBAABBAAABBBB")); //6

    }
}
package leetcode.Q01106;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}

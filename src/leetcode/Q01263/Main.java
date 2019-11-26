package leetcode.Q01263;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(
                s.minPushBox(new char[][]{
                    {'#', '.', '.', '#', '#', '#', '#', '#'},
                    {'#', '.', '.', 'T', '#', '.', '.', '#'},
                    {'#', '.', '.', '.', '#', 'B', '.', '#'},
                    {'#', '.', '.', '.', '.', '.', '.', '#'},
                    {'#', '.', '.', '.', '#', '.', 'S', '#'},
                    {'#', '.', '.', '#', '#', '#', '#', '#'}
                })
        );
    }
}

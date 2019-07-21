package leetcode.Q01041;

public class Solution {
    private static int[] mx = {0, 1, 0, -1};
    private static int[] my = {1, 0, -1, 0};
    private static int direction = 0;

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;

        for(char ins : instructions.toCharArray()) {
            switch (ins) {
                case 'G':
                    x += mx[direction];
                    y += my[direction];
                    break;

                case 'R':
                    direction = (direction + 1) % 4;
                    break;

                case 'L':
                    direction = (direction + 3) % 4;
                    break;
            }
        }

        return x == 0 && y == 0 || direction > 0;
    }
}

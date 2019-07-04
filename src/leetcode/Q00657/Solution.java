package leetcode.Q00657;

public class Solution {
    public boolean judgeCircle(String moves) {
        int y = 0;
        int x = 0;

        for(char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }

        return y == 0 && x == 0;
    }
}

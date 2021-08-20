package leetcode.Q01678;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        
        for (char c : command.toCharArray()) {
            if (c == '(') {
                q.clear();
                q.add('(');
            } else if (c == ')') {
                if (q.size() == 1) {
                    sb.append('o');
                }
                q.clear();
            } else {
                q.add(c);
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}

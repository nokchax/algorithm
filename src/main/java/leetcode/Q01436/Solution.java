package leetcode.Q01436;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, List<String>> path = new HashMap<>();
        for (int i = 0 ; i < paths.size() ; ++i) {
            List<String> temp = paths.get(i);
            String start = temp.get(0);
            String end = temp.get(1);
            
            if (path.containsKey(start)) {
                path.get(start).add(end);
            } else {
                List<String> dest = new ArrayList<>();
                dest.add(end);
                path.put(start, dest);
            }
        }
        String start = paths.get(0).get(0);
        while (!path.isEmpty()) {
            if (!path.containsKey(start) || path.get(start).size() == 0) {
                return start;
            }
            
            String dest = path.get(start).get(0);
            path.get(start).remove(0);
            start = dest;
        }
        return null;
    }
}

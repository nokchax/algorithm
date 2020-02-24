package leetcode.Q01096;

import java.util.*;

public class Solution {
    public List<String> braceExpansionII(String expression) {
        if(expression.length() == 0) {
            return Arrays.asList("");
        }

        int commaPosition = findCommaPosition(expression);

        if(commaPosition != expression.length()) {
            return concat(braceExpansionII(expression.substring(0, commaPosition)), braceExpansionII(expression.substring(commaPosition + 1)));
        }

        // , not exist in 'this' expression
        if(expression.charAt(0) != '{') {
            return product(
                    Arrays.asList(expression.substring(0, 1)),
                    braceExpansionII(expression.substring(1))
            );
        }

        int closeBraceletPosition = findBraceletPosition(expression);

        return product(
                braceExpansionII(expression.substring(1, closeBraceletPosition)),
                braceExpansionII(expression.substring(closeBraceletPosition + 1))
        );
    }


    private List<String> product(List<String> foreList, List<String> rearList) {
        Set<String> set = new HashSet<>();

        for(String fore : foreList) {
            for(String rear : rearList) {
                set.add(fore + rear);
            }
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    private List<String> concat(List<String> foreList, List<String> rearList) {
        Set<String> set = new HashSet<>(foreList);

        set.addAll(rearList);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        return list;
    }

    private int findCommaPosition(String expression) {
        int count = 0;
        int commaPosition = 0;

        while(commaPosition < expression.length() && (count != 0 || expression.charAt(commaPosition) != ',')) {
            switch (expression.charAt(commaPosition)) {
                case '{':
                    count++;
                    break;
                case '}':
                    count--;
                    break;
            }

            commaPosition++;
        }

        return commaPosition;
    }

    private int findBraceletPosition(String expression) {
        int depth = 0;
        int braceletPosition = 0;

        while(depth != 1 || expression.charAt(braceletPosition) != '}') {
            switch (expression.charAt(braceletPosition)) {
                case '{':
                    depth++;
                    break;
                case '}':
                    depth--;
                    break;
            }

            braceletPosition++;
        }

        return braceletPosition;
    }
}

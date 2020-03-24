package leetcode.Q01106;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    private static Pattern pattern = Pattern.compile("(t|f|\\!\\(.*?\\)+|\\&\\(.*?\\)+|\\|\\(.*?\\)+)");

    public boolean parseBoolExpr(String expression) {
        return parse(new ExpAndBools(expression));
    }

    private boolean parse(ExpAndBools expAndBools) {
        switch (expAndBools.exp) {
            case 't':
                return true;

            case 'f':
                return false;

            case '!':
                return !parse(new ExpAndBools(expAndBools.sub));

            case '&':
                for(String subExp : expAndBools.subExps) {
                    boolean exp = parse(new ExpAndBools(subExp));
                    if(!exp)
                        return false;
                }
                return true;

            case '|':
                for(String subExp : expAndBools.subExps) {
                    boolean exp = parse(new ExpAndBools(subExp));
                    if(exp)
                        return true;
                }
                return false;
        }

        return false;
    }


    private class ExpAndBools {
        private char exp;
        private String sub;
        private List<String> subExps;

        ExpAndBools(String expression) {
            this.exp = expression.charAt(0);
            this.subExps = new ArrayList<>();
            if(expression.length() <= 1) {
                return;
            }

            this.sub = expression.substring(2, expression.length() - 1);
            Matcher matcher = pattern.matcher(this.sub);
            while(matcher.find()) {
                subExps.add(matcher.group());
            }
        }
    }
}

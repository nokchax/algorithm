package Q00202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(set.add(n)) {
            int temp = 0;

            while(n > 0) {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
            
            if(temp == 1)
                return true;

            n = temp;
        }

        return false;
    }
}

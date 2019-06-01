package Q00066;

public class Solution {
    public int[] plusOne(int[] digits) {
        return recursive(digits, digits.length - 1);
    }

    private int[] recursive(int[] digits, int position) {
        if(position < 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;
        }

        if(digits[position] == 9) {
            digits[position] = 0;
            return recursive(digits, position - 1);
        } else {
            digits[position] += 1;
        }
        return digits;
    }
}

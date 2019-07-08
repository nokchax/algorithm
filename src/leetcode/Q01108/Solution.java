package leetcode.Q01108;

public class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[\\.\\]");
    }
}

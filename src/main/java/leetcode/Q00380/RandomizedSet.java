package leetcode.Q00380;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {
    Set<Integer> set = new HashSet<>();

    public RandomizedSet(){
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        Object[] arr = set.toArray();
        int idx = ThreadLocalRandom.current().nextInt(arr.length);

        return (int) arr[idx];
    }
}

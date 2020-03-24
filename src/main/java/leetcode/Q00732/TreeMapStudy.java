package leetcode.Q00732;

import java.util.TreeMap;

public class TreeMapStudy {
    private static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {

        start(10);
        end(20);

        start(50);
        end(60);

        start(10);
        end(40);

        start(5);
        end(15);

        start(5);
        end(10);

        start(25);
        end(55);

        for(int key : treeMap.keySet()) {
            System.out.println(key + " : " + treeMap.get(key));
        }

        System.out.println();
        System.out.println();

        for(int value : treeMap.values()) {
            System.out.println(value);
        }
    }


    private static void start(Integer key) {
        treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
    }

    private static void end(Integer key) {
        treeMap.put(key, treeMap.getOrDefault(key, 0) - 1);
    }
}

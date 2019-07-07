package leetcode.Q01103;

public class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        int candyCapacity = 0;
        int idx = 0;

        while(candies > 0) {
            if(candies < ++candyCapacity)
                candyCapacity = candies;

            people[idx++] += candyCapacity;
            candies -= candyCapacity;

            idx %= num_people;
        }

        return people;
    }
}

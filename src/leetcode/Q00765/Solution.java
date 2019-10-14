package leetcode.Q00765;

import java.util.*;

public class Solution {
    public int minSwapsCouples(int[] row) {
        Set<Candidate> set = new HashSet<>();
        Queue<Candidate> q = new LinkedList<>();

        Candidate candidate = new Candidate(row, 0);
        set.add(candidate);
        q.add(candidate);

        while(!q.isEmpty()) {
            Candidate curCandidate = q.poll();
            //System.out.println(Arrays.toString(curCandidate.row));

            if(isAllCoupleHoldingHands(curCandidate.row))
                return curCandidate.distance;

            for(int i = 0 ; i < row.length - 1 ; ++i) {
                for(int j = i + 1 ; j < row.length ; ++j) {
                    int[] newCandidate = curCandidate.row.clone();
                    int temp = newCandidate[i];
                    newCandidate[i] = newCandidate[j];
                    newCandidate[j] = temp;

                    Candidate newCandi = new Candidate(newCandidate, curCandidate.distance + 1);

                    //System.out.println(Arrays.toString(curCandidate.row) + " -> " + Arrays.toString(newCandidate));

                    if(!set.contains(newCandi)) {
                        set.add(newCandi);
                        q.add(newCandi);
                    }
                }
            }
        }


        return -1;
    }

    public boolean isAllCoupleHoldingHands(int[] row) {
        for(int i = 0 ; i < row.length ; i += 2) {
            if(row[i] % 2 == 0) {
                if(row[i + 1] != row[i] + 1)
                    return false;
            } else {
                if(row[i + 1] != row[i] - 1)
                    return false;
            }
        }

        return true;
    }

    public class Candidate {
        public int[] row;
        public int distance;

        public Candidate(int[] row, int distance) {
            this.row = row;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object obj) {
            for(int i = 0 ; i < this.row.length ; ++i) {
                if(this.row[i] != ((Candidate)obj).row[i])
                    return false;
            }
            return true;
        }
    }
}

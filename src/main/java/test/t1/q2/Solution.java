package test.t1.q2;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = Integer.parseInt(sc.nextLine());
        int column = Integer.parseInt(sc.nextLine());

        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0 ; i < row ; ++i) {
            List<Integer> bits = Arrays.stream(sc.nextLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            input.add(bits);
        }
        List<Integer> result = Result.solution(input);

        result.forEach(System.out::println);
    }
}

class Result {
    public static List<Integer> solution(List<List<Integer>> arr) {
        arr.forEach(subArr -> subArr.sort(Collections.reverseOrder()));

        PriorityQueue<Arr> queue = new PriorityQueue<>();
        for (int i = 0 ; i < arr.size() ; ++i) {
            queue.add(new Arr(i, arr.get(i)));
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
//            System.out.println(Arrays.toString(queue.peek().bitArr.toArray()));
            answer.add(queue.poll().index);
        }

        return answer;
    }
}

class Arr implements Comparable<Arr> {
    List<Integer> bitArr;
    int index;

    public Arr(int index, List<Integer> bitArr) {
        this.bitArr = bitArr;
        this.index = index;
    }

    @Override
    public int compareTo(Arr o) {
        for (int i = 0 ; i < this.bitArr.size() ; ++i) {
            if (this.bitArr.get(i) != o.bitArr.get(i)) {
                return this.bitArr.get(i) > o.bitArr.get(i) ? -1 : +1;
            }
        }

        return 0;
    }
}
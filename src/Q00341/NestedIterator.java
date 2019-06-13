package Q00341;

import java.util.*;
import java.util.function.Consumer;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> q = new ArrayList<>();
    private int curPosition = 0;
    public NestedIterator(List<NestedInteger> nestedList) {
        queueing(nestedList, q);
    }

    public static void queueing(List<NestedInteger> list, List<Integer> q) {
        for(NestedInteger nestedInteger : list)
            if(nestedInteger.isInteger()) {
                q.add(nestedInteger.getInteger());
            } else {
                queueing(nestedInteger.getList(), q);
            }
    }

    public Integer next() {
        Integer returnVal = q.get(curPosition);
        curPosition++;

        return returnVal;
    }

    public boolean hasNext() {
        return q.size() > curPosition;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super Integer> action) {

    }
}

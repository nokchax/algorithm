package leetcode.Q01114;

public class Foo {
    private volatile boolean first = false;
    private volatile boolean second = false;
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        first = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(!first) {
            Thread.sleep(10);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(!second) {
            Thread.sleep(10);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

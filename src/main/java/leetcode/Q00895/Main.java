package leetcode.Q00895;

public class Main {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();

        freqStack.push(5);
        freqStack.push(1);
        freqStack.push(2);
        freqStack.push(5);
        freqStack.push(5);
        freqStack.push(5);
        freqStack.push(1);
        freqStack.push(6);
        freqStack.push(1);
        freqStack.push(5);

        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}

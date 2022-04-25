package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int BEGIN = -1;
    public static final int ALL_NUMBERS = 12;
    private int[] numbers = new int[ALL_NUMBERS];

    public int total = BEGIN;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == -1;
    }

    public boolean isFull() {
        return total == 11;
    }

    protected int peekaboo() {
        if (callCheck())
            return -1;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return -1;
        return numbers[total--];
    }

}

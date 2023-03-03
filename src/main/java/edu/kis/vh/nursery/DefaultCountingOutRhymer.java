package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int BEGIN = -1;
    public static final int ALL_NUMBERS = 12;
    private final int[] numbers = new int[ALL_NUMBERS];

    private int total = BEGIN;

    public int getTotal() {
		return total;
	}

	public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    // TODO: nazwa funkcji nie przedstawia jasno jej dzialania, moglo by byc np. isEmpty
    public boolean callCheck() {
        return total == -1;
    }

    public boolean isFull() {
        return total == 11;
    }

    // TODO: nazwa tej funkcji moglaby miec nazwe sugerujaca jej dzialanie np. getTop albo getLast
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

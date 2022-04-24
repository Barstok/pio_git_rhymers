package edu.kis.vh.nursery;

// Złe były wiersze zawierające pole totalRejected oraz instrukcje warunkowe w metodzie countIn

public class HanoiRhymer extends DefaultCountingOutRhymer {

    int totalRejected = 0;

    public int reportRejected() {
        return totalRejected;
    }

    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}


// Kombinacja ALT + strzałka zmienia widok na nastepny lub poprzedni plik

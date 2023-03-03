package edu.kis.vh.nursery;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int RANDOM_BOUNDARY = 20;
    public static final int STANDARD_FALSE_FIFO_RHYMERS = 3;
    public static final int COUNTINS = 15;

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();

        testRhymers(factory);
        
    }
    
    static void testRhymers(RhymersFactory factory) {
    	DefaultCountingOutRhymer[] rhymers = {factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};
    	

        for (int i = 1; i < COUNTINS; i++)
            for (int j = 0; j < STANDARD_FALSE_FIFO_RHYMERS; j++)
                rhymers[j].countIn(i);
       

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < COUNTINS; i++)
            rhymers[STANDARD_FALSE_FIFO_RHYMERS].countIn(rn.nextInt(RANDOM_BOUNDARY));

        
        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        
        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[STANDARD_FALSE_FIFO_RHYMERS]).reportRejected());
    }

}
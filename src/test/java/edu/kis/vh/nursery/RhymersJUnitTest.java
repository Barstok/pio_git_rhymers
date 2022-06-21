package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;
import edu.kis.vh.nursery.list.IntLinkedList;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {
	
	//test przeszły pomyślnie

    public static final int TEST_VALUE = 4;
    public static final int COUNTINS = 888;

    @Test
    public void testDefaultRhymersFactory() {
        RhymersFactory rhymersFactory = new DefaultRhymersFactory();

        Assert.assertNotNull(rhymersFactory.getStandardRhymer());
        Assert.assertNotNull(rhymersFactory.getFalseRhymer());
        Assert.assertNotNull(rhymersFactory.getFIFORhymer());
        Assert.assertNotNull(rhymersFactory.getHanoiRhymer());
    }

    @Test
    public void testLLisEmpty(){
        IntLinkedList linkedList = new IntLinkedList();
        
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testLLisFull(){
        IntLinkedList linkedList = new IntLinkedList();

        Assert.assertFalse(linkedList.isFull());
    }

    @Test
    public void testLLpush(){
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.push(TEST_VALUE);

        Assert.assertFalse(linkedList.isEmpty());
    }

    @Test
    public void testLLpop(){
        IntLinkedList linkedList = new IntLinkedList();
        linkedList.push(TEST_VALUE);

        Assert.assertEquals(TEST_VALUE,linkedList.pop());
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testLLtop(){
        IntLinkedList linkedList = new IntLinkedList();

        linkedList.push(TEST_VALUE);
        
        Assert.assertEquals(TEST_VALUE,linkedList.top());
    }

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        rhymer.countIn(TEST_VALUE);

        int result = rhymer.peekaboo();
        Assert.assertEquals(TEST_VALUE, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertTrue(result);

        rhymer.countIn(COUNTINS);

        result = rhymer.callCheck();
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertFalse(result);
            rhymer.countIn(COUNTINS);
        }

        boolean result = rhymer.isFull();
        Assert.assertTrue(result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        rhymer.countIn(TEST_VALUE);

        result = rhymer.peekaboo();
        Assert.assertEquals(TEST_VALUE, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(TEST_VALUE, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        rhymer.countIn(TEST_VALUE);

        result = rhymer.countOut();
        Assert.assertEquals(TEST_VALUE, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testFIFORhymer() {
        FIFORhymer rhymer = new FIFORhymer();

        rhymer.countIn(1);
        rhymer.countIn(2);
        rhymer.countIn(3);

        Assert.assertEquals(rhymer.countOut(), 1);
        Assert.assertEquals(rhymer.countOut(), 2);
        Assert.assertEquals(rhymer.countOut(), 3);

        Assert.assertTrue(rhymer.callCheck());
    }

    @Test
    public void testHanoiRhymer() {
        HanoiRhymer rhymer = new HanoiRhymer();

        rhymer.countIn(TEST_VALUE);
        Assert.assertEquals(TEST_VALUE, rhymer.peekaboo());
    }

}

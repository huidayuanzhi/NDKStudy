package com.cheng.ndkstudy;

import org.junit.Test;

public class StackTest {

    @Test
    public void testNextGreaterElement1() {
        Logger.log("nextGreaterElement1");
        int[] result = StackDemo.nextGreaterElement1(
                new int[]{4,1,2},
                new int[]{1,3,4,2}
        ); // -1,3,-1
        Logger.log("nextGreaterElement1 result = ");
        Logger.log(result);
        int[] result2 = StackDemo.nextGreaterElement1(
                new int[]{2,4},
                new int[]{1,2,3,4}
        ); // 3,-1
        Logger.log("nextGreaterElement1 result = ");
        Logger.log(result2);
    }

    @Test
    public void testNextGreaterElement2() {
        Logger.log("nextGreaterElement2");
        int[] result = StackDemo.nextGreaterElement2(
                new int[]{4,1,2},
                new int[]{1,3,4,2}
        ); // -1,3,-1
        Logger.log("nextGreaterElement2 result = ");
        Logger.log(result);
        int[] result2 = StackDemo.nextGreaterElement2(
                new int[]{2,4},
                new int[]{1,2,3,4}
        ); // 3,-1
        Logger.log("nextGreaterElement2 result = ");
        Logger.log(result2);
    }

}

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

    @Test
    public void testNextGreaterElementsII() {
        Logger.log("nextGreaterElementsII");
        int[] result = StackDemo.nextGreaterElementsII(new int[]{1,2,1});
        Logger.log("nextGreaterElementsII result -");
        Logger.log(result); // 2,-1,2
        int[] result2 = StackDemo.nextGreaterElementsII(new int[]{1,2,3,4,3});
        Logger.log("nextGreaterElementsII result -");
        Logger.log(result2); // 2,3,4,-1,4
    }

    @Test
    public void testIsValid() {
        Logger.log("isValid");
        boolean result = StackDemo.isValid("()[]{}");
        Logger.log("isValid result = " + result); // true
        result = StackDemo.isValid("([])");
        Logger.log("isValid result = " + result); // true
        result = StackDemo.isValid("([)]");
        Logger.log("isValid result = " + result); // false
    }

}

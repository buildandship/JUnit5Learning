package com.learn.junit5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(2, actual, "The add method is used to test addition of two numbers");
    }

    @Test
    void testComputeCircleArea(){
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.159265358979323846, mathUtils.computeCircleArea(10));
    }
/*
    @Test
    void testFail(){
        fail("Not yet implemented");
    }
*/


}

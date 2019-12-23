package com.learn.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @BeforeEach
    void init(){

    }

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
        assertEquals(314.159265358979323846, mathUtils.computeCircleArea(10),"Should return correct circle area");
    }

    @Test
    void testDivide(){
        MathUtils mathUtils = new MathUtils();
        //assertThrows(Exception Type, Executable Lambda);
        assertThrows(ArithmeticException.class, () ->   mathUtils.divide(1,0),"Divide by zero should throw an exception");

    }

/*
    @Test
    void testFail(){
        fail("Not yet implemented");
    }
*/


}

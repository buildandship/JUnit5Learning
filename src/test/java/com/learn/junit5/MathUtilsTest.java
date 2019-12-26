package com.learn.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("BeforeAll Method called");
    }

    @AfterAll
    static void afterAllCleanup() {
        System.out.println("AfterAll Clean up called");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo=testInfo;
        this.testReporter=testReporter;

        System.out.println(testInfo.getTestClass() + " \t " + testInfo.getTestMethod() + "\t" + testInfo.getDisplayName());
        testReporter.publishEntry("Testing Test", "Testing Test Reporter");

        System.out.println("Init Method called with BeforeEach");
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleanup Method called with AfterEach");
    }


    @Test
    @DisplayName("Testing Add Method")
    void testAdd() {
        //MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        assertEquals(expected, actual, "The add method is used to test addition of two numbers");
    }

    @Test
    @DisplayName("Testing Compute Circle Area Method")
    @Tag("Geometry")
    void testComputeCircleArea() {
        //MathUtils mathUtils = new MathUtils();
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertEquals(314.159265358979323846, mathUtils.computeCircleArea(10), "Should return correct circle area");
    }

    @Test
    //@EnabledOnOs(OS.MAC)
    @DisplayName("Testing Divide with Exception")
    void testDivide() {
        //MathUtils mathUtils = new MathUtils();
        //assertThrows(Exception Type, Executable Lambda);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw an exception");

    }

    @Test
    @DisplayName("Test multiply method")
    void testMultiply() {
        // assertEquals(4, mathUtils.multiply(2,2)," Should return the correct product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2), " Should return the correct product"),
                () -> assertEquals(-4, mathUtils.multiply(-2, 2), " Should return the correct product"),
                () -> assertEquals(4, mathUtils.multiply(-2, -2), " Should return the correct product"),
                () -> assertEquals(0, mathUtils.multiply(0, 2), " Should return the correct product")
        );
    }

/*    @Test
    @Disabled
    @DisplayName("TDD method should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }*/

    @Nested
    @DisplayName(" Class Add Test for collective test cases")
    @Tag("Arithmetic")
    class AddTest {

        @Test
        @DisplayName("Test Add Positive numbers")
        void testAddPositive() {
            assertEquals(2, mathUtils.add(1, 1), "should return the correct sum");
        }

        @Test
        @DisplayName("Test Add Negative numbers")
        void testAddNegative() {
            //assertEquals(-2,mathUtils.add(-1,-1),"should return the correct sum");
            //int expected=-3;
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            // assertEquals(expected, actual, "should return sum "+expected+" but returned "+actual);

            assertEquals(expected, actual, () -> "should return sum " + expected + " but returned " + actual);

        }
    }


    @Test
    @DisplayName("Subtract Test Method")
    //@RepeatedTest(3)
    void testSubtract(){
        //System.out.println(repetitionInfo.getCurrentRepetition());
        assertEquals(3 , mathUtils.subtract(5,2),"Should return the correct results after subtraction");
    }

/*
    @Test
    void testFail(){
        fail("Not yet implemented");
    }

*/

}

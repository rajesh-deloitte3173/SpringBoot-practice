package com.groupname.artifactname;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MyClassJunitTest {
    MyClassJunit myClassJunit = new MyClassJunit();

    @BeforeEach
    public void before(){
        System.out.println("Before");
    }

    @AfterEach
    public void after(){
        System.out.println("After");
    }

    @BeforeAll
    public static void beforeClass(){
        System.out.println("Before class");
    }

    @AfterAll
    public static void afterClass(){
        System.out.println("After class");
    }

    @Test
    public void sumofThree(){
        int result = myClassJunit.sum(new int[]{1,2,3});
        assertEquals(6,result);
        assertTrue(true);
        assertFalse(false);
        System.out.println("Test1");
    }

    @Test
    public void sumOfTwo(){
        int result = myClassJunit.sum(new int[]{1,2});
        assertEquals(3,result);
        System.out.println("Test 2");
    }
}

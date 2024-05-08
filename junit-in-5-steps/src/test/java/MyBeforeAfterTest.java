import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MyBeforeAfterTest {

    @BeforeAll
    static void init() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("After all tests");
    }

    @BeforeEach
    void setup() {
        System.out.println("Before each test");
    }

    @AfterEach
    void teardown() {
        System.out.println("After each test");
    }

    @Test
    void test1() {
        System.out.println("Test 1");
    }

    @Test
    void test2() {
        System.out.println("Test 2");
    }
}

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {
    List<String> todos = Arrays.asList("Learn Spring", "Learn Spring Boot", "Learn Docker");

    @Test
    void test() {
        assertTrue(todos.contains("Learn Spring"));
        assertFalse(todos.contains("Learn Java"));
        assertEquals(3, todos.size());
        assertArrayEquals(new String[]{"Learn Spring", "Learn Spring Boot", "Learn Docker"}, todos.toArray());
    }
}

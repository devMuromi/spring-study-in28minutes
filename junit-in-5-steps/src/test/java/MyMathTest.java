import org.example.junit.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    public void calculateSum_ThreeMemberArray() {
        assertEquals(15, math.calculateSum(new int[] {1, 2, 3, 4, 5}));
    }

    @Test
    public void calculateSum_ZeroLengthArray() {
        assertEquals(0, math.calculateSum(new int[] {}));
    }
}

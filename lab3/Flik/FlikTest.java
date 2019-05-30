import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    @Test
    public void testIsSame() {
        assertTrue(Flik.isSameNumber(3, 3));
        assertFalse(Flik.isSameNumber(3, 2));
        assertTrue(Flik.isSameNumber(128, 128));
    }
}

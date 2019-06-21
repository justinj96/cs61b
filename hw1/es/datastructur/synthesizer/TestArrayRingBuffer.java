package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.dequeue();
        arb.enqueue(3);
        ArrayRingBuffer arc = new ArrayRingBuffer(10);
        arc.enqueue(1);
        arc.enqueue(2);
        arc.dequeue();
        arc.enqueue(3);

        assertTrue(arb.equals(arc));
        arc.dequeue();
        assertFalse(arc.equals(arb));
    }
}

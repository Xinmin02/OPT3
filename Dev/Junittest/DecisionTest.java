import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DecisionTest {

    public boolean decision(boolean A, boolean B, boolean C) {
        return A && B && C;
    }

    @Test
    public void testDecision() {

        assertTrue(decision(true, true, true));


        assertFalse(decision(true, true, false));

        assertFalse(decision(true, false, true));


        assertFalse(decision(true, false, false));


        assertFalse(decision(false, true, true));


        assertFalse(decision(false, true, false));


        assertFalse(decision(false, false, true));


        assertFalse(decision(false, false, false));
    }
}
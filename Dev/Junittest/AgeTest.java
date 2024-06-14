import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AgeTest {

    public String decide(int age) {
        if (age < 18) {
            return "Afwijzen";
        } else if (age <= 65) {
            return "Accepteren";
        } else {
            return "Extra controle";
        }
    }

    @Test
    public void testAgeDecision() {
        // Equivalentieklasse 1
        assertEquals("Afwijzen", decide(17));
        assertEquals("Afwijzen", decide(0));

        // Equivalentieklasse 2
        assertEquals("Accepteren", decide(18));
        assertEquals("Accepteren", decide(30));
        assertEquals("Accepteren", decide(65));

        // Equivalentieklasse 3
        assertEquals("Extra controle", decide(66));
        assertEquals("Extra controle", decide(80));
    }
}

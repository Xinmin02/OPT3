import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PairwiseTesting {

    @Test
    void testPersonenautoOpVoorraadVerzekerdKlantA() {
        Product personenauto = new Personenauto("Zwarte auto", "BMW", 1200, 1800, true);
        // Verwacht 50 + 0.01 * 1800 = 68
        assertEquals(68.0, personenauto.getHuurprijsPerDag());
    }

    @Test
    void testPersonenautoOpVoorraadVerzekerdKlantB() {
        Product personenauto = new Personenauto("Rode auto", "Audi", 1300, 2200, true);
        // Verwacht 50 + 0.01 * 2200 = 72
        assertEquals(72.0, personenauto.getHuurprijsPerDag());
    }

    @Test
    void testPersonenautoOpVoorraadNietVerzekerd() {
        Product personenauto = new Personenauto("Blauwe auto", "Volkswagen", 1400, 1600, false);
        // Verwacht 50 + 0.01 * 1600 = 66
        assertEquals(66.0, personenauto.getHuurprijsPerDag());
    }

    @Test
    void testPersonenautoVerhuurdVerzekerdKlantA() {
        Product personenauto = new Personenauto("Groene auto", "Mercedes", 1500, 2000, true);
        // Verwacht 50 + 0.01 * 2000 = 70
        assertEquals(70.0, personenauto.getHuurprijsPerDag());
    }

    @Test
    void testPersonenautoVerhuurdVerzekerdKlantB() {
        Product personenauto = new Personenauto("Witte auto", "Toyota", 1600, 1900, true);
        // Verwacht 50 + 0.01 * 1900 = 69
        assertEquals(69.0, personenauto.getHuurprijsPerDag());
    }

    @Test
    void testPersonenautoVerhuurdNietVerzekerd() {
        Product personenauto = new Personenauto("Gele auto", "Ford", 1700, 2100, false);
        // Verwacht 50 + 0.01 * 2100 = 71
        assertEquals(71.0, personenauto.getHuurprijsPerDag());
    }

    @Test
    void testVrachtautoOpVoorraadVerzekerdKlantA() {
        Product vrachtauto = new Vrachtauto("Grote truck", 3000, 5000, true);
        // Verwacht 0.10 * 3000 + 0.01 * 5000 = 300 + 50 = 350
        assertEquals(350.0, vrachtauto.getHuurprijsPerDag());
    }

    @Test
    void testVrachtautoOpVoorraadVerzekerdKlantB() {
        Product vrachtauto = new Vrachtauto("Kleine truck", 2500, 4000, true);
        // Verwacht 0.10 * 2500 + 0.01 * 4000 = 250 + 40 = 290
        assertEquals(290.0, vrachtauto.getHuurprijsPerDag());
    }

    @Test
    void testVrachtautoOpVoorraadNietVerzekerd() {
        Product vrachtauto = new Vrachtauto("Middelgrote truck", 2000, 3500, false);
        // Verwacht 0.10 * 2000 + 0.01 * 3500 = 200 + 35 = 235
        assertEquals(235.0, vrachtauto.getHuurprijsPerDag());
    }

    @Test
    void testVrachtautoVerhuurdVerzekerdKlantA() {
        Product vrachtauto = new Vrachtauto("Luxe truck", 4000, 6000, true);
        // Verwacht 0.10 * 4000 + 0.01 * 6000 = 400 + 60 = 460
        assertEquals(460.0, vrachtauto.getHuurprijsPerDag());
    }

    @Test
    void testVrachtautoVerhuurdVerzekerdKlantB() {
        Product vrachtauto = new Vrachtauto("Economische truck", 3500, 4500, true);
        // Verwacht 0.10 * 3500 + 0.01 * 4500 = 350 + 45 = 395
        assertEquals(395.0, vrachtauto.getHuurprijsPerDag());
    }

    @Test
    void testVrachtautoVerhuurdNietVerzekerd() {
        Product vrachtauto = new Vrachtauto("Standaard truck", 3000, 4000, false);
        // Verwacht 0.10 * 3000 + 0.01 * 4000 = 300 + 40 = 340
        assertEquals(340.0, vrachtauto.getHuurprijsPerDag());
    }

    @Test
    void testBoormachineOpVoorraadVerzekerdKlantA() {
        Product boormachine = new Boormachine("Krachtige boormachine", "Bosch", "Type X", true);
        // Verwacht 15
        assertEquals(15.0, boormachine.getHuurprijsPerDag());
    }

    @Test
    void testBoormachineOpVoorraadVerzekerdKlantB() {
        Product boormachine = new Boormachine("Professionele boormachine", "Makita", "Type Y", true);
        // Verwacht 15
        assertEquals(15.0, boormachine.getHuurprijsPerDag());
    }

    @Test
    void testBoormachineOpVoorraadNietVerzekerd() {
        Product boormachine = new Boormachine("Handige boormachine", "DeWalt", "Type Z", false);
        // Verwacht 15
        assertEquals(15.0, boormachine.getHuurprijsPerDag());
    }

    @Test
    void testBoormachineVerhuurdVerzekerdKlantA() {
        Product boormachine = new Boormachine("Compacte boormachine", "Hitachi", "Type A", true);
        // Verwacht 15
        assertEquals(15.0, boormachine.getHuurprijsPerDag());
    }

    @Test
    void testBoormachineVerhuurdVerzekerdKlantB() {
        Product boormachine = new Boormachine("Draagbare boormachine", "Black & Decker", "Type B", true);
        // Verwacht 15
        assertEquals(15.0, boormachine.getHuurprijsPerDag());
    }

    @Test
    void testBoormachineVerhuurdNietVerzekerd() {
        Product boormachine = new Boormachine("Accu boormachine", "Ryobi", "Type C", false);
        // Verwacht 15
        assertEquals(15.0, boormachine.getHuurprijsPerDag());
    }
}

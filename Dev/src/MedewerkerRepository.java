
import java.util.HashMap;
import java.util.Map;

public class MedewerkerRepository {
    private Map<String, Medewerker> medewerkers = new HashMap<>();

    public MedewerkerRepository() {
        // Voorbeeld medewerkers
        medewerkers.put("johndoe", new Medewerker("johndoe", "password123"));
        medewerkers.put("janedoe", new Medewerker("janedoe", "password456"));
    }

    public Medewerker findByGebruikersnaam(String gebruikersnaam) {
        return medewerkers.get(gebruikersnaam);
    }
}

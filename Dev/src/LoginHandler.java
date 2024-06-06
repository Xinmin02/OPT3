public class LoginHandler {
    private MedewerkerRepository medewerkerRepository;

    public LoginHandler(MedewerkerRepository medewerkerRepository) {
        this.medewerkerRepository = medewerkerRepository;
    }

    public Medewerker verifieer(String gebruikersnaam, String wachtwoord) {
        Medewerker medewerker = medewerkerRepository.findByGebruikersnaam(gebruikersnaam);
        if (medewerker != null && medewerker.inloggen(wachtwoord)) {
            return medewerker;
        }
        return null;
    }

    public void verwerkLogin(Medewerker medewerker) {
        System.out.println("Medewerker " + medewerker.getGebruikersnaam() + " is ingelogd.");
    }
}

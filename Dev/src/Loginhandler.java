public class Loginhandler {
    public boolean verifieer(Medewerker medewerker, String wachtwoord) {
        return medewerker.inloggen(wachtwoord);
    }

    public void verwerkLogin(Medewerker medewerker) {

    }
}
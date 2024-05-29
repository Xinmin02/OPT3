public class Medewerker {
    private String gebruikersnaam;
    private String wachtwoord;

    public Medewerker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public boolean inloggen(String wachtwoord) {
        return this.wachtwoord.equals(wachtwoord);
    }

    public void uitloggen() {
    }
}
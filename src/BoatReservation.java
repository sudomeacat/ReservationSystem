import java.util.ArrayList;

public class BoatReservation extends Reservation {
    private ArrayList<String> preferences = new ArrayList<>();
    
    public BoatReservation(int time_slot, String name) {
        super(name, time_slot);
    }
    
    void addBoatPreference(String type) {
        preferences.add(type);
    }
    
    public ArrayList<String> getPreferences() {
        return this.preferences;
    }
}

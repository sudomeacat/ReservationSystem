import java.util.ArrayList;

public class BoatReservation extends Reservation {
    private ArrayList<String> preferences = new ArrayList<>();
    
    public BoatReservation(int time_slot, String name) {
        super(name, time_slot);
    }
    
    /**
     * Add a boat to the list of preferences.
     *
     * @param type The type of boat to add.
     */
    void addBoatPreference(String type) {
        preferences.add(type);
    }
    
    /**
     * Gets the ArrayList of preferences.
     *
     * @return The ArrayList of Strings containing the person's preferences.
     */
    public ArrayList<String> getPreferences() {
        return this.preferences;
    }
}

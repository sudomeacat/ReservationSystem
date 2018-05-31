import java.util.Scanner;

public abstract class ReservableItem {
    private static final int SLOTS = 10;
    private Reservation[] reservations = new Reservation[SLOTS];
    private String id;
    
    public ReservableItem(Scanner id) {
        this.id = id.nextLine();
    }
    
    public final String getId() {
        return id;
    }
    
    public abstract int getFitnessValue(Reservation res);
    
    public final Reservation[] getReservations() {
        return reservations;
    }
}

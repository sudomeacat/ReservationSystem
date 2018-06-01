import java.util.Scanner;

public abstract class ReservableItem {
    private static final int SLOTS = 10;
    private Reservation[] reservations = new Reservation[SLOTS];
    private String id;
    
    public ReservableItem(Scanner id) {
        this.id = id.nextLine();
    }
    
    public String getId() {
        return id;
    }
    
    /**
     *
     * @param res
     * @return
     */
    public abstract int getFitnessValue(Reservation res);
    
    public final Reservation[] getReservations() {
        return reservations;
    }
}

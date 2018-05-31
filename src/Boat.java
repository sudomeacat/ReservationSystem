import java.util.Scanner;

public class Boat extends ReservableItem {
    public Boat(Scanner id) {
        super(id);
    }
    
    /**
     * If this slot is available,
     * then return 1 (or any generic positive number),
     * else return -1 (or any negative number).
     *
     * @param res Reservation to test with.
     * @return Positive integer if available at that time, negative if not.
     */
    @Override
    public int getFitnessValue(Reservation res) {
        return getReservations()[res.getTime()] == null ? 1 : -1;
    }
}

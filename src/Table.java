import java.util.Scanner;

public class Table extends ReservableItem {
    private int num_seats;
    
    public Table(Scanner scanner) {
        super(new Scanner(scanner.next()));
        this.num_seats = scanner.nextInt();
    }
    
    public int getNumSeats() {
        return num_seats;
    }
    
    /**
     * Returns a value based on how well the Reservation can apply to the current standing of tables.
     * The scale is (for fitness value t):
     * t < 0, no fit at all.
     * the closer t is to 0, the better it is.
     * The scale is flipped to manage a table with a theoretical infinite seats.
     *
     * @param res The reservation to trial against.
     * @return An integer based on the scale above when comparing the Reservation object to the slot.
     */
    @Override
    public int getFitnessValue(Reservation res) {
        return getReservations()[res.getTime()] == null ? getNumSeats() - ((RestaurantReservation)res).getNumSeatsNeeded() : -1;
    }
}

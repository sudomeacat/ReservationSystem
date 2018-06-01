public class RestaurantReservation extends Reservation {
    private int num_seats_needed;
    
    public RestaurantReservation(int num_seats_needed, int time_slot, String name) {
        super(name, time_slot);
        this.num_seats_needed = num_seats_needed;
    }
    
    public int getNumSeatsNeeded() {
        return num_seats_needed;
    }
    
    @Override
    public String toString() {
        return super.toString() + " : " + num_seats_needed;
    }
}

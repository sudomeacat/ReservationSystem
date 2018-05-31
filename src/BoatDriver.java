//package ReservationSystem;
/*
 * Reservation System homework
 * CSS143
 * Lesley Kalmin
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Driver for Boat Reservation system
 * Reads input file and prints reservations to console
 */
public class BoatDriver {
	public static void main(String[] args) {
	    ResManager<Boat, Reservation> manager = new ResManager<>();
        try (Scanner scanner = new Scanner(new FileInputStream("boatFile.txt"))) {
            while (scanner.hasNext()) {
                manager.addReservable(new Boat(scanner));
            }
        } catch (FileNotFoundException e) {
            System.exit(1);
        }
        
        System.out.println();
        
        BoatReservation r;
        r = new BoatReservation(2, "Chen family");
        r.addBoatPreference("kayak");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("canoe");
        manager.makeReservation(r);
        r = new BoatReservation(8, "Singh party");
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        r = new BoatReservation(8, "Kal");
        r.addBoatPreference("dinghy");
        r.addBoatPreference("yacht");
        r.addBoatPreference("rowboat");
        manager.makeReservation(r);
        r = new BoatReservation(8, "Party9");
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        r = new BoatReservation(2, "Newmans");
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        r = new BoatReservation(3, "Party2");
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        r = new BoatReservation(9, "Party5");
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        r = new BoatReservation(1, "Party6");
        r.addBoatPreference("aircraft carrier");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        r = new BoatReservation(3, "Party3");
        r.addBoatPreference("speedboat");
        r.addBoatPreference("zodiak");
        r.addBoatPreference("submarine");
        manager.makeReservation(r);
        
        // Force failure
        r = new BoatReservation(3, "Unlucky party");
        r.addBoatPreference("zodiak");
        manager.makeReservation(r);
        
        System.out.println("\nreservations before sort by customer");
//        System.out.println(manager);
        for (Iterator<Reservation> iterator = manager.getAllReservations(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        System.out.println("\nreservations after sort by customer");
        manager.sortReservations();
        //System.out.println(manager);
        for (Iterator<Reservation> iterator = manager.getAllReservations(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}

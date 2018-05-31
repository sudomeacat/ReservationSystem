
/*
 *  CSS162 Final Homework - Reservation System
 *  
 *  Skeleton Driver for Restaurant Reservation System.
 *  Fill in missing section indicated below.
 *  
 *  @author Krish Kalai
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class RestaurantDriver {
	private static ResManager<Table, Reservation> tableMgr = new ResManager<>();

	public static void main(String[] args) {

		readItems("tableFile.txt");
		// You can start by testing without the user input
        testWithoutUI();
        
//        Scanner keybd = new Scanner(System.in);
//        while (true) {
//            String line = keybd.nextLine();
//            if (line.equalsIgnoreCase("end")) {
//                break;
//            }
//            String[] components = line.split("[ ]");
//            RestaurantReservation trial = new RestaurantReservation(components[0], Integer.parseInt(components[1]), Integer.parseInt(components[2]));
//            tableMgr.makeReservation(trial);
//        }
//
//        java.util.Iterator<Reservation> iterator = tableMgr.getAllReservations();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("\n\nSorted");
//        tableMgr.sortReservations();
//        iterator = tableMgr.getAllReservations();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        
	}

	public static void readItems(String filename) {
        try (Scanner stream = new Scanner(new FileInputStream(filename))) {
            while (stream.hasNext()) {
                Table table = new Table(stream);
                tableMgr.addReservable(table);
                
                //System.out.println(table.getId() + " " + table.getNumSeats());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

	// As an intermediate step in development, you can test here without the user input
	public static void testWithoutUI() {
		RestaurantReservation trial;
		
//        trial = new RestaurantReservation("Rodriguez", 3, 4);
//        tableMgr.makeReservation(trial);
//		trial = new RestaurantReservation("Chan", 3, 6);
//		tableMgr.makeReservation(trial);
//		trial = new RestaurantReservation("Smith", 3, 2);
//		tableMgr.makeReservation(trial);
//		trial = new RestaurantReservation("Nguyen", 3, 4);
//		tableMgr.makeReservation(trial);
//		trial = new RestaurantReservation("Shah", 2, 8);
//		tableMgr.makeReservation(trial);
//		trial = new RestaurantReservation("Patel", 2, 25);
//		tableMgr.makeReservation(trial);
        
//        trial = new RestaurantReservation("TooBig", 4, 11);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("party6", 4, 10);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("overflow time", 3, 10);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("Chen family", 3, 2);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("Singh party", 4, 8);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("Kal", 4, 8);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("business1", 4, 8);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("Newmans", 2, 2);
//        tableMgr.makeReservation(trial);
//        trial = new RestaurantReservation("party5", 4, 10);
//        tableMgr.makeReservation(trial);
//        //trial = new RestaurantReservation("Newmans", 2, 2);
//        //tableMgr.makeReservation(trial);
        
        for (int i = 1; i <= 11; i++) {
            for (int j = 0; j < 10; j++) {
                trial = new RestaurantReservation(i + " " + j, j, 1);
                tableMgr.makeReservation(trial);
            }
        }
        
		java.util.Iterator<Reservation> iterator = tableMgr.getAllReservations();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
        
        System.out.println("\n\nSorted");
		tableMgr.sortReservations();
        iterator = tableMgr.getAllReservations();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
	}

}

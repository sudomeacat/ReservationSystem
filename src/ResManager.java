import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class ResManager<ItemType extends ReservableItem, ResType extends Reservation> {
    private ArrayList<ItemType> items;
    private ArrayList<ResType> reservations;
    
    public ResManager() {
        items = new ArrayList<>();
        reservations = new ArrayList<>();
    }
    
    public void addReservable(ItemType item) {
        items.add(item);
    }
    
    public Reservation makeReservation(ResType trialRes) {
        if (trialRes instanceof RestaurantReservation) {
            int[] values = items.stream().mapToInt(item -> item.getFitnessValue(trialRes)).toArray();
            int min_value = Arrays.stream(values).filter(t -> t >= 0).min().orElse(-1);
            if (min_value >= 0) {
                int idx = IntStream.range(0, values.length).filter(i -> values[i] == min_value).findFirst().orElse(-1);
                trialRes.setResourceId(items.get(idx).getId());
                reservations.add(trialRes);
                items.get(idx).getReservations()[trialRes.getTime()] = trialRes;
                return trialRes;
            }
        }
        else if (trialRes instanceof BoatReservation) {
            int i = 0, j = 0;
            BoatReservation reservation = (BoatReservation)trialRes;
            outer:
            for (; i < reservation.getPreferences().size(); i++) {
                j = 0;
                for (; j < items.size(); j++) {
                    if (items.get(j).getId().equals(reservation.getPreferences().get(i))) {
                        if (items.get(j).getFitnessValue(reservation) > 0) {
                            break outer;
                        }
                    }
                }
            }
            if (i != reservation.getPreferences().size()) {
                trialRes.setResourceId(items.get(j).getId());
                reservations.add(trialRes);
                items.get(j).getReservations()[trialRes.getTime()] = trialRes;
                return trialRes;
            }
        }
        return null;
    }
    
    public void sortReservations() {
        for (int i = 0; i < reservations.size(); i++) {
            for (int j = 0; j < reservations.size(); j++) {
                if(reservations.get(i).compareTo(reservations.get(j)) < 0) {
                    ResType type = reservations.get(i);
                    reservations.set(i, reservations.get(j));
                    reservations.set(j, type);
                }
            }
        }
    }
    
    @Override
    public String toString() {
        return reservations.toString();
    }
    
    public Iterator<Reservation> getAllReservations() {
        return new Iterator<Reservation>() {
            int i = 0;
            
            @Override
            public boolean hasNext() {
                return i < reservations.size();
            }
    
            @Override
            public Reservation next() {
                return reservations.get(i++);
            }
        };
    }
}

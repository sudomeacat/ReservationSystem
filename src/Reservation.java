public class Reservation implements Comparable<Reservation> {
    private String id;
    private String customer_name;
    private int time_slot;
    
    public Reservation (String customer_name, int time_slot) {
        this.customer_name = customer_name;
        this.time_slot = time_slot;
        id = null;
    }
    
    public String getCustomer() {
        return customer_name;
    }
    
    public int getTime() {
        return time_slot;
    }
    
    @Override
    public String toString() {
        return customer_name + " @ " + time_slot + " in " + id;
    }
    
    public void setResourceId(String id) {
        this.id = id;
    }
    
    @Override
    public int compareTo(Reservation rhs) {
        return this.customer_name.compareTo(rhs.customer_name);
    }
}
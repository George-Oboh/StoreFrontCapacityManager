import java.util.ArrayList;

public class myCapacityManager {

    private static final int STOREFRONT_CAPACITY = 6000;
    private static final CURRENT_IN_LINE = 5000;
    private static final WAITLIST = 2500;

    public static void main(String[] args) {
        ArrayList<String> outside_line = new ArrayList<>();
        ArrayList<String> waitlist = new ArrayList<>();
        ArrayList<String> permanentStorage = new ArrayList<>();

        populateList(outside_line, CURRENT_IN_LINE, "People in Line");
        populateList(waitlist, WAITLIST, "Wait list");

        manageCapacity(outside_line, waitlist, permanentStorage);
        printResults(outside_line, waitlist, permanentStorage);
    }

    private static void populateList(ArrayList<String> list, int count, String prefix) {
        for (int i = 1; i <= count; i++) {
            list.add(prefix + i);
        }
    }

    private static void manageCapacity(ArrayList<String> outside_line, ArrayList<String> waitlist, ArrayList<String> permanentStorage) {
        int spotsAvailable = MAX_CAPACITY - outside_line.size();
        int addGuest = Math.min(spotsAvailable, waitlist.size());

        for (int i = 0; i < addGuest; i++) {
            String selectedPerson = waitlist.get(0);
            outside_line.add(selectedPerson);
            permanentStorage.add(selectedPerson);
            waitlist.remove(0);
        }
    }

    private static void printResults(ArrayList<String> outside_line, ArrayList<String> waitlist, ArrayList<String> permanentStorage) {
        System.out.println("Final line size: " + outside_line.size());
        System.out.println("Remaining waitlist size: " + waitlist.size());
        System.out.println("Permanent storage size: " + permanentStorage.size());
    }
}

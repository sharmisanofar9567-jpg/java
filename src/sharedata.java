package src;

import java.util.ArrayList;

public class Sharedata {

    public static ArrayList<Emergency> emergencyList =
            new ArrayList<Emergency>();

    public static int nextID = 1;

    public static String generateID() {
        String id = String.format("E%03d", nextID);
        nextID++;
        return id;
    }

    public static void addEmergency(Emergency e) {
        emergencyList.add(e);
    }

    public static Emergency findEmergency(String id) {
        for (Emergency e : emergencyList) {
            if (e.emergencyID.equals(id)) {
                return e;
            }
        }
        return null;
    }

    public static int getTotalIncidents() {
        return emergencyList.size();
    }
}

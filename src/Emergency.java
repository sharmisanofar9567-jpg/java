package src;

public class Emergency {

    public String emergencyID;
    public String emergencyType;
    public String priority;
    public String location;
    public int peopleAffected;
    public String emergencyService;
    public String status;
    public String reportedBy;

    public Emergency(String emergencyID, String emergencyType,
            String priority, String location, int peopleAffected,
            String emergencyService, String reportedBy) {

        this.emergencyID = emergencyID;
        this.emergencyType = emergencyType;
        this.priority = priority;
        this.location = location;
        this.peopleAffected = peopleAffected;
        this.emergencyService = emergencyService;
        this.reportedBy = reportedBy;

        this.status = "Pending";
    }
}

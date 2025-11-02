package singletonPattern;

public class HelpDeskStation {
	private String stationName;
    private int stationNumber;
    private CentralizedQueueManager queueManager;
    private int currentlyServing;
    
    public HelpDeskStation(int stationNumber) {
        this.stationNumber = stationNumber;
        this.stationName = "Help Desk " + stationNumber;
        this.queueManager = CentralizedQueueManager.getInstance();
        this.currentlyServing = 0;
    }
    
    public void callNextCustomer() {
        queueManager.serveNextCustomer(stationName);
        this.currentlyServing = queueManager.getLastServedNumber();
    }
    
    public void resetQueue(int newNumber) {
        queueManager.resetQueue(newNumber, stationName);
        this.currentlyServing = 0;
    }
    
    public int getCurrentlyServing() {
        return currentlyServing;
    }
    
    public String getStationName() {
        return stationName;
    }
}

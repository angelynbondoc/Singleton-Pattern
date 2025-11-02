package singletonPattern;

public class CentralizedQueueManager {
	private static CentralizedQueueManager instance;
    private int currentQueueNumber;
    private int lastServedNumber;
    private final Object lock = new Object();
    
    private CentralizedQueueManager() {
        this.currentQueueNumber = 0;
        this.lastServedNumber = 0;
    }
    
    public static CentralizedQueueManager getInstance() {
        if (instance == null) {
            synchronized (CentralizedQueueManager.class) {
                if (instance == null) {
                    instance = new CentralizedQueueManager();
                }
            }
        }
        return instance;
    }
    
    public int getNextQueueNumber() {
        synchronized (lock) {
            currentQueueNumber++;
            return currentQueueNumber;
        }
    }
    
    public void serveNextCustomer(String stationName) {
        synchronized (lock) {
            if (lastServedNumber < currentQueueNumber) {
                lastServedNumber++;
                System.out.println("\n[" + stationName + "] Now serving: Queue #" + lastServedNumber);
            } else {
                System.out.println("\n[" + stationName + "] No customers in queue!");
            }
        }
    }
    
    public void resetQueue(int newNumber, String stationName) {
        synchronized (lock) {
            this.currentQueueNumber = newNumber;
            this.lastServedNumber = newNumber;
            System.out.println("\n[" + stationName + "] Queue has been reset to: " + newNumber);
        }
    }
    
    public int getCurrentQueueNumber() {
        synchronized (lock) {
            return currentQueueNumber;
        }
    }
    
    public int getLastServedNumber() {
        synchronized (lock) {
            return lastServedNumber;
        }
    }
    
    public int getWaitingCustomers() {
        synchronized (lock) {
            return currentQueueNumber - lastServedNumber;
        }
    }
}

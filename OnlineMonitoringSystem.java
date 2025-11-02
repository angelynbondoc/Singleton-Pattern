package singletonPattern;

public class OnlineMonitoringSystem {
    private CentralizedQueueManager queueManager;
    
    public OnlineMonitoringSystem() {
        this.queueManager = CentralizedQueueManager.getInstance();
    }
    
    public void displayQueueStatus() {
        System.out.println("PAG-IBIG QUEUE MONITORING SYSTEM");
        System.out.println("Now Serving: " + String.format("%3d", queueManager.getLastServedNumber()));
        System.out.println("Last Ticket Issued: " + String.format("%3d", queueManager.getCurrentQueueNumber()));
        System.out.println("Waiting in Queue: " + String.format("%3d", queueManager.getWaitingCustomers()));
    }
}

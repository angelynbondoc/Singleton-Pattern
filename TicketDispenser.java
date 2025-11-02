package singletonPattern;

public class TicketDispenser {
private CentralizedQueueManager queueManager;
    
    public TicketDispenser() {
        this.queueManager = CentralizedQueueManager.getInstance();
    }
    
    public int issueTicket() {
        return queueManager.getNextQueueNumber();
    }
    
    public void printTicket(int ticketNumber) {
        System.out.println("PAG-IBIG FUND OFFICE");
        System.out.println("YOUR QUEUE NUMBER: " + ticketNumber);
        System.out.println("Please wait for your number to be called");
    }
}
    
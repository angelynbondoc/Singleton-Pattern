package singletonPattern;

import java.util.Scanner;

public class PagibigQueuingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //system components
        TicketDispenser dispenser = new TicketDispenser();
        HelpDeskStation station1 = new HelpDeskStation(1);
        HelpDeskStation station2 = new HelpDeskStation(2);
        HelpDeskStation station3 = new HelpDeskStation(3);
        OnlineMonitoringSystem monitor = new OnlineMonitoringSystem();

        System.out.println("PAG-IBIG CENTRALIZED QUEUING SYSTEM");

        
        boolean running = true;
        while (running) {
            System.out.println("\n MAIN MENU");
            System.out.println("1. Issue New Ticket (Customer)");
            System.out.println("2. Help Desk 1 - Call Next Customer");
            System.out.println("3. Help Desk 2 - Call Next Customer");
            System.out.println("4. Help Desk 3 - Call Next Customer");
            System.out.println("5. Reset Queue (Station Option)");
            System.out.println("6. View Online Monitor (Real-time Status)");
            System.out.println("7. Exit System");
            System.out.print("\nSelect option: ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        int ticket = dispenser.issueTicket();
                        dispenser.printTicket(ticket);
                        break;
                        
                    case 2:
                        station1.callNextCustomer();
                        break;
                        
                    case 3:
                        station2.callNextCustomer();
                        break;
                        
                    case 4:
                        station3.callNextCustomer();
                        break;
                        
                    case 5:
                        System.out.print("\nWhich station is performing the reset? (1/2/3): ");
                        int stationChoice = scanner.nextInt();
                        
                        if (stationChoice >= 1 && stationChoice <= 3) {
                            System.out.print("Enter new queue number to reset to: ");
                            int resetNumber = scanner.nextInt();
                            
                            if (stationChoice == 1) {
                                station1.resetQueue(resetNumber);
                            } else if (stationChoice == 2) {
                                station2.resetQueue(resetNumber);
                            } else {
                                station3.resetQueue(resetNumber);
                            }
                        } else {
                            System.out.println("\nInvalid station number!");
                        }
                        break;
                        
                    case 6:
                        monitor.displayQueueStatus();
                        break;
                        
                    case 0:
                        System.out.println("  Shutting down queuing system...");
                        System.out.println("  Thank you for using Pag-ibig Services!");
                        running = false;
                        break;
                        
                    default:
                        System.out.println("\nInvalid option! Please select 0-6.");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input! Please enter a number (0-6).");
                scanner.nextLine(); //buffer clear
            }
        }
        
        scanner.close();
    }
}

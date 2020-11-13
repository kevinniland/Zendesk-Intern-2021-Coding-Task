package zendesk.intern.cli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import zendesk.intern.data.Ticket;

/**
 * This is controller class for the display logic on console.
 */
public class DisplayTickets {
	private Menu menu = new Menu();
	private ArrayList<Ticket> ticketsList;
	private boolean flag = true;
	private int counter = 0, input = 1, pageLimit = 24;

	// Display all the tickets from the HashMap
	public void displayAllTickets(HashMap<Long, Ticket> ticketMap, Scanner scanner) {
		ticketsList = new ArrayList<>(ticketMap.values());
		
		if (ticketsList.size() < 24) {
			menu.displayTicketHeader();

			for (Ticket ticket : ticketsList) {
				menu.displayTicket(ticket);
			}
		} else {
			while (counter < ticketsList.size() && input == 1) {
				if (flag) {
					menu.displayTicketHeader();
					flag = false;
				}
				
				menu.displayTicket(ticketsList.get(counter));
				counter++;

				if (ticketsList.size() - counter == 0) {
					System.out.println("\nEnd of tickets for this account");
				}
				
				if (counter > pageLimit) {
					System.out.print("\nPress 1 to view next page, press 2 to exit: ");
					input = scanner.nextInt();
					pageLimit = pageLimit + 25;
					flag = true;
				}
			}
		}
	}

	// Display ticket with the user input field ID as a key.
	public void displayTicketById(HashMap<Long, Ticket> ticketMap, Long key) {
		if (ticketMap.containsKey(key)) {
			menu.displayTicketHeader();
			menu.displayTicket(ticketMap.get(key));
		} else {
			System.out.println("ERROR: Invalid Ticket ID - not found");
		}
	}
}

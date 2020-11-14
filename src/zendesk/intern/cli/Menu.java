package zendesk.intern.cli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONException;

import zendesk.intern.api.ZendeskAPI;
import zendesk.intern.data.TicketImpl;

/**
 * @author Kevin Niland
 * @category CLI
 * @version 1.0
 * 
 *          Menu.java - Provides a basic CLI
 */
public class Menu {
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<TicketImpl> ticketsList;
	private boolean flag = true;
	private int counter = 0, input = 1, pageLimit = 24;

	/**
	 * Simple menu - user can perform the following options: View all tickets
	 * currently associated with the logged in account, view a ticket by entering
	 * its ID, or exit the application
	 * 
	 * @throws JSONException
	 * @throws IOException 
	 */
	public void menu() throws JSONException, IOException {
		ZendeskAPI zendeskAPI = ZendeskAPI.getInstance();
		boolean keepAlive = true;
		Long id;

		System.out.println(
				"Zendesk Ticker Viewer - Zendesk Intern Program 2021\n===================================================");

		System.out.print("Enter your subdomain: ");
		zendeskAPI.setSubdomain(scanner.nextLine());

		System.out.print("Enter your email: ");
		zendeskAPI.setUsername(scanner.nextLine());

		System.out.print("Enter your password: ");
		zendeskAPI.setPassword(scanner.nextLine());

		System.out.println("\nLogging in...");

		if (!zendeskAPI.login()) {
			System.out.println("ERROR: User credentials not found. Please try again");
		} else {
			while (keepAlive) {
				System.out.println("\n1. View all tickets");
				System.out.println("2. Search ticket by ID");
				System.out.println("3. Delete ticket by ID");
				System.out.println("4. Exit application");

				switch (scanner.nextInt()) {
				case 1:
					displayAllTickets(zendeskAPI.getParser().getTicketsHashMap(), scanner);
					break;
				case 2:
					System.out.println("Enter ticket ID: ");
					id = scanner.nextLong();

					displayTicketById(zendeskAPI.getParser().getTicketsHashMap(), id);
					break;
//				case 3:
//					System.out.println("Enter ticket ID: ");
//					id = scanner.nextLong();
//					
//					apiRequester.deleteTicket(id);
//					break;
				case 4:
					System.out.println("\nExiting the application...");

					scanner.close();
					keepAlive = false;

					System.out.println("Exited");
					break;
				default:
					System.out.println("\nERROR: Invalid input, please try again");
					break;
				}
			}
		}
	}

	public void displayTicketHeader() {
		System.out.format("\n%-4s| %-50s | %-4s | %-12s | %-10s | %-10s | %-30s", "ID", "Subject", "Status", "Group ID",
				"Priority", "Type", "Tags");
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void displayTicket(TicketImpl ticket) {
		long id = ticket.getId();
		String subject = ticket.getSubject();
		String status = ticket.getStatus().toUpperCase();
		long groupId = ticket.getGroup_id();
		String priority = ticket.getPriority();
		String type = ticket.getType();
		ArrayList<String> tags = ticket.getTags();
		System.out.format("%-4d| %-50s |  %-5s | %d | %-10s | %-10s | %-50s\n", id, subject, status, groupId, priority,
				type, tags);
	}

	// Display ticket with the user input field ID as a key.
	public void displayTicketById(HashMap<Long, TicketImpl> ticketMap, Long key) {
		if (ticketMap.containsKey(key)) {
			displayTicketHeader();
			displayTicket(ticketMap.get(key));
		} else {
			System.out.println("ERROR: Invalid Ticket ID - not found");
		}
	}

	public void displayAllTickets(HashMap<Long, TicketImpl> ticketMap, Scanner scanner) {
		ticketsList = new ArrayList<>(ticketMap.values());

		if (ticketsList.size() < 24) {
			displayTicketHeader();

			for (TicketImpl ticket : ticketsList) {
				displayTicket(ticket);
			}
		} else {
			while (counter < ticketsList.size() && input == 1) {
				if (flag) {
					displayTicketHeader();
					flag = false;
				}

				displayTicket(ticketsList.get(counter));
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

	/**
	 * Deletes a ticket using it's ID
	 * 
	 * @param ticketMap - HashMap containing all tickets
	 * @param key - Ticket ID
	 */
//	public void deleteTicketByID(HashMap<Long, Ticket> ticketMap, Long key) {
//		if (ticketMap.containsKey(key)) {
//			ticketMap.remove(key);
//		}
//	}
}

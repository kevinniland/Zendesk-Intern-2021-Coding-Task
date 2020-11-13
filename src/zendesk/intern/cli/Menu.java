package zendesk.intern.cli;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;

import zendesk.intern.api.ApiRequester;
import zendesk.intern.data.Ticket;

/**
 * @author Kevin Niland
 * @category CLI
 * @version 1.0
 * 
 *          Menu.java - Provides a basic CLI
 */
public class Menu {
	public void menu() throws JSONException {
		ApiRequester apiRequester = new ApiRequester();
		DisplayTickets displayTickets = new DisplayTickets();
		Scanner scanner = new Scanner(System.in);
		boolean keepAlive = true;
		Long id;

		System.out.println(
				"Zendesk Ticker Viewer - Zendesk Intern Program 2021\n===================================================");

		System.out.print("Enter your subdomain: ");
		apiRequester.setSubdomain(scanner.nextLine());

		System.out.print("Enter your email: ");
		apiRequester.setUsername(scanner.nextLine());

		System.out.print("Enter your password: ");
		apiRequester.setPassword(scanner.nextLine());

		System.out.println("\nLogging in...");

		if (!apiRequester.login()) {
			System.out.println("ERROR: User credentials not found. Please try again");
		} else {
			System.out.println("SUCCESS: Successfully logged in");
			while (keepAlive) {
				System.out.println("\n1. View All Tickets");
				System.out.println("2. Search Ticket by ID");
				System.out.println("3. Exit application");

				switch (scanner.nextInt()) {
				case 1:
					displayTickets.displayAllTickets(apiRequester.getParser().getTicketsHashMap(), scanner);
					break;
				case 2:
					System.out.println("Enter Ticket ID: ");
					id = scanner.nextLong();

					displayTickets.displayTicketById(apiRequester.getParser().getTicketsHashMap(), id);
					break;
				case 3:
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
		System.out.format("\n%-4s| %-50s | %-4s | %-12s | %-10s | %-10s | %-30s", "ID", "SUBJECT", "STATUS", "GROUP ID",
				"PRIORITY", "TYPE", "TAGS");
		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------------------------------------");
	}

	public void displayTicket(Ticket ticket) {
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
}

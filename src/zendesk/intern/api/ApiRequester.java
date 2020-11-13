package zendesk.intern.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.json.JSONException;

import zendesk.intern.processing.Parser;

public class ApiRequester {
	private Parser ticketParser = new Parser();
	private HttpURLConnection httpURLConnection;
	private URL url;
	private String subdomain, username, password, credentials, encodedCredentials;

	public Parser getParser() {
		return ticketParser;
	}

	public String getSubdomain() {
		return subdomain;
	}

	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Login using the GET API request with Basic Authentication to Zendesk account
	 * and get all the Tickets in JSON Array String, pass it to TicketParser class to
	 * populate the Ticket(POJO) classes
	 */
	public boolean login() throws JSONException {
		try {
			url = new URL("https://" + subdomain + ".zendesk.com/api/v2/tickets.json");

			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Accept", "application/json");

			credentials = "" + username + ":" + password + "";
			encodedCredentials = new String(Base64.getEncoder().encodeToString(credentials.getBytes()));
			httpURLConnection.setRequestProperty("Authorization", "Basic " + encodedCredentials);

			if (httpURLConnection.getResponseCode() != 200) {
				System.out.println("ERROR: Unable to login. HTTP Error Code: " + httpURLConnection.getResponseCode());
				
				return false;
			} else {
				// Sending the received InputStream to TicketParser to parse and populate the
				// Ticket class.
				ticketParser.parse(httpURLConnection.getInputStream());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
		return true;
	}
}
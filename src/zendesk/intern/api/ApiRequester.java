package zendesk.intern.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.json.JSONException;

import zendesk.intern.processing.Parser;

/**
 * @author Kevin Niland
 * @category API
 * @version 1.0
 * 
 *          ApiRequester.java -
 */
public class ApiRequester {
	private Parser parser = new Parser();
	private HttpURLConnection httpURLConnection;
	private URL url;
	private String subdomain, username, password, credentials, encodedCredentials;

	/**
	 * Get Parser class object
	 * 
	 * @return parser
	 */
	public Parser getParser() {
		return parser;
	}

	/**
	 * Get user subdomain
	 * 
	 * @return subdomain
	 */
	public String getSubdomain() {
		return subdomain;
	}

	/**
	 * Set user subdomain
	 * 
	 * @param subdomain
	 */
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}

	/**
	 * Get username
	 * 
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set username
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get user password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set user password
	 * 
	 * @param password
	 *            - User password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Login using the GET API request with Basic Authentication to Zendesk account
	 * and get all the Tickets in JSON Array String, pass it to TicketParser class
	 * to populate the Ticket(POJO) classes
	 */

	/**
	 * Login to a Zendesk account
	 * 
	 * @return
	 * @throws JSONException
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
				parser.parse(httpURLConnection.getInputStream());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return true;
	}
}
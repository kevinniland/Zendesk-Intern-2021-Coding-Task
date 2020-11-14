package zendesk.intern.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import org.json.JSONException;

import zendesk.intern.enums.HttpStatusCodeRange;
import zendesk.intern.utils.HttpStatusCodeRangeUtil;
import zendesk.intern.utils.ParserImpl;

/**
 * @author Kevin Niland
 * @category API
 * @version 1.0
 * 
 *          ZendeskAPI.java -
 * 
 *          The singleton design pattern is used to implement this class
 */
public class ZendeskAPI {
	private static ZendeskAPI zendeskAPI;
	private HttpStatusCodeRange httpStatusCodeRange;
	private ParserImpl parser = new ParserImpl();
	private HttpURLConnection httpURLConnection;
	private URL url;
	private String subdomain, username, password, credentials, encodedCredentials;

	/**
	 * Login using the GET API request with Basic Authentication to Zendesk account
	 * and get all the Tickets in JSON Array String, pass it to TicketParser class
	 * to populate the Ticket(POJO) classes
	 */
	private ZendeskAPI() {

	}

	/**
	 * Double-checked locking principle. In this approach, the synchronized block is
	 * used inside the if condition with an additional check to ensure that only one
	 * instance of a singleton class is created
	 * 
	 * @return zendeskAPI
	 */
	public static ZendeskAPI getInstance() {
		if (zendeskAPI == null) {
			synchronized (ZendeskAPI.class) {
				if (zendeskAPI == null) {
					zendeskAPI = new ZendeskAPI();
				}
			}
		}

		return zendeskAPI;
	}

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

			/**
			 * Snippet of code that handles a range of HTTP status codes. Using an Enum
			 * HttpStatusCodeRange, I defined a range of possible codes: SUCCESS_RANGE,
			 * CLIENT_ERROR_RANGE,SERVER_ERROR_RANGE, and UNKNOWN. In the utility class
			 * HttpStatusCodeRangeUtil, I have a function called getRange that calculates
			 * the Enum for a particular code. Finally, the switch statement handles each of
			 * the HTTP response codes
			 */
			httpStatusCodeRange = HttpStatusCodeRangeUtil.getRange(httpURLConnection.getResponseCode());

			switch (httpStatusCodeRange) {
			case SUCCESS_RANGE:
				System.out.println(
						"SUCCESS: Successfully logged in. HTTP Error Code: " + httpURLConnection.getResponseCode());

				/**
				 * If user authorisation is successful, pass the received InputStream to the
				 * Parser class
				 */
				parser.parse(httpURLConnection.getInputStream());
				break;
			case CLIENT_ERROR_RANGE:
				// Inform user there is an error on their side
				System.out.println("ERROR: Unable to login. HTTP error code: " + httpURLConnection.getResponseCode());

				return false;
			case SERVER_ERROR_RANGE:
				// Inform user there is a server-side error, possibly attributed to the Zendesk API being unavailable
				System.out.println("ERROR: API unavailable. HTTP error code: " + httpURLConnection.getResponseCode());

				return false;
			case UNKNOWN:
				System.out.println(
						"ERROR: Unknow error occurred. HTTP error code: " + httpURLConnection.getResponseCode());
			default:
				break;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		return true;
	}

	/**
	 * Get Parser class object
	 * 
	 * @return parser
	 */
	public ParserImpl getParser() {
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
}
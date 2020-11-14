package zendesk.intern.tests;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;

import zendesk.intern.api.ZendeskAPI;

/**
 * @author Kevin Niland
 * @category Testing
 * @version 1.0
 *
 *          ZendeskAPITest -
 */
public class ZendeskAPITest {
	/**
	 * Tests a login attempt with valid user credentials
	 * 
	 * N.B: Password field will be empty on the GitHub version of this project
	 * 
	 * @throws JSONException
	 */
	@Test
	public void validLoginTest() throws JSONException {
		ZendeskAPI zendeskAPI = ZendeskAPI.getInstance();
//		ZendeskAPI zendeskAPI = new ZendeskAPI();

		zendeskAPI.setSubdomain("kevinniland");
		zendeskAPI.setUsername("kevinniland97@gmail.com");
		zendeskAPI.setPassword("JustaHollow97");

		assertEquals(true, zendeskAPI.login());
	}

	/**
	 * Tests a login attempt with invalid user credentials
	 * 
	 * N.B: Password field will be empty on the GitHub version of this project
	 * 
	 * @throws JSONException
	 */
	@Test
	public void invalidLoginTest() throws JSONException {
		ZendeskAPI zendeskAPI = ZendeskAPI.getInstance();
//		ZendeskAPI zendeskAPI = new ZendeskAPI();

		zendeskAPI.setSubdomain("subdomain");
		zendeskAPI.setUsername("email");
		zendeskAPI.setPassword("password");

		assertEquals(false, zendeskAPI.login());
	}
}

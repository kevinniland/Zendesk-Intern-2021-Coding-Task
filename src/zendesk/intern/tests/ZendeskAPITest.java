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
	@Test
	public void loginWithCorrectCredentialsTest() throws JSONException {
		ZendeskAPI zendeskAPI = ZendeskAPI.getInstance();

		zendeskAPI.setSubdomain("kevinniland");
		zendeskAPI.setUsername("kevinniland97@gmail.com");
		zendeskAPI.setPassword("JustaHollow97");

		assertEquals(true, zendeskAPI.login());
	}

	@Test
	public void loginWithWrongCredentialsTest() throws JSONException {
		ZendeskAPI zendeskAPI = ZendeskAPI.getInstance();

		zendeskAPI.setSubdomain("subdomain");
		zendeskAPI.setUsername("email");
		zendeskAPI.setPassword("password");

		assertEquals(false, zendeskAPI.login());
	}

	@Test
	public void loginTest() throws JSONException {
		ZendeskAPI zendeskAPI = ZendeskAPI.getInstance();

		zendeskAPI.setSubdomain("subdomain");
		zendeskAPI.setUsername("email");
		zendeskAPI.setPassword("password");

		assertEquals(false, zendeskAPI.login());
	}
}

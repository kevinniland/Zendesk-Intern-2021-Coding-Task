package zendesk.intern.tests;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.junit.Test;

import zendesk.intern.api.ApiRequester;

/**
 * Testing the login method to call the GET Tickets API
 */
public class ApiRequesterTest {
	@Test
	public void loginWithWrongCredentialsTest() throws JSONException {
		ApiRequester authentication = new ApiRequester();
		authentication.setSubdomain("subdomain");
		authentication.setUsername("email");
		authentication.setPassword("password");
		assertEquals(false, authentication.login());
	}

	@Test
	public void loginTest() throws JSONException {
		ApiRequester authentication = new ApiRequester();
		authentication.setSubdomain("subdomain");
		authentication.setUsername("email");
		authentication.setPassword("password");
		assertEquals(false, authentication.login());
	}
}

package zendesk.intern;

import java.io.IOException;

import org.json.JSONException;

import zendesk.intern.cli.Menu;

/**
 * @author Kevin Niland
 * @category Runner
 * @version 1.0
 * 
 *          Runner.java - Entry point into the application
 */
public class Runner {
	public static void main(String[] args) throws JSONException, IOException {
		new Menu().menu();
	}
}

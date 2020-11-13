package zendesk.intern;

import org.json.JSONException;

import zendesk.intern.cli.Menu;

public class Runner {
	public static void main(String[] args) throws JSONException {
		new Menu().menu();
	}
}

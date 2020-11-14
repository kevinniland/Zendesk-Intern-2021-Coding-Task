package zendesk.intern.interfaces;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import zendesk.intern.data.TicketImpl;

/**
 * @author Kevin Niland
 * @category Interface
 * @version 1.0
 * 
 *          Parser.java - Interface for ParserImpl
 */
public interface Parser {
	public abstract void parse(InputStream inputStream) throws JSONException;

	public abstract void saveTicketsJsonString() throws JSONException;

	public abstract TicketImpl convertToTicketObject(JSONObject ticketJson) throws JSONException;

	public abstract ArrayList<Integer> getArrayListInt(JSONObject ticketJson, String key) throws JSONException;

	public abstract ArrayList<String> getArrayListString(JSONObject ticketJson, String key) throws JSONException;

	public abstract HashMap<Long, TicketImpl> getTicketsHashMap();

	public abstract void setTicketsHashMap(HashMap<Long, TicketImpl> ticketsHashMap);
}

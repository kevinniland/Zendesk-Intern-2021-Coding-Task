package zendesk.intern.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import zendesk.intern.data.SourceImpl;
import zendesk.intern.data.TicketImpl;
import zendesk.intern.data.ViaImpl;
import zendesk.intern.interfaces.Parser;

/**
 * @author Kevin Niland
 * @category Utilities
 * @version 1.0
 * 
 * Parser.java - Parses data from the Zendesk API
 */
public class ParserImpl implements Parser {
	private TicketImpl ticket, ticketObj;
	private HashMap<Long, TicketImpl> ticketsHashMap = new HashMap<>();
	private JSONArray arrayOfTickets;
	private JSONObject mainObject, ticketJson;
	private BufferedReader bufferedReader;
	private StringBuilder stringBuilder = new StringBuilder();
	private String line;
	private int i;
	private long id;

	/**
	 * Takes the argument as InputStream from the GET API call to parse the String
	 * into Ticket Object
	 */
	@Override
	public void parse(InputStream inputStream) throws JSONException {
		bufferedReader = new BufferedReader(new InputStreamReader((inputStream)));

		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}

			bufferedReader.close();
			this.saveTicketsJsonString();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saving the Array of Ticket JSON Objects as HashMap of Tickets object
	 */
	@Override
	public void saveTicketsJsonString() throws JSONException {
		mainObject = new JSONObject(stringBuilder.toString());
		arrayOfTickets = mainObject.getJSONArray("tickets");

		for (i = 0; i < arrayOfTickets.length(); i++) {
			ticketJson = arrayOfTickets.getJSONObject(i);
			id = ticketJson.optLong("id");
			ticket = this.convertToTicketObject(ticketJson);
			
			getTicketsHashMap().put(id, ticket);
		}
	}

	/**
	 * Populates the Ticket Object with JSON data
	 */
	@Override
	public TicketImpl convertToTicketObject(JSONObject ticketJson) throws JSONException {
		ticketObj = new TicketImpl();

		ticketObj.setUrl(ticketJson.optString("url"));
		ticketObj.setId(ticketJson.optLong("id"));
		ticketObj.setExternal_id(ticketJson.optString("external_id"));

		ViaImpl via = new ViaImpl();
		JSONObject viaJsonObject = ticketJson.getJSONObject("via");
		via.setChannel(viaJsonObject.optString("channel"));

		SourceImpl source = new SourceImpl();
		JSONObject sourceObject = viaJsonObject.getJSONObject("source");
		source.setRel(sourceObject.optString("rel"));
		via.setSource(source);

		ticketObj.setVia(via);
		ticketObj.setCreated_at(ticketJson.optString("created_at"));
		ticketObj.setUpdated_at(ticketJson.optString("updated_at"));
		ticketObj.setType(ticketJson.optString("type"));
		ticketObj.setSubject(ticketJson.optString("subject"));
		ticketObj.setRaw_subject(ticketJson.optString("raw_subject"));
		ticketObj.setDescription(ticketJson.optString("description"));
		ticketObj.setPriority(ticketJson.optString("priority"));
		ticketObj.setStatus(ticketJson.optString("status"));
		ticketObj.setRecipient(ticketJson.optString("recipient"));
		ticketObj.setRequester_id(ticketJson.getLong("requester_id"));
		ticketObj.setSubmitter_id(ticketJson.optLong("submitter_id"));
		ticketObj.setAssignee_id(ticketJson.optLong("assignee_id"));
		ticketObj.setOrganization_id(ticketJson.optLong("organization_id"));
		ticketObj.setGroup_id(ticketJson.optLong("group_id"));
		ticketObj.setCollaborator_id(getArrayListInt(ticketJson, "collaborator_ids"));
		ticketObj.setFollower_ids(getArrayListInt(ticketJson, "follower_ids"));
		ticketObj.setForum_topic_id(ticketJson.optLong("forum_topic_id"));
		ticketObj.setProblem_id(ticketJson.optLong("problem_id"));
		ticketObj.setHas_incidents(ticketJson.optBoolean("has_incidents"));
		ticketObj.setIs_public(ticketJson.optBoolean("is_public"));
		ticketObj.setDue_at(ticketJson.optString("due_at"));
		ticketObj.setTags(getArrayListString(ticketJson, "tags"));
		ticketObj.setCustom_fields(getArrayListString(ticketJson, "custom_fields"));
		ticketObj.setSatisfaction_rating(ticketJson.optString("satisfaction_rating"));
		ticketObj.setSharing_agreement_ids(getArrayListInt(ticketJson, "sharing_agreement_ids"));
		ticketObj.setFields(getArrayListString(ticketJson, "fields"));
		ticketObj.setFollowup_ids(getArrayListInt(ticketJson, "followup_ids"));
		ticketObj.setBrand_id(ticketJson.optLong("brand_id"));
		ticketObj.setAllow_channelback(ticketJson.optBoolean("allow_channelback"));

		return ticketObj;
	}

	/**
	 * Method to parse JSON object as ArrayList of integers
	 */
	@Override
	public ArrayList<Integer> getArrayListInt(JSONObject ticketJson, String key) throws JSONException {
		JSONArray arrayValues = ticketJson.getJSONArray(key);
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arrayValues.length(); i++) {
			list.add(Integer.parseInt(arrayValues.get(i).toString()));
		}

		return list;
	}

	/**
	 * Method to parse JSON object as ArrayList of Strings
	 */
	@Override
	public ArrayList<String> getArrayListString(JSONObject ticketJson, String key) throws JSONException {
		JSONArray arrayValues = ticketJson.getJSONArray(key);
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < arrayValues.length(); i++) {
			list.add(arrayValues.get(i).toString());
		}

		return list;
	}

	/**
	 * @return the ticketsHashMap
	 */
	@Override
	public HashMap<Long, TicketImpl> getTicketsHashMap() {
		return ticketsHashMap;
	}

	/**
	 * @param ticketsHashMap
	 *            the ticketsHashMap to set
	 */
	@Override
	public void setTicketsHashMap(HashMap<Long, TicketImpl> ticketsHashMap) {
		this.ticketsHashMap = ticketsHashMap;
	}
}
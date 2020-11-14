package zendesk.intern.data;

import java.util.ArrayList;

import zendesk.intern.interfaces.Ticket;

/**
 * @author Kevin Niland
 * @category Data
 * @version 1.0
 * 
 *           Ticket.java - Getter and setter class for attributes associated
 *           with a ticket such as tags, created_at, id, assignee_id, etc.
 *           
 *           https://developer.zendesk.com/rest_api/docs/support/tickets
 */
public class TicketImpl implements Ticket {
	private ViaImpl via;
	private ArrayList<String> tags, fields, custom_fields;
	private ArrayList<Integer> collaborator_id, follower_ids;
	private ArrayList<Integer> sharing_agreement_ids, followup_ids;
	private String url, external_id, created_at, updated_at, type, subject;
	private String raw_subject, description, priority, status, recipient;
	private String due_at, satisfaction_rating;
	private boolean has_incidents, is_public, allow_channelback;
	private long id, requester_id, submitter_id, assignee_id, organization_id, brand_id;
	private long group_id, forum_topic_id, problem_id;

	/**
	 * Get URL
	 * 
	 * @return url
	 */
	@Override
	public String getUrl() {
		return url;
	}

	/**
	 * Set URL
	 * 
	 * @param url
	 */
	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get ticket ID
	 * 
	 * @return id
	 */
	@Override
	public long getId() {
		return id;
	}

	/**
	 * Set ticket ID
	 * 
	 * @param id
	 */
	@Override
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getExternal_id() {
		return external_id;
	}

	/**
	 * 
	 * @param external_id
	 */
	@Override
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ViaImpl getVia() {
		return via;
	}

	/**
	 * 
	 * @param via
	 */
	@Override
	public void setVia(ViaImpl via) {
		this.via = via;
	}

	/**
	 * Get date and time ticket was created at
	 * 
	 * @return created_at
	 */
	@Override
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * Set the date and time ticket was created at
	 * 
	 * @param created_at
	 */
	@Override
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * Get date and time ticket was updated at
	 * 
	 * @return updated_at
	 */
	@Override
	public String getUpdated_at() {
		return updated_at;
	}

	/**
	 * Set the date and time ticket was updated at
	 * 
	 * @param updated_at
	 */
	@Override
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * Get type of ticket
	 * 
	 * @return type
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * Set type of ticket
	 * 
	 * @param type
	 */
	@Override
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get ticket subject
	 * 
	 * @return subject
	 */
	@Override
	public String getSubject() {
		return subject;
	}

	/**
	 * Set ticket subject
	 * 
	 * @param subject
	 */
	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getRaw_subject() {
		return raw_subject;
	}

	/**
	 * 
	 * @param raw_subject
	 */
	@Override
	public void setRaw_subject(String raw_subject) {
		this.raw_subject = raw_subject;
	}

	/**
	 * Get ticket description
	 * 
	 * @return description
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * Set ticket description
	 * 
	 * @param description
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get ticket priority
	 * 
	 * @return priority
	 */
	@Override
	public String getPriority() {
		return priority;
	}

	/**
	 * Set ticket priority
	 * 
	 * @param priority
	 */
	@Override
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Get ticket status
	 * 
	 * @return status
	 */
	@Override
	public String getStatus() {
		return status;
	}

	/**
	 * Set ticket status
	 * 
	 * @param status
	 */
	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getRecipient() {
		return recipient;
	}

	/**
	 * 
	 * @param recipient
	 */
	@Override
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getRequester_id() {
		return requester_id;
	}

	/**
	 * 
	 * @param requester_id
	 */
	@Override
	public void setRequester_id(long requester_id) {
		this.requester_id = requester_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getSubmitter_id() {
		return submitter_id;
	}

	/**
	 * 
	 * @param submitter_id
	 */
	@Override
	public void setSubmitter_id(long submitter_id) {
		this.submitter_id = submitter_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getAssignee_id() {
		return assignee_id;
	}

	/**
	 * 
	 * @param assignee_id
	 */
	@Override
	public void setAssignee_id(long assignee_id) {
		this.assignee_id = assignee_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getOrganization_id() {
		return organization_id;
	}

	/**
	 * 
	 * @param organization_id
	 */
	@Override
	public void setOrganization_id(long organization_id) {
		this.organization_id = organization_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getGroup_id() {
		return group_id;
	}

	/**
	 * 
	 * @param group_id
	 */
	@Override
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Integer> getCollaborator_id() {
		return collaborator_id;
	}

	/**
	 * 
	 * @param collaborator_id
	 */
	@Override
	public void setCollaborator_id(ArrayList<Integer> collaborator_id) {
		this.collaborator_id = collaborator_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Integer> getFollower_ids() {
		return follower_ids;
	}

	/**
	 * 
	 * @param follower_ids
	 */
	@Override
	public void setFollower_ids(ArrayList<Integer> follower_ids) {
		this.follower_ids = follower_ids;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getForum_topic_id() {
		return forum_topic_id;
	}

	/**
	 * 
	 * @param forum_topic_id
	 */
	@Override
	public void setForum_topic_id(long forum_topic_id) {
		this.forum_topic_id = forum_topic_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getProblem_id() {
		return problem_id;
	}

	/**
	 * 
	 * @param problem_id
	 */
	@Override
	public void setProblem_id(long problem_id) {
		this.problem_id = problem_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public boolean isHas_incidents() {
		return has_incidents;
	}

	/**
	 * 
	 * @param has_incidents
	 */
	@Override
	public void setHas_incidents(boolean has_incidents) {
		this.has_incidents = has_incidents;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public boolean isIs_public() {
		return is_public;
	}

	/**
	 * 
	 * @param is_public
	 */
	@Override
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getDue_at() {
		return due_at;
	}

	/**
	 *
	 * @param due_at
	 */
	@Override
	public void setDue_at(String due_at) {
		this.due_at = due_at;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<String> getTags() {
		return tags;
	}

	/**
	 * 
	 * @param tags
	 */
	@Override
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<String> getCustom_fields() {
		return custom_fields;
	}

	/**
	 *
	 * @param custom_fields
	 */
	@Override
	public void setCustom_fields(ArrayList<String> custom_fields) {
		this.custom_fields = custom_fields;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public String getSatisfaction_rating() {
		return satisfaction_rating;
	}

	/**
	 * 
	 * @param satisfaction_rating
	 */
	@Override
	public void setSatisfaction_rating(String satisfaction_rating) {
		this.satisfaction_rating = satisfaction_rating;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Integer> getSharing_agreement_ids() {
		return sharing_agreement_ids;
	}

	/**
	 * 
	 * @param sharing_agreement_ids
	 */
	@Override
	public void setSharing_agreement_ids(ArrayList<Integer> sharing_agreement_ids) {
		this.sharing_agreement_ids = sharing_agreement_ids;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<String> getFields() {
		return fields;
	}

	/**
	 * 
	 * @param arrayList
	 */
	@Override
	public void setFields(ArrayList<String> arrayList) {
		this.fields = arrayList;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public ArrayList<Integer> getFollowup_ids() {
		return followup_ids;
	}

	/**
	 * 
	 * @param followup_ids
	 */
	@Override
	public void setFollowup_ids(ArrayList<Integer> followup_ids) {
		this.followup_ids = followup_ids;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public long getBrand_id() {
		return brand_id;
	}

	/**
	 * 
	 * @param brand_id
	 */
	@Override
	public void setBrand_id(long brand_id) {
		this.brand_id = brand_id;
	}

	/**
	 * 
	 * @return
	 */
	@Override
	public boolean isAllow_channelback() {
		return allow_channelback;
	}

	/**
	 * 
	 * @param allow_channelback
	 */
	@Override
	public void setAllow_channelback(boolean allow_channelback) {
		this.allow_channelback = allow_channelback;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Ticket [url=" + url + ", id=" + id + ", external_id=" + external_id + ", via=" + via + ", created_at="
				+ created_at + ", updated_at=" + updated_at + ", type=" + type + ", subject=" + subject
				+ ", raw_subject=" + raw_subject + ", description=" + description + ", priority=" + priority
				+ ", status=" + status + ", recipient=" + recipient + ", requester_id=" + requester_id
				+ ", submitter_id=" + submitter_id + ", assignee_id=" + assignee_id + ", organization_id="
				+ organization_id + ", group_id=" + group_id + ", collaborator_id=" + collaborator_id
				+ ", follower_ids=" + follower_ids + ", forum_topic_id=" + forum_topic_id + ", problem_id=" + problem_id
				+ ", has_incidents=" + has_incidents + ", is_public=" + is_public + ", due_at=" + due_at + ", tags="
				+ tags + ", custom_fields=" + custom_fields + ", satisfaction_rating=" + satisfaction_rating
				+ ", sharing_agreement_ids=" + sharing_agreement_ids + ", fields=" + fields + ", followup_ids="
				+ followup_ids + ", brand_id=" + brand_id + ", allow_channelback=" + allow_channelback + "]";
	}
}
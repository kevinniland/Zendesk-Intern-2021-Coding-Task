package zendesk.intern.data;

import java.util.ArrayList;

/**
 * @author Kevin Niland
 * @category Data
 * @version 1.0
 * 
 *           Ticket.java - Getter and setter class for attributes associated
 *           with a ticket such as tags, created_at, id, assignee_id, etc.
 */
public class Ticket {
	private Via via;
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
	public String getUrl() {
		return url;
	}

	/**
	 * Set URL
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get ticket ID
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set ticket ID
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getExternal_id() {
		return external_id;
	}

	/**
	 * 
	 * @param external_id
	 */
	public void setExternal_id(String external_id) {
		this.external_id = external_id;
	}

	/**
	 * 
	 * @return
	 */
	public Via getVia() {
		return via;
	}

	/**
	 * 
	 * @param via
	 */
	public void setVia(Via via) {
		this.via = via;
	}

	/**
	 * Get date and time ticket was created at
	 * 
	 * @return created_at
	 */
	public String getCreated_at() {
		return created_at;
	}

	/**
	 * Set the date and time ticket was created at
	 * 
	 * @param created_at
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	/**
	 * Get date and time ticket was updated at
	 * 
	 * @return updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}

	/**
	 * Set the date and time ticket was updated at
	 * 
	 * @param updated_at
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	/**
	 * Get type of ticket
	 * 
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set type of ticket
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get ticket subject
	 * 
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Set ticket subject
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 
	 * @return
	 */
	public String getRaw_subject() {
		return raw_subject;
	}

	/**
	 * 
	 * @param raw_subject
	 */
	public void setRaw_subject(String raw_subject) {
		this.raw_subject = raw_subject;
	}

	/**
	 * Get ticket description
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set ticket description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get ticket priority
	 * 
	 * @return priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Set ticket priority
	 * 
	 * @param priority
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Get ticket status
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set ticket status
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * 
	 * @param recipient
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	/**
	 * 
	 * @return
	 */
	public long getRequester_id() {
		return requester_id;
	}

	/**
	 * 
	 * @param requester_id
	 */
	public void setRequester_id(long requester_id) {
		this.requester_id = requester_id;
	}

	/**
	 * 
	 * @return
	 */
	public long getSubmitter_id() {
		return submitter_id;
	}

	/**
	 * 
	 * @param submitter_id
	 */
	public void setSubmitter_id(long submitter_id) {
		this.submitter_id = submitter_id;
	}

	/**
	 * 
	 * @return
	 */
	public long getAssignee_id() {
		return assignee_id;
	}

	/**
	 * 
	 * @param assignee_id
	 */
	public void setAssignee_id(long assignee_id) {
		this.assignee_id = assignee_id;
	}

	/**
	 * 
	 * @return
	 */
	public long getOrganization_id() {
		return organization_id;
	}

	/**
	 * 
	 * @param organization_id
	 */
	public void setOrganization_id(long organization_id) {
		this.organization_id = organization_id;
	}

	/**
	 * 
	 * @return
	 */
	public long getGroup_id() {
		return group_id;
	}

	/**
	 * 
	 * @param group_id
	 */
	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getCollaborator_id() {
		return collaborator_id;
	}

	/**
	 * 
	 * @param collaborator_id
	 */
	public void setCollaborator_id(ArrayList<Integer> collaborator_id) {
		this.collaborator_id = collaborator_id;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getFollower_ids() {
		return follower_ids;
	}

	/**
	 * 
	 * @param follower_ids
	 */
	public void setFollower_ids(ArrayList<Integer> follower_ids) {
		this.follower_ids = follower_ids;
	}

	/**
	 * 
	 * @return
	 */
	public long getForum_topic_id() {
		return forum_topic_id;
	}

	/**
	 * 
	 * @param forum_topic_id
	 */
	public void setForum_topic_id(long forum_topic_id) {
		this.forum_topic_id = forum_topic_id;
	}

	/**
	 * 
	 * @return
	 */
	public long getProblem_id() {
		return problem_id;
	}

	/**
	 * 
	 * @param problem_id
	 */
	public void setProblem_id(long problem_id) {
		this.problem_id = problem_id;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isHas_incidents() {
		return has_incidents;
	}

	/**
	 * 
	 * @param has_incidents
	 */
	public void setHas_incidents(boolean has_incidents) {
		this.has_incidents = has_incidents;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isIs_public() {
		return is_public;
	}

	/**
	 * 
	 * @param is_public
	 */
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}

	/**
	 * 
	 * @return
	 */
	public String getDue_at() {
		return due_at;
	}

	/**
	 *
	 * @param due_at
	 */
	public void setDue_at(String due_at) {
		this.due_at = due_at;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getTags() {
		return tags;
	}

	/**
	 * 
	 * @param tags
	 */
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getCustom_fields() {
		return custom_fields;
	}

	/**
	 *
	 * @param custom_fields
	 */
	public void setCustom_fields(ArrayList<String> custom_fields) {
		this.custom_fields = custom_fields;
	}

	/**
	 * 
	 * @return
	 */
	public String getSatisfaction_rating() {
		return satisfaction_rating;
	}

	/**
	 * 
	 * @param satisfaction_rating
	 */
	public void setSatisfaction_rating(String satisfaction_rating) {
		this.satisfaction_rating = satisfaction_rating;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getSharing_agreement_ids() {
		return sharing_agreement_ids;
	}

	/**
	 * 
	 * @param sharing_agreement_ids
	 */
	public void setSharing_agreement_ids(ArrayList<Integer> sharing_agreement_ids) {
		this.sharing_agreement_ids = sharing_agreement_ids;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getFields() {
		return fields;
	}

	/**
	 * 
	 * @param arrayList
	 */
	public void setFields(ArrayList<String> arrayList) {
		this.fields = arrayList;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<Integer> getFollowup_ids() {
		return followup_ids;
	}

	/**
	 * 
	 * @param followup_ids
	 */
	public void setFollowup_ids(ArrayList<Integer> followup_ids) {
		this.followup_ids = followup_ids;
	}

	/**
	 * 
	 * @return
	 */
	public long getBrand_id() {
		return brand_id;
	}

	/**
	 * 
	 * @param brand_id
	 */
	public void setBrand_id(long brand_id) {
		this.brand_id = brand_id;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAllow_channelback() {
		return allow_channelback;
	}

	/**
	 * 
	 * @param allow_channelback
	 */
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
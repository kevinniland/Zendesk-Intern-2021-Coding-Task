package zendesk.intern.interfaces;

import java.util.ArrayList;

import zendesk.intern.data.ViaImpl;

/**
 * @author Kevin Niland
 * @category Interface
 * @version 1.0
 *
 *          Ticket.java - Interface for TicketImpl
 */
public interface Ticket {
	public abstract String getUrl();

	public abstract void setUrl(String url);

	public abstract long getId();

	public abstract void setId(long id);

	public abstract String getExternal_id();

	public abstract void setExternal_id(String external_id);

	public abstract ViaImpl getVia();

	public abstract void setVia(ViaImpl via);

	public abstract String getCreated_at();

	public abstract void setCreated_at(String created_at);

	public abstract String getUpdated_at();

	public abstract void setUpdated_at(String updated_at);

	public abstract String getType();

	public abstract void setType(String type);

	public abstract String getSubject();

	public abstract void setSubject(String subject);

	public abstract String getRaw_subject();

	public abstract void setRaw_subject(String raw_subject);

	public abstract String getDescription();

	public abstract void setDescription(String description);

	public abstract String getPriority();

	public abstract void setPriority(String priority);

	public abstract String getStatus();

	public abstract void setStatus(String status);

	public abstract String getRecipient();

	public abstract void setRecipient(String recipient);

	public abstract long getRequester_id();

	public abstract void setRequester_id(long requester_id);

	public abstract long getSubmitter_id();

	public abstract void setSubmitter_id(long submitter_id);

	public abstract long getAssignee_id();

	public abstract void setAssignee_id(long assignee_id);

	public abstract long getOrganization_id();

	public abstract void setOrganization_id(long organization_id);

	public abstract long getGroup_id();

	public abstract void setGroup_id(long group_id);

	public abstract ArrayList<Integer> getCollaborator_id();

	public abstract void setCollaborator_id(ArrayList<Integer> collaborator_id);

	public abstract void setFollower_ids(ArrayList<Integer> follower_ids);

	public abstract long getForum_topic_id();

	public abstract void setForum_topic_id(long forum_topic_id);

	public abstract ArrayList<Integer> getFollower_ids();

	public abstract long getProblem_id();

	public abstract void setProblem_id(long problem_id);

	public abstract boolean isHas_incidents();

	public abstract void setHas_incidents(boolean has_incidents);

	public abstract boolean isIs_public();

	public abstract void setIs_public(boolean is_public);

	public abstract String getDue_at();

	public abstract void setDue_at(String due_at);

	public abstract ArrayList<String> getTags();

	public abstract void setTags(ArrayList<String> tags);

	public abstract ArrayList<String> getCustom_fields();

	public abstract void setCustom_fields(ArrayList<String> custom_fields);

	public abstract String getSatisfaction_rating();

	public abstract void setSatisfaction_rating(String satisfaction_rating);

	public abstract ArrayList<Integer> getSharing_agreement_ids();

	public abstract void setSharing_agreement_ids(ArrayList<Integer> sharing_agreement_ids);

	public abstract ArrayList<String> getFields();

	public abstract void setFields(ArrayList<String> arrayList);

	public abstract ArrayList<Integer> getFollowup_ids();

	public abstract void setFollowup_ids(ArrayList<Integer> followup_ids);

	public abstract long getBrand_id();

	public abstract void setBrand_id(long brand_id);

	public abstract boolean isAllow_channelback();

	public abstract void setAllow_channelback(boolean allow_channelback);
}

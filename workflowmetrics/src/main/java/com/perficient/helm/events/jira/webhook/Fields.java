package com.perficient.helm.events.jira.webhook;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perficient.helm.events.jira.common.Comments;
import com.perficient.helm.events.jira.common.Component;
import com.perficient.helm.events.jira.common.CustomField;
import com.perficient.helm.events.jira.common.FixVersion;
import com.perficient.helm.events.jira.common.IssueLink;
import com.perficient.helm.events.jira.common.Issuetype;
import com.perficient.helm.events.jira.common.Priority;
import com.perficient.helm.events.jira.common.Project;
import com.perficient.helm.events.jira.common.Resolution;
import com.perficient.helm.events.jira.common.StatusDetails;
import com.perficient.helm.events.jira.common.User;
import com.perficient.helm.events.jira.common.Watches;
import com.perficient.helm.events.jira.common.WorkLog;

public class Fields {
	private Issuetype issueType;
	private ArrayList<Component> components;
	private String timespent;
	private String timeoriginalestimate;
	private String description;
	private Project project;
	private ArrayList<FixVersion> fixVersions;
	private String aggregatetimespent;
	private Resolution resolution;
	private Object timetracking;
	private ArrayList<Object> attachment;
	private String aggregatetimeestimate;
	private String resolutiondate;
	private Float workratio;
	private String summary;
	private String lastViewed;
	private Watches watches;
	private User creator;
	private ArrayList<Object> subtasks;
	private JsonNode aggregateprogress;
	private String created;
	private User reporter;
	private Priority priority;
	private ArrayList<String> labels;
	private String environment;
	private String timeestimate;
	private String aggregateoriginaltimeestimate;
	private ArrayList<String> versions;
	private String duedate;
	private Progress progress;
	private Comments comment;
	private ArrayList<IssueLink> issuelinks;
	private JsonNode votes;
	private User assignee;
	private String updated;
	private StatusDetails status;
	private String aggregatetimeoriginalestimate;
	private WorkLog worklog;

	private Map<String, CustomField> customFields = new LinkedHashMap<>();

	/*
	 * public void setCustomFieldArr(ArrayList<CustomField> customFieldArr) {
	 * this.customFieldArr = customFieldArr; }
	 */
	public String getAggregatetimeoriginalestimate() {
		return aggregatetimeoriginalestimate;
	}

	public void setAggregatetimeoriginalestimate(String aggregatetimeoriginalestimate) {
		this.aggregatetimeoriginalestimate = aggregatetimeoriginalestimate;
	}

	public WorkLog getWorklog() {
		return worklog;
	}

	public void setWorklog(WorkLog worklog) {
		this.worklog = worklog;
	}

	public Issuetype getIssuetype() {
		return issueType;
	}

	public Fields setIssuetype(Issuetype issueType) {
		System.out.println("Setting issuetype");
		this.issueType = issueType;

		return this;
	}

	public ArrayList<Component> getComponents() {
		return components;
	}

	public Fields setComponents(ArrayList<Component> components) {
		this.components = components;

		return this;
	}

	public String getTimespent() {
		return timespent;
	}

	public Fields setTimespent(String timespent) {
		this.timespent = timespent;

		return this;
	}

	public String getTimeoriginalestimate() {
		return timeoriginalestimate;
	}

	public Fields setTimeoriginalestimate(String timeoriginalestimate) {
		this.timeoriginalestimate = timeoriginalestimate;

		return this;
	}

	public String getDescription() {
		return description;
	}

	public Fields setDescription(String description) {
		this.description = description;

		return this;
	}

	public Project getProject() {
		return project;
	}

	public Fields setProject(Project project) {
		this.project = project;

		return this;
	}

	public ArrayList<FixVersion> getFixVersions() {
		return fixVersions;
	}

	public Fields setFixVersions(ArrayList<FixVersion> fixVersions) {
		this.fixVersions = fixVersions;

		return this;
	}

	public String getAggregatetimespent() {
		return aggregatetimespent;
	}

	public Fields setAggregatetimespent(String aggregatetimespent) {
		this.aggregatetimespent = aggregatetimespent;

		return this;
	}

	public Resolution getResolution() {
		return resolution;
	}

	public Fields setResolution(Resolution resolution) {
		this.resolution = resolution;

		return this;
	}

	public Object getTimetracking() {
		return timetracking;
	}

	public Fields setTimetracking(Object timetracking) {
		this.timetracking = timetracking;

		return this;
	}

	public Float getWorkratio() {
		return workratio;
	}

	public Fields setWorkratio(Float workratio) {
		this.workratio = workratio;

		return this;
	}

	public String getSummary() {
		return summary;
	}

	public Fields setSummary(String summary) {
		this.summary = summary;

		return this;
	}

	public String getLastViewed() {
		return lastViewed;
	}

	public Fields setLastViewed(String lastViewed) {
		this.lastViewed = lastViewed;

		return this;
	}

	public Watches getWatches() {
		return watches;
	}

	public Fields setWatches(Watches watches) {
		this.watches = watches;

		return this;
	}

	public User getCreator() {
		return creator;
	}

	public Fields setCreator(User creator) {
		this.creator = creator;

		return this;
	}

	public String getCreated() {
		return created;
	}

	public Fields setCreated(String created) {
		this.created = created;

		return this;
	}

	public User getReporter() {
		return reporter;
	}

	public Fields setReporter(User reporter) {
		this.reporter = reporter;

		return this;
	}

	public Priority getPriority() {
		return priority;
	}

	public Fields setPriority(Priority priority) {
		this.priority = priority;

		return this;
	}

	public ArrayList<String> getLabels() {
		return labels;
	}

	public Fields setLabels(ArrayList<String> labels) {
		this.labels = labels;

		return this;
	}

	public String getEnvironment() {
		return environment;
	}

	public Fields setEnvironment(String environment) {
		this.environment = environment;

		return this;
	}

	public String getTimeestimate() {
		return timeestimate;
	}

	public Fields setTimeestimate(String timeestimate) {
		this.timeestimate = timeestimate;

		return this;
	}

	public String getAggregateoriginaltimeestimate() {
		return aggregateoriginaltimeestimate;
	}

	public Fields setAggregateoriginaltimeestimate(String aggregateoriginaltimeestimate) {
		this.aggregateoriginaltimeestimate = aggregateoriginaltimeestimate;

		return this;
	}

	public String getDuedate() {
		return duedate;
	}

	public Fields setDuedate(String duedate) {
		this.duedate = duedate;

		return this;
	}

	public Progress getProgress() {
		return progress;
	}

	public Fields setProgress(Progress progress) {
		this.progress = progress;

		return this;
	}

	public Comments getComment() {
		return comment;
	}

	public Fields setComment(Comments comment) {
		this.comment = comment;

		return this;
	}

	public ArrayList<IssueLink> getIssuelinks() {
		return issuelinks;
	}

	public Fields setIssuelinks(ArrayList<IssueLink> issuelinks) {
		this.issuelinks = issuelinks;

		return this;
	}

	public User getAssignee() {
		return assignee;
	}

	public Fields setAssignee(User assignee) {
		this.assignee = assignee;

		return this;
	}

	public String getUpdated() {
		return updated;
	}

	public Fields setUpdated(String updated) {
		this.updated = updated;

		return this;
	}

	public StatusDetails getStatus() {
		return status;
	}

	public Fields setStatus(StatusDetails status) {
		this.status = status;

		return this;
	}

	public Issuetype getIssueType() {
		return issueType;
	}

	public void setIssueType(Issuetype issueType) {
		this.issueType = issueType;
	}

	public ArrayList<Object> getAttachment() {
		return attachment;
	}

	public void setAttachment(ArrayList<Object> attachment) {
		this.attachment = attachment;
	}

	public String getAggregatetimeestimate() {
		return aggregatetimeestimate;
	}

	public void setAggregatetimeestimate(String aggregatetimeestimate) {
		this.aggregatetimeestimate = aggregatetimeestimate;
	}

	public String getResolutiondate() {
		return resolutiondate;
	}

	public void setResolutiondate(String resolutiondate) {
		this.resolutiondate = resolutiondate;
	}

	public ArrayList<Object> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(ArrayList<Object> subtasks) {
		this.subtasks = subtasks;
	}

	public JsonNode getAggregateprogress() {
		return aggregateprogress;
	}

	public void setAggregateprogress(JsonNode aggregateprogress) {
		this.aggregateprogress = aggregateprogress;
	}

	public ArrayList<String> getVersions() {
		return versions;
	}

	public void setVersions(ArrayList<String> versions) {
		this.versions = versions;
	}

	public JsonNode getVotes() {
		return votes;
	}

	public void setVotes(JsonNode votes) {
		this.votes = votes;
	}

	@SuppressWarnings("unchecked")
	@JsonAnySetter
	public Fields setCustomFields(String key, Object value) {
		if (value == null) {
			CustomField cstmFld = new CustomField();
			cstmFld.setId(null);
			cstmFld.setSelf(null);
			cstmFld.setValue(null);
			customFields.put(key, cstmFld);
		} else if (value.getClass().equals(String.class)) {
			CustomField cstmFld = new CustomField();
			cstmFld.setId(null);
			cstmFld.setSelf(null);
			cstmFld.setValue(value.toString());
			customFields.put(key, cstmFld);

		} else if (value.getClass().equals(ArrayList.class)) {
			for (Object o : (ArrayList<Object>) value) {
				setCustomFields(key, o);
			}
		} else if (value.getClass().equals(LinkedHashMap.class)) {

			LinkedHashMap val = (LinkedHashMap) value;

			ObjectMapper obj = new ObjectMapper();

			if (val.containsKey("emailAddress")) {
				User user = obj.convertValue(value, User.class);
				CustomField cstmFld = new CustomField();
				cstmFld.setId(null);
				cstmFld.setSelf(user.getSelf());
				cstmFld.setValue(user.getName());
				
				customFields.put(key, cstmFld);
			} else {

				CustomField cust = obj.convertValue(value, CustomField.class);
				customFields.put(key, cust);
			}
			
		}
		return this;

	}

	public Map<String, CustomField> getCustomFields() {
		return customFields;
	}

//	public Fields setCustomFields1(String key, String value) {
//		customFields1.put(key, value);
//
//		return this;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aggregateoriginaltimeestimate == null) ? 0 : aggregateoriginaltimeestimate.hashCode());
		result = prime * result + ((aggregateprogress == null) ? 0 : aggregateprogress.hashCode());
		result = prime * result + ((aggregatetimeestimate == null) ? 0 : aggregatetimeestimate.hashCode());
		result = prime * result
				+ ((aggregatetimeoriginalestimate == null) ? 0 : aggregatetimeoriginalestimate.hashCode());
		result = prime * result + ((aggregatetimespent == null) ? 0 : aggregatetimespent.hashCode());
		result = prime * result + ((assignee == null) ? 0 : assignee.hashCode());
		result = prime * result + ((attachment == null) ? 0 : attachment.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((components == null) ? 0 : components.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((customFields == null) ? 0 : customFields.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		result = prime * result + ((environment == null) ? 0 : environment.hashCode());
		result = prime * result + ((fixVersions == null) ? 0 : fixVersions.hashCode());
		result = prime * result + ((issueType == null) ? 0 : issueType.hashCode());
		result = prime * result + ((issuelinks == null) ? 0 : issuelinks.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result + ((lastViewed == null) ? 0 : lastViewed.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((progress == null) ? 0 : progress.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((reporter == null) ? 0 : reporter.hashCode());
		result = prime * result + ((resolution == null) ? 0 : resolution.hashCode());
		result = prime * result + ((resolutiondate == null) ? 0 : resolutiondate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((subtasks == null) ? 0 : subtasks.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result + ((timeestimate == null) ? 0 : timeestimate.hashCode());
		result = prime * result + ((timeoriginalestimate == null) ? 0 : timeoriginalestimate.hashCode());
		result = prime * result + ((timespent == null) ? 0 : timespent.hashCode());
		result = prime * result + ((timetracking == null) ? 0 : timetracking.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		result = prime * result + ((versions == null) ? 0 : versions.hashCode());
		result = prime * result + ((votes == null) ? 0 : votes.hashCode());
		result = prime * result + ((watches == null) ? 0 : watches.hashCode());
		result = prime * result + ((worklog == null) ? 0 : worklog.hashCode());
		result = prime * result + ((workratio == null) ? 0 : workratio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fields other = (Fields) obj;
		if (aggregateoriginaltimeestimate == null) {
			if (other.aggregateoriginaltimeestimate != null)
				return false;
		} else if (!aggregateoriginaltimeestimate.equals(other.aggregateoriginaltimeestimate))
			return false;
		if (aggregateprogress == null) {
			if (other.aggregateprogress != null)
				return false;
		} else if (!aggregateprogress.equals(other.aggregateprogress))
			return false;
		if (aggregatetimeestimate == null) {
			if (other.aggregatetimeestimate != null)
				return false;
		} else if (!aggregatetimeestimate.equals(other.aggregatetimeestimate))
			return false;
		if (aggregatetimeoriginalestimate == null) {
			if (other.aggregatetimeoriginalestimate != null)
				return false;
		} else if (!aggregatetimeoriginalestimate.equals(other.aggregatetimeoriginalestimate))
			return false;
		if (aggregatetimespent == null) {
			if (other.aggregatetimespent != null)
				return false;
		} else if (!aggregatetimespent.equals(other.aggregatetimespent))
			return false;
		if (assignee == null) {
			if (other.assignee != null)
				return false;
		} else if (!assignee.equals(other.assignee))
			return false;
		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (customFields == null) {
			if (other.customFields != null)
				return false;
		} else if (!customFields.equals(other.customFields))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (environment == null) {
			if (other.environment != null)
				return false;
		} else if (!environment.equals(other.environment))
			return false;
		if (fixVersions == null) {
			if (other.fixVersions != null)
				return false;
		} else if (!fixVersions.equals(other.fixVersions))
			return false;
		if (issueType == null) {
			if (other.issueType != null)
				return false;
		} else if (!issueType.equals(other.issueType))
			return false;
		if (issuelinks == null) {
			if (other.issuelinks != null)
				return false;
		} else if (!issuelinks.equals(other.issuelinks))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		if (lastViewed == null) {
			if (other.lastViewed != null)
				return false;
		} else if (!lastViewed.equals(other.lastViewed))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (progress == null) {
			if (other.progress != null)
				return false;
		} else if (!progress.equals(other.progress))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (reporter == null) {
			if (other.reporter != null)
				return false;
		} else if (!reporter.equals(other.reporter))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		if (resolutiondate == null) {
			if (other.resolutiondate != null)
				return false;
		} else if (!resolutiondate.equals(other.resolutiondate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subtasks == null) {
			if (other.subtasks != null)
				return false;
		} else if (!subtasks.equals(other.subtasks))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (timeestimate == null) {
			if (other.timeestimate != null)
				return false;
		} else if (!timeestimate.equals(other.timeestimate))
			return false;
		if (timeoriginalestimate == null) {
			if (other.timeoriginalestimate != null)
				return false;
		} else if (!timeoriginalestimate.equals(other.timeoriginalestimate))
			return false;
		if (timespent == null) {
			if (other.timespent != null)
				return false;
		} else if (!timespent.equals(other.timespent))
			return false;
		if (timetracking == null) {
			if (other.timetracking != null)
				return false;
		} else if (!timetracking.equals(other.timetracking))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		if (versions == null) {
			if (other.versions != null)
				return false;
		} else if (!versions.equals(other.versions))
			return false;
		if (votes == null) {
			if (other.votes != null)
				return false;
		} else if (!votes.equals(other.votes))
			return false;
		if (watches == null) {
			if (other.watches != null)
				return false;
		} else if (!watches.equals(other.watches))
			return false;
		if (worklog == null) {
			if (other.worklog != null)
				return false;
		} else if (!worklog.equals(other.worklog))
			return false;
		if (workratio == null) {
			if (other.workratio != null)
				return false;
		} else if (!workratio.equals(other.workratio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fields [issueType=");
		builder.append(issueType);
		builder.append(", components=");
		builder.append(components);
		builder.append(", timespent=");
		builder.append(timespent);
		builder.append(", timeoriginalestimate=");
		builder.append(timeoriginalestimate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", project=");
		builder.append(project);
		builder.append(", fixVersions=");
		builder.append(fixVersions);
		builder.append(", aggregatetimespent=");
		builder.append(aggregatetimespent);
		builder.append(", resolution=");
		builder.append(resolution);
		builder.append(", timetracking=");
		builder.append(timetracking);
		builder.append(", attachment=");
		builder.append(attachment);
		builder.append(", aggregatetimeestimate=");
		builder.append(aggregatetimeestimate);
		builder.append(", resolutiondate=");
		builder.append(resolutiondate);
		builder.append(", workratio=");
		builder.append(workratio);
		builder.append(", summary=");
		builder.append(summary);
		builder.append(", lastViewed=");
		builder.append(lastViewed);
		builder.append(", watches=");
		builder.append(watches);
		builder.append(", creator=");
		builder.append(creator);
		builder.append(", subtasks=");
		builder.append(subtasks);
		builder.append(", aggregateprogress=");
		builder.append(aggregateprogress);
		builder.append(", created=");
		builder.append(created);
		builder.append(", reporter=");
		builder.append(reporter);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", labels=");
		builder.append(labels);
		builder.append(", environment=");
		builder.append(environment);
		builder.append(", timeestimate=");
		builder.append(timeestimate);
		builder.append(", aggregateoriginaltimeestimate=");
		builder.append(aggregateoriginaltimeestimate);
		builder.append(", versions=");
		builder.append(versions);
		builder.append(", duedate=");
		builder.append(duedate);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", issuelinks=");
		builder.append(issuelinks);
		builder.append(", votes=");
		builder.append(votes);
		builder.append(", assignee=");
		builder.append(assignee);
		builder.append(", updated=");
		builder.append(updated);
		builder.append(", status=");
		builder.append(status);
		builder.append(", worklog=");
		builder.append(worklog);
		builder.append(", aggregatetimeoriginalestimate=");
		builder.append(aggregatetimeoriginalestimate);
		builder.append(", customFields=");
		builder.append(customFields);
		builder.append(", customFields1=");
		builder.append(", customFieldArr=");
		builder.append("]");
		return builder.toString();
	}
}

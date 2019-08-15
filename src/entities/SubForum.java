package entities;

import java.io.Serializable;
import java.util.ArrayList;

public class SubForum implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private String icon;
	private String rules;
	private String mainModerator;
	private String[] moderators; 

	public SubForum() {
		// TODO Auto-generated constructor stub
	}
	
	public SubForum(String name, String description, String icon, String rules,
			String mainModerator, String[] moderators ) {
		super();
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.rules = rules;
		this.mainModerator = mainModerator;
		this.moderators = moderators;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getMainModerator() {
		return mainModerator;
	}

	public void setMainModerator(String mainModerator) {
		this.mainModerator = mainModerator;
	}

	public String[] getModerators() {
		return moderators;
	}

	public void setModerators(String[] moderators) {
		this.moderators = moderators;
	}

}

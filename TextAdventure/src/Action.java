public class Action {
	
	private String actionName;
	private String requires;
	private String description;
	private String performs;
	
	public Action(String string, String tokens, String tokens2, String tokens3) {
		this.actionName = string;
		this.description = tokens;
		this.requires = tokens2;
		this.performs = parseperform(tokens3);
	}

	private String parseperform(String tokens3) {
		return tokens3;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getRequires() {
		return requires;
	}

	public void setRequires(String requires) {
		this.requires = requires;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerforms() {
		return performs;
	}

	public void setPerforms(String performs) {
		this.performs = performs;
	}
	
}

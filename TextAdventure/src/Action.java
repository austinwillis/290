import java.util.ArrayList;


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
		return null;
	}
	
}

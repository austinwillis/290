
public class Item {
	
	private String itemName;
	private String description;
	private String required;

	public Item(String string, String tokens, String tokens2) {
		this.itemName = string;
		this.description = tokens;
		this.required = tokens2;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}
	
}

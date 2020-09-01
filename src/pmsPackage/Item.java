package pmsPackage;

/**
 * <h2>Item<h2>
 * <p>This class implements an Item object which contains a String identifier.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

class Item {
	private String description = "";
	
	public Item() {}
	
	public Item(String s) {
		description = s;
	}
	
	/**
	 * This method returns a String description of the Item object.
	 * <pre>Examples:
	 * {@code getItem() returns a description of the item object.}
	 * </pre>
	 * @return description(String; a description of the Item object.)
	 */
	public String getItem() {
		return this.description;
	}
	
	/**
	 * This method sets the description of the Item object.
	 * <pre>Examples:
	 * {@code setItem("food") sets the description field to "food".}
	 * </pre>
	 */
	public void setItem(String s) {
		description = s;
	}
}

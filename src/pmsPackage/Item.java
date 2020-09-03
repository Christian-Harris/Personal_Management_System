package pmsPackage;

/**
 * <h2>Item</h2>
 * <p>This class implements an Item object which contains a String identifier and a boolean marker for whether or not the Item is checked.</p>
 * <p>Created on 31 August 2020</p>
 * @author Christian Harris
 */

class Item {
	private String contents = "";
	private boolean checked = false;
	
	/**
	 * Constructs a blank Item with it's contents set to an empty string and checked being set to false.
	 */
	public Item() {}
	
	/**
	 * Construct an Item with this.contents set to the parameter contents.
	 * @param contents - the contents of the Item.
	 */
	public Item(String contents) {
		this.contents = contents;
	}
	
	/**
	 * Returns the contents of this Item.
	 * @return : the contents of this Item.
	 */
	public String getContents() {
		return this.contents;
	}
	
	/**
	 * Sets the checked field of this Item to checked.
	 * @param checked - sets this Item to be check if true or unchecked if false.
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	/**
	 * This method converts all fields of this Item to a formatted string as +contents if this Item is checked and -contents otherwise.
	 */
	public String toString() {
		if(checked) {
			return "+" + this.contents;
		}
		else {
			return "-" + this.contents;
		}
	}
}

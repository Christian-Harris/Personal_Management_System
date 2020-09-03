package pmsPackage;

/**
 * <h2>Item<h2>
 * <p>This class implements an Item object which contains a String identifier.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

class Item {
	private String contents = "";
	private boolean checked = false;
	
	public Item() {}
	
	public Item(String s) {
		contents = s;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public void setChecked(boolean c) {
		this.checked = c;
	}
	
	public String toString() {
		if(checked) {
			return "+" + this.contents;
		}
		else {
			return "-" + this.contents;
		}
	}
}

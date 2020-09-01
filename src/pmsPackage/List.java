package pmsPackage;

import java.util.*;

/**
 * <h2>List<h2>
 * <p>This class implements a List object with contains an ArrayList<Item> of Item objects.
 * <p>Created on 31 August 2020
 * @author Christian Harris
 */

class List {
	private String name;
	private ArrayList<Item> list;
	
	public List(String s) {
		this.name = s;
		this.list = new ArrayList<Item>();
	}
	
	public List(String s, ArrayList<Item> itm) {
		this.name = s;
		this.list = itm;
	}
	
	/**
	 * This method adds the specified Item to the current list.
	 * <pre>Examples:
	 * {@code addItem(Item food) adds the item food to the current list.}
	 * </pre>
	 */
	public void addItem(Item itm) {
		this.list.add(itm);
	}
	
	/**
	 * This method deletes an Item object whose description field matches the String itm. If no such item exists the list is unchanged.
	 * <pre>Examples:
	 * {@code deleteItem("food") removes an item with description "food".}
	 * </pre>
	 */
	public void deleteItem(String itm) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getItem().compareTo(itm) == 0) {
				this.getList().remove(i);
			}
		}
	}

	/**
	 * This method returns the reference to the ArrayList<Item> object.
	 * <pre>Examples:
	 * {@code getList() returns the reference to the ArrayList<Item> object.}
	 * </pre>
	 * @return list (ArrayList<Item>; a reference to the ArrayList<Item> object.)
	 */
	public ArrayList<Item> getList(){
		return this.list;
	}
	
	/**
	 * This method sets the name of this List object.
	 * <pre>Examples:
	 * {@code setName("Shopping") sets the name field of this List object to "Shopping".}
	 * </pre>
	 */
	public void setName(String s) {
		this.name = s;
	}
	
	/**
	 * This method returns the name field of this List object.
	 * <pre>Examples:
	 * {@code getName() returns the name field of this List object.}
	 * </pre>
	 * @return name (String; the name field of this List object.)
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method prints the contents of this List object to the console.
	 */
	public void display(Scanner in) {
		String selection = "";
		while(true) {
			for(int i = 0; i < this.list.size(); i++) {
				System.out.println(this.list.get(i).getItem());
			}
			System.out.print("0) Return to lists\n1)Add item\n2) Delete item\n>");
			selection = in.nextLine();
			if(selection.equals("0")) {
				return;
			}
			else if(selection.equals("1")) {
				System.out.print("Enter the name of the new item:\n>");
				selection = in.nextLine();
				if(this.itemExists(selection)) {
					System.out.println(selection + " already exists as an item.");
				}
				else {
					this.list.add(new Item(selection));
				}
			}
			else if(selection.equals("2")) {
				System.out.print("Enter the item to delete:\n>");
				selection = in.nextLine();
				if(!this.itemExists(selection)) {
					System.out.println(selection + " does not exist.");
				}
				else {
					this.deleteItem(selection);
				}
			}
			else {
				System.out.println("Invalid selection.");
			}
		}
	}
	
	/**
	 * This method returns true if there exists and Item object in this List with a description of s.
	 * <pre>Examples:
	 * {@code itemExists("apple") returns true if this list contains an Item with a description of "apple".}
	 * </pre>
	 */
	public boolean itemExists(String s) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getItem().equals(s)) {
				return true;
			}
		}
		return false;
	}
}

package pmsPackage;

import java.util.*;

/**
 * <h2>List</h2>
 * <p>This class implements a List object which contains an ArrayList of Item objects.</p>
 * <p>Created on 31 August 2020</p>
 * @author Christian Harris
 *
 */

class List {
	private String name;
	private ArrayList<Item> list = new ArrayList<Item>();
	
	/**
	 * Constructs an empy List with this name set to name.
	 * @param name - the name of the List.
	 */
	public List(String name) {
		this.name = name;
	}
	
	/**
	 * Constructs a list with items in list and this name set to name.
	 * @param name - the name of the List
	 * @param list - the list.
	 */
	public List(String name, ArrayList<Item> list) {
		this.name = name;
		this.list = list;
	}
	
	/**
	 * This method adds itm to list.
	 * @param itm - the Item to be added to list.
	 */
	public void addItem(Item itm) {
		this.list.add(itm);
	}
	
	/**
	 * This method finds all instances of Items in list with name and removes them.
	 * @param name - the name of the Item(s) to be removed.
	 */
	public void deleteItem(String name) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(name)) {
				this.list.remove(i);
			}
		}
	}
	
	/**
	 * This method finds all instances of Items in list with name and sets them to be checked.
	 * @param name - the name of the Item(s) to be checked.
	 */
	public void checkItem(String name) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(name)) {
				this.list.get(i).setChecked(true);
			}
		}
	}
	
	/**
	 * This method finds all instances of Items in list with name and sets them to be unchecked.
	 * @param name - the name of the Item(s) to be unchecked.
	 */
	public void uncheckItem(String name) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(name)) {
				this.list.get(i).setChecked(false);
			}
		}
	}

	/**
	 * This method returns the name of this List.
	 * @return - the name of this List.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * This method prints the name of each Item in list to the console. Each name is on a new line.
	 */
	public void display() {
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println(this.list.get(i).toString());
		}
	}
}

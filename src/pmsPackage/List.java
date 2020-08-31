package pmsPackage;

import java.util.*;

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
	
	public void addItem(Item itm) {
		this.list.add(itm);
	}
	
	public void deleteItem(String itm) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getItem().compareTo(itm) == 0) {
				this.getList().remove(i);
			}
		}
	}
	
	public void deleteItem(int i) {
		this.getList().remove(i);
	}
	
	public ArrayList<Item> getList(){
		return this.list;
	}
	
	public void setName(String s) {
		this.name = s;
	}
	
	public String getName() {
		return this.name;
	}
	
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
	
	public boolean itemExists(String s) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getItem().equals(s)) {
				return true;
			}
		}
		return false;
	}
}

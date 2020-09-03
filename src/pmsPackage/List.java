package pmsPackage;

import java.util.*;

class List {
	private String name;
	private ArrayList<Item> list = new ArrayList<Item>();
	
	public List(String s) {
		this.name = s;
	}
	
	public List(String name, ArrayList<Item> list) {
		this.name = name;
		this.list = list;
	}
	
	public void addItem(Item itm) {
		this.list.add(itm);
	}
	
	public void deleteItem(String name) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(name)) {
				this.list.remove(i);
			}
		}
	}
	
	public void checkItem(String name) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(name)) {
				this.list.get(i).setChecked(true);
			}
		}
	}
	
	public void uncheckItem(String name) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(name)) {
				this.list.get(i).setChecked(false);
			}
		}
	}

	public String getName() {
		return this.name;
	}
	
	public String toString() {
		return this.name;
	}
	
	public void display() {
		for(int i = 0; i < this.list.size(); i++) {
			System.out.println(this.list.get(i).toString());
		}
	}
}

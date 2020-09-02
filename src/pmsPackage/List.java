package pmsPackage;

import java.util.*;

class List {
	private String name;
	private ArrayList<Item> list = new ArrayList<Item>();
	
	public List(String s) {
		this.name = s;
	}
	
	public List(String s, ArrayList<Item> itms) {
		this.name = s;
		list = itms;
	}
	
	public void addItem(Item itm) {
		this.list.add(itm);
	}
	
	public void deleteItem(String itm) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(itm)) {
				this.list.remove(i);
			}
		}
	}
	
	public void checkItem(String itm) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(itm)) {
				this.list.get(i).setChecked(true);
			}
		}
	}
	
	public void uncheckItem(String itm) {
		for(int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).getContents().equals(itm)) {
				this.list.get(i).setChecked(false);
			}
		}
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
	
	public boolean itemExists(String s) {
		return false;
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

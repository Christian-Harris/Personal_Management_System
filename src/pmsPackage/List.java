package pmsPackage;

import java.util.*;

public class List {
	private ArrayList<Item> list;
	
	public List() {
		this.list = new ArrayList<Item>();
	}
	
	public List(ArrayList<Item> itm) {
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
}

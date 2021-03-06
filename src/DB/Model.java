package DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Model {
	private ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	private String menu_name;
	private int price;
	
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Map<String, String> listToMap(){
		HashMap<String, String> map = new HashMap<String,String>();
		for(HashMap<String,String> data: list) {
			map.put(data.get("menu_name"), data.get("price"));
		}
		return map;
	}
	
	public void setList(ArrayList<HashMap<String, String>> list) { this.list = list; }
	public ArrayList<HashMap<String, String>> getList(){ return list; }
	public static String getError() {
		return "Data type Error set Data Type : "+Model.class.toString();
	}
}

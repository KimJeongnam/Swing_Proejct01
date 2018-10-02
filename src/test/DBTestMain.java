package test;

import java.util.ArrayList;
import java.util.HashMap;
import DB.DB_Handler;
import DB.MenuCommand.Delete_Command;
import DB.MenuCommand.Insert_Command;
import DB.MenuCommand.Model;
import DB.MenuCommand.SelectAll_Command;

public class DBTestMain {
	public static void main(String[] args) {
		DB_Handler handler = new DB_Handler();
		handler.setCommand(new Insert_Command());
		
		Model model = new Model();
		
		
		// Insert data
		/*model.setMenu_name("탕수육");
		model.setPrice(30000);
		handler.execute(model);
		  
		model.setMenu_name("육회");
		model.setPrice(40000);
		handler.execute(model);
		
		model.setMenu_name("냉면");
		model.setPrice(5000);
		handler.execute(model);
		
		model.setMenu_name("부대찌개");
		model.setPrice(12000);
		handler.execute(model);*/
		
		
		// SELECT * FROM MENUS;
		handler.setCommand(new SelectAll_Command());
		handler.execute(model);
		
		ArrayList<HashMap<String, String>> list = model.getList();
		/*HashMap<String,String> data = null;*/
		
		/*Iterator<HashMap<String, String>> it = list.iterator();
		System.out.println("{");
		while(it.hasNext()) {
			data = it.next();
			System.out.println("{menu_name :"+data.get("menu_name")+", price : "+data.get("price")+"}");
		}*/
		
		System.out.println("menus{");
		for(HashMap<String, String> data : list) {
			System.out.println("\t{menu_name :"+data.get("menu_name")+", price : "+data.get("price")+"},");
		}
		System.out.println("}");
		
		handler.setCommand(new Delete_Command());
		model.setMenu_name("부대찌개");
		handler.execute(model);
		
		
		handler.setCommand(new SelectAll_Command());
		handler.execute(model);
		
		System.out.println("menus{");
		for(HashMap<String, String> data : list) {
			System.out.println("\t{menu_name :"+data.get("menu_name")+", price : "+data.get("price")+"},");
		}
		System.out.println("}");
	}
}

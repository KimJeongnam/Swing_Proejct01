package Tables;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DB.DB_Handler;
import DB.Model;
import DB.MenuCommand.SelectAll_Command;

public class MenuTablePanel extends JPanel implements Observer{
	/**
	 *  옵저버 기능이있는 패널
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table = null;
	private MenuTableModel tableModel = null;
	private ArrayList<HashMap<String, String>> menu_list;
	
	public MenuTablePanel(ArrayList<HashMap<String, String>> menu_list){
		this.menu_list = menu_list;
		
		tableModel = new MenuTableModel(menu_list);
		table = new JTable(tableModel);
		table.setFillsViewportHeight(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		for(HashMap<String, String> map : menu_list) {
			System.out.println(map);
		}
		tableModel= new MenuTableModel(menu_list);
		table.setModel(tableModel);
	}
	
	public MenuTableModel getTableModel() { return this.tableModel; }
}

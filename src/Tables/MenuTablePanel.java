package Tables;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DB.DB_Handler;
import DB.MenuCommand.Model;
import DB.MenuCommand.SelectAll_Command;

public class MenuTablePanel extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table = null;
	private JTextField tf_menu = null;
	private JTextField tf_price = null;
	private MenuTableModel tableModel = null;
	
	public MenuTablePanel(JTextField tf_menu, JTextField tf_price, ArrayList<HashMap<String, String>> menu_list){
		this.tf_menu = tf_menu;
		this.tf_price = tf_price;
		
		DB_Handler handler = new DB_Handler();
		handler.setCommand(new SelectAll_Command());
		
		Model model = new Model();
		model.setList(menu_list);
		handler.execute(model);
		
		if(model.getList().isEmpty())
			return;
		
		tableModel = new MenuTableModel(model.getList());
		table = new JTable(tableModel);
		table.setFillsViewportHeight(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		tableModel.fireTableDataChanged();
	}
	
	public MenuTableModel getTableModel() { return this.tableModel; }
}

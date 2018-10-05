package Form;

import javax.swing.JFrame;

import DB.DB_Handler;
import DB.Model;
import DB.MenuCommand.SelectAll_Command;
import Tables.MenuTableNotifyMachine;
import Tables.MenuTablePanel;

public class MenuTableForm extends JFrame{

	/**
	 * 메뉴 리스트를 표시하기 위한 창
	 */
	private static final long serialVersionUID = 2L;
	private Model model;
	private MenuTableNotifyMachine machine;
	
	public MenuTableForm() {
		model = Win_Program.getModel();
		machine = Win_Program.getMachine();
		
		this.add(createTable());
		this.setSize(500,500);
		this.setLocation(500, 200);
		this.setUndecorated(true);
		this.setVisible(true);
		
		
	}
	
	public MenuTablePanel createTable() {
		DB_Handler handler = new DB_Handler();
		handler.setCommand(new SelectAll_Command());
		handler.execute(model);

		MenuTablePanel panel = new MenuTablePanel(machine.getList());
		machine.add(panel);

		return panel;
	}

}

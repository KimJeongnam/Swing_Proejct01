package DB.MenuCommand;

import java.sql.PreparedStatement;

import DB.Crud_Command;

public class Update_Command implements Crud_Command{
	PreparedStatement stmt;
	
	@Override
	public void execute(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Model)) {
			System.out.println(Model.getError());
			return;
		}
		String sql = "UPDATE MENUS SET price=? WHERE menu_name=?";
	}
	
}

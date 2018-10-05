package DB.MenuCommand;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import DB.Crud_Command;
import DB.Model;
import DB.mysqldb;

public class Delete_Command implements Crud_Command {
	PreparedStatement stmt;

	@Override
	public void execute(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		if (!(obj instanceof Model)) {
			System.out.println(Model.getError());
			return;
		}
		String sql = "DELETE FROM MENUS WHERE menu_name=?";

		Model data = (Model) obj;
		String menu_name = data.getMenu_name();

		stmt = mysqldb.getDB().getConnection().prepareStatement(sql);
		stmt.setString(1, menu_name);

		ArrayList<HashMap<String, String>> list = data.getList();
		
		boolean status = false;
		for(Iterator<HashMap<String, String>> it = list.iterator(); it.hasNext();) {
			HashMap<String, String> buf = it.next();
			
			if(buf.get("menu_name").equals(menu_name)) {
				it.remove();
				status = true;
			}
		}
		if(!status)
			throw new SQLException("Model data remove Fail");
		
		int result = stmt.executeUpdate();
		if (result > 0)
			System.out.println("A user was deleted successfully!");
		else
			System.out.println("none delete");
		stmt.close();
	}

}

package DB.MenuCommand;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.Crud_Command;
import DB.mysqldb;

public class Delete_Command  implements Crud_Command{
	PreparedStatement stmt;
	
	@Override
	public void execute(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Model)) {
			System.out.println(Model.getError());
			return;
		}
		String sql = "DELETE FROM MENUS WHERE menu_name=?";
		
		Model data = (Model)obj;
		String menu_name = data.getMenu_name();
		
		try {
			stmt = mysqldb.getDB().getConnection().prepareStatement(sql);
			stmt.setString(1, menu_name);
			
			int result = stmt.executeUpdate();
			if(result >0) 
				System.out.println("A user was deleted successfully!");
		}catch(SQLException e) {
			mysqldb.printSQLError(e);
		}finally {
			try {
				stmt.close();
			}catch(SQLException e) {
				mysqldb.printSQLError(e);
			}
		}
	}

}

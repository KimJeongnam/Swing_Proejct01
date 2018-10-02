package DB.MenuCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import DB.Crud_Command;
import DB.mysqldb;

public class SelectAll_Command implements Crud_Command{
	Statement stmt;
	ResultSet rs;
	
	@Override
	public void execute(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Model)) {
			System.out.println(Model.getError());
		}
		String sql = "SELECT * FROM MENUS";
		stmt = mysqldb.getDB().getStatement();
		
		Model data = (Model)obj;
		ArrayList<HashMap<String, String>> list = data.getList();
		
		if(!list.isEmpty())
			list.clear();
		
		try {
			rs = stmt.executeQuery(sql);
		
			while(rs.next()) {
				HashMap<String, String> buf = new HashMap<String, String>();
				buf.put("menu_name", rs.getString(1));
				buf.put("price",  Integer.toString(rs.getInt(2)));
				list.add(buf);
			}
			
		}catch(SQLException e) {
			mysqldb.printSQLError(e);
		}finally {
			try {
				stmt.close();
				rs.close();
			}catch(SQLException e) {
				mysqldb.printSQLError(e);
			}
		}
		
		
		
	}

}

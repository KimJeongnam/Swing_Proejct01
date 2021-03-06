package DB.MenuCommand;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import DB.Crud_Command;
import DB.Model;
import DB.mysqldb;

public class SelectAll_Command implements Crud_Command {
	Statement stmt;
	ResultSet rs;

	@Override
	public void execute(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		if (!(obj instanceof Model)) {
			System.out.println(Model.getError());
		}
		String sql = "SELECT * FROM MENUS";
		stmt = mysqldb.getDB().getStatement();

		Model data = (Model) obj;
		ArrayList<HashMap<String, String>> list = data.getList();

		if(list== null) {
			System.err.println("Please Set Model.setList()");
			return;
		}
		if (!list.isEmpty())
			list.clear();

		rs = stmt.executeQuery(sql);

		while (rs.next()) {
			HashMap<String, String> buf = new HashMap<String, String>();
			buf.put("menu_name", rs.getString(1));
			buf.put("price", Integer.toString(rs.getInt(2)));
			list.add(buf);
		}
		stmt.close();
		rs.close();
	}

}

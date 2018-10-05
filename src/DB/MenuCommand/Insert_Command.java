package DB.MenuCommand;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.Crud_Command;
import DB.Model;
import DB.mysqldb;

public class Insert_Command implements Crud_Command {
	PreparedStatement stmt;

	@Override
	public void execute(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		if (!(obj instanceof Model)) {
			System.out.println(Model.getError());
			return;
		}
		Model dao = (Model) obj;
		String sql = "INSERT INTO MENUS VALUES(?, ?)";

		String menu_name = dao.getMenu_name();
		int price = dao.getPrice();

		stmt = mysqldb.getDB().getConnection().prepareStatement(sql);

		stmt.setString(1, menu_name);
		stmt.setInt(2, price);

		int rowsInserted = stmt.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");
		}
		stmt.close();

	}
}

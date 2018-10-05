package DB;

import java.sql.SQLException;

public class DB_Handler{
	Crud_Command command;
	
	public DB_Handler() {}
	
	public DB_Handler(Crud_Command command) {
		this.command = command;
	}
	
	public void setCommand(Crud_Command command) { this.command = command; }
	public Crud_Command getCommand() { return this.command; }
	
	public void execute(Object obj) {
		try {
		command.execute(obj);
		}catch(SQLException e) {
			mysqldb.printSQLError(e);
		}
	}
}

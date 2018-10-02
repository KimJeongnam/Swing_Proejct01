package DB;

public class DB_Handler{

	Crud_Command command;
	public void setCommand(Crud_Command command) { this.command = command; }
	public Crud_Command getCommand() { return this.command; }
	
	public void execute(Object obj) {
		command.execute(obj);
	}
}

package DB;

import java.sql.SQLException;

public interface Crud_Command {
	public void execute(Object obj) throws SQLException;
}

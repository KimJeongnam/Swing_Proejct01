package Tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import DB.Money;

public class MenuTableModel extends AbstractTableModel{
	/**
	 * 커스텀 테이블 모델
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames  = {"메뉴 이름 ", "가격(원)"};
	private Object[][] datas;
	
	public MenuTableModel(ArrayList<HashMap<String, String>> list) {
		// TODO Auto-generated constructor stub
		int cnt=0;
		datas = new Object[list.size()][2];
		for(Map<String, String> data: list) {
			this.datas[cnt][0] = data.get("menu_name"); 
			this.datas[cnt][1] = Money.moneyToString(Integer.parseInt(data.get("price")));
			cnt++;
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	
	public String getColumnName(int col) {
	      return columnNames[col];
	    }
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datas.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return datas[arg0][arg1];
	}
	
	public Class getColumnClass(int row) {
		return getValueAt(0, row).getClass();
	}

}

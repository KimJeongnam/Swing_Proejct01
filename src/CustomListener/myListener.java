package CustomListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DB.DB_Handler;
import DB.Model;
import DB.MenuCommand.Delete_Command;
import Form.SubForm;
import Form.Win_Program;
import Tables.MenuTableNotifyMachine;

public class myListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		
		if(str.equals("Order")) {
			JFrame mainFrame = Win_Program.getMainFrame();
			mainFrame.setVisible(false);
			new SubForm();
		}else if(str.equals("메뉴 삭제")) {
			MenuTableNotifyMachine machine = Win_Program.getMachine();
			
			Model model = Win_Program.getModel();
			Map<String, String> map = Win_Program.getModel().listToMap();
			
			String menu = Win_Program.getTf_menu().getText();
			
			if(!(menu.length()>0)){
				JOptionPane.showMessageDialog(null, "지우실 메뉴를 입력해주세요.", "Insert Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			if(!map.containsKey(menu)) {
				JOptionPane.showMessageDialog(null, "메뉴목록에 없습니다. 다시한번 확인하세요.!!", "Insert Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			DB_Handler handler = new DB_Handler(new Delete_Command());
			model.setMenu_name(menu);
			handler.execute(model);
			
			machine.notifyObservers();
			
			map.remove(menu);
			JOptionPane.showMessageDialog(null, "메뉴명 : "+menu+"삭제 완료.", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

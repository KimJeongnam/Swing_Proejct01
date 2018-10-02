package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class myListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		
		if(str.equals("Order")) {
			JFrame mainFrame = Win_Program.getMainFrame();
			mainFrame.setVisible(false);
			new SubForm();
		}else if(str.equals("메뉴 삭제")) {
			Map<String, Integer> map = Win_Program.getMenus();
			String menu = Win_Program.getTf_menu().getText();
			
			if(!map.containsKey(menu)) {
				JOptionPane.showMessageDialog(null, "메뉴목록에 없습니다. 다시한번 확인하세요.!!", "Insert Error!", JOptionPane.ERROR_MESSAGE);
				return;
			}
			map.remove(menu);
			JOptionPane.showMessageDialog(null, "메뉴명 : "+menu+"삭제 완료.", "Success", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

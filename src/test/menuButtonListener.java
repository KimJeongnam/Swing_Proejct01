package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class menuButtonListener implements ActionListener{
	private static ArrayList<JButton> button_list = new ArrayList<JButton>();
	
	public static ArrayList<JButton> getButtons(){ return button_list; }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String str = arg0.getActionCommand();
		
		Map<String, Integer> map = Win_Program.getMenus();
		
		JOptionPane.showMessageDialog(null, "메뉴명 : "+str+" 가격 : "+map.get(str), "Order", JOptionPane.INFORMATION_MESSAGE);
	}

}

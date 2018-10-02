package test;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private JPanel panel = null;
	private Map<String, Integer> map=null;
	
	public SubForm() {
		super("Sub Form");
		
		map = Win_Program.getMenus();
		
		panel = new JPanel(new FlowLayout());
		
		ArrayList<String> menu_list = new ArrayList<String>();
		
		for(String str : map.keySet()) {
			menu_list.add(str);
		}
		
		java.util.Collections.sort(menu_list);
		
		for(String str: menu_list) {
			JButton btn = new JButton(str);
			btn.addActionListener(new menuButtonListener());
			panel.add(btn);
		}
		
		this.add(panel);

		this.setSize(300, 200);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JFrame frame = (JFrame)e.getWindow();
				JFrame mainFrame = Win_Program.getMainFrame();
				mainFrame.setVisible(true);
				frame.dispose();
			}
		});
	}
}

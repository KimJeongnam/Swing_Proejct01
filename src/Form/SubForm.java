package Form;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import CustomListener.menuButtonListener;

public class SubForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private JPanel panel = null;
	private JLabel label = null;
	private Map<String, Integer> map=null;
	
	public SubForm() {
		super("Sub Form");
		
		map = null;
		
		panel = new JPanel(new FlowLayout());
		
		ArrayList<String> menu_list = new ArrayList<String>();
		
		for(String str : map.keySet()) {
			menu_list.add(str);
		}
		
		if(menu_list.isEmpty()) {
			label = new JLabel("None Menu");
			panel.add(label);
		}
		
		java.util.Collections.sort(menu_list);
		
		for(String str: menu_list) {
			JButton btn = new JButton(str);
			btn.addActionListener(new menuButtonListener());
			panel.add(btn);
		}
		
		this.add(panel);

		this.setLocation(750, 350);
		this.pack();
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

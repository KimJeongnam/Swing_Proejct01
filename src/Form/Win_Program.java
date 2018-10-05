package Form;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CustomListener.myListener;
import DB.DB_Handler;
import DB.Model;
import DB.MenuCommand.Insert_Command;
import DB.MenuCommand.SelectAll_Command;
import Tables.MenuTableNotifyMachine;
import Tables.MenuTablePanel;

public class Win_Program extends JFrame {
	/**
	 * 
	 */

	private static JFrame mainFrame;
	private static JTextField tf_menu;
	private static JTextField tf_price;
	private JPanel panel;
	private static JLabel label;
	private static Model model;
	private static MenuTableNotifyMachine machine;
	private static final long serialVersionUID = 1L;

	private MenuTablePanel tablePanel;

	public Win_Program() {
		super("자바 window form");

		mainFrame = this;
		JLabel menu_label;
		JLabel price_label;
		JButton insert_btn;
		JButton newframe_btn;
		JButton remove_btn;
		BoxLayout boxlayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
		if(model == null)
			model = new Model(); // 데이터베이스 모델 객체 생성
		if(machine == null)
			machine = new MenuTableNotifyMachine(model.getList());
		/*
		 * BoxLayout boxlayoutx = new BoxLayout(this.getContentPane(),
		 * BoxLayout.X_AXIS);
		 */
		this.setLayout(boxlayout);

		/* this.setLayout(new FlowLayout()); */
		panel = new JPanel();
		panel.setLayout(new FlowLayout());

		menu_label = new JLabel("메뉴 입력 : ");
		price_label = new JLabel("가격 입력 : ");
		insert_btn = new JButton("입력");
		remove_btn = new JButton("메뉴 삭제");

		ActionListener l = ae -> {
			insertButtonAction();
		};

		insert_btn.addActionListener(l);
		remove_btn.addActionListener(new myListener());

		tf_menu = new JTextField(5);
		tf_price = new JTextField(5);
		tf_price.addActionListener(l);

		// 메뉴 입력, 삭제 버튼및 TextField
		panel.add(menu_label);
		panel.add(tf_menu);
		panel.add(price_label);
		panel.add(tf_price);
		panel.add(insert_btn);
		panel.add(remove_btn);	
		this.add(panel);

/*		// JTable 생성
		tablePanel = createTable();
		this.add(tablePanel);*/

		/*
		 * table.setFillsViewportHeight(false); JScrollPane scrollPane = new
		 * JScrollPane(table);
		 * 
		 * TableColumn column = null; for (int i = 0; i < 5; i++) { column =
		 * table.getColumnModel().getColumn(i); if (i == 2) {
		 * column.setPreferredWidth(100); //third column is bigger } else {
		 * column.setPreferredWidth(50); } }
		 * 
		 * panel = new JPanel(); panel.add(scrollPane);
		 * 
		 * panel.add(table.getTableHeader(), BorderLayout.PAGE_START); panel.add(table);
		 * this.add(panel);
		 */

		// Order 버튼
		newframe_btn = new JButton("Order");

		newframe_btn.addActionListener(new myListener());

		panel = new JPanel();
		panel.add(newframe_btn);

		this.add(panel);

		this.setLocation(995, 200);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void insertButtonAction() {
		ArrayList<HashMap<String, String>> menu_list = machine.getList();
		HashMap<String, String> menus = new HashMap<String, String>();
		String menu = Win_Program.getTf_menu().getText();

		for (HashMap<String, String> map : menu_list) {
			menus.put(map.get("menu_list"), menus.get("price"));
		}

		if (menu.length() == 0) {
			JOptionPane.showMessageDialog(null, "입력 오류!! menu명을 입력하세요.", "Insert Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int price = 0;

		try {
			price = Integer.parseInt(Win_Program.getTf_price().getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력 오류!! price에 숫자를 입력해주세요.", "Insert Error!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (menus.containsKey(menu)) {
			JOptionPane.showMessageDialog(null, "메뉴에 이미 추가되어있습니다.", "Insert Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// DB 핸들러 생성
		DB_Handler handler = new DB_Handler();
		handler.setCommand(new Insert_Command()); // DB 핸들러에 데이터 입력 커멘트 설정

		System.out.println("입력된 메뉴 : " + menu + ", 가격 : " + price);
		Win_Program.getTf_menu().setText("");
		Win_Program.getTf_price().setText("");
		HashMap<String, String> colomn = new HashMap<String, String>();
		colomn.put("menu_name", menu);
		colomn.put("price", Integer.toString(price));
		menu_list.add(colomn);
		machine.notifyObservers();

		// 모델에 메뉴, 가격 세팅 후 DB 적용
		model.setMenu_name(menu);
		model.setPrice(price);
		handler.execute(model);

		JOptionPane.showMessageDialog(null, "메뉴명 : " + menu + " 가격 : " + price + "입력 완료.", "Success",
				JOptionPane.INFORMATION_MESSAGE);
		Win_Program.getTf_menu().requestFocus();
	}

	// Getter
	public static MenuTableNotifyMachine getMachine() {
		return machine;
	}

	public static Model getModel() {
		return model;
	}

	public static JFrame getMainFrame() {
		return mainFrame;
	}

	public static JLabel getLabel() {
		return label;
	}

	public static JTextField getTf_menu() {
		return tf_menu;
	}

	public static JTextField getTf_price() {
		return tf_price;
	}
}

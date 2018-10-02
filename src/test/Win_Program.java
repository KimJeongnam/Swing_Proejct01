package test;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Win_Program extends JFrame {
	/**
	 * 
	 */
	
	private static JFrame mainFrame;
	private static JTextField tf_menu;
	private static JTextField tf_price;
	private JPanel panel;
	private static Map<String, Integer> menus = new HashMap<String, Integer>();
	private static JLabel label;
	private static final long serialVersionUID = 1L;

	public Win_Program() {
		super("자바 window form");
		mainFrame = this;
		JLabel menu_label;
		JLabel price_label;
		JButton insert_btn;
		JButton newframe_btn;
		JButton remove_btn;
		BoxLayout boxlayout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
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

		panel.add(menu_label);
		panel.add(tf_menu);
		panel.add(price_label);
		panel.add(tf_price);
		panel.add(insert_btn);
		panel.add(remove_btn);
		this.add(panel);

		newframe_btn = new JButton("Order");

		newframe_btn.addActionListener(new myListener());

		panel = new JPanel();
		panel.add(newframe_btn);

		this.add(panel);

		this.setSize(500, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void insertButtonAction() {
		Map<String, Integer> map = Win_Program.getMenus();
		String menu = Win_Program.getTf_menu().getText();
		int price = 0;
		
		try {
			price = Integer.parseInt(Win_Program.getTf_price().getText());
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "입력 오류!! price에 숫자를 입력해주세요.", "Insert Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(map.containsKey(menu)) {
			JOptionPane.showMessageDialog(null, "메뉴에 이미 추가되어있습니다.", "Insert Error!", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		System.out.println("입력된 메뉴 : "+menu+", 가격 : "+price);
		Win_Program.getTf_menu().setText("");
		Win_Program.getTf_price().setText("");
		map.put(menu, price);
		
		JOptionPane.showMessageDialog(null, "메뉴명 : "+menu+" 가격 : "+price+"입력 완료.", "Success", JOptionPane.INFORMATION_MESSAGE);
		Win_Program.getTf_menu().requestFocus();
	}

	// Getter
	public static JFrame getMainFrame() { return mainFrame; }
	public static JLabel getLabel() {
		return label;
	}

	public static JTextField getTf_menu() {
		return tf_menu;
	}

	public static JTextField getTf_price() {
		return tf_price;
	}

	public static Map<String, Integer> getMenus() {
		return menus;
	}

	// --------------------- main -------------------
	public static void main(String[] args) {
		new Win_Program();

		ArrayList<String> hobbys = new ArrayList<String>();

		hobbys.add("헬스");
		hobbys.add("게임");
		hobbys.add("수영");
		hobbys.add("영화");
		hobbys.add("독서");
		hobbys.add("잠자기");
		hobbys.add("누워있기");
		hobbys.add("헬스");

		Iterator<String> it = hobbys.iterator();

		while (it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}

		/*
		 * 검색 : list.indexOf(검색할 값); ==> 리스트에서 검색할 값과 똑같은 값을 갖는 첫번째 데이터를 찾아서 그 위치의 인덱스를
		 * 리턴한다.
		 * 
		 * list.lastIndexOf(검색할 값); ==> 리스트에서 검색할 값과 똑같은 값을 갖는 마지막 데이터를 찾아서 그 위치의 인덱스를
		 * 리턴한다. 검색할 값과 일치한 데이터가 없으면 -1을 리턴한다.
		 */
		System.out.println(hobbys.indexOf("헬스"));
		System.out.println(hobbys.lastIndexOf("헬스"));

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("떡볶이", 2000);
		map.put("라면", 1500);
		map.put("짬뽕", 6000);
		map.put("짜장면", 5000);

		System.out.println(map.get("짬뽕"));

	}
}

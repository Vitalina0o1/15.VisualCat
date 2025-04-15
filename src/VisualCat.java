import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Cat extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int STATE_DEFAULT = 0,
	                        STATE_SLEEP = 1;
	
	
	private int catState = 0;
	private String name = "";
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void sleep() {
		
	}
}






public class VisualCat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField field;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualCat frame = new VisualCat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualCat() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("СПАТЬ");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		toolBar.add(btnNewButton);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Cat cat = new Cat();
		cat.setIcon(new ImageIcon(VisualCat.class.getResource("/ing/catHappy.png")));
		cat.setBounds(93, 77, 310, 261);
		panel.add(cat);
		
		field = new JTextField();
		field.setFont(new Font("Tahoma", Font.PLAIN, 26));
		field.setBounds(191, 10, 159, 31);
		panel.add(field);
		field.setColumns(10);
		
		JLabel label = new JLabel("Имя кота:");
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		label.setBounds(48, 11, 134, 31);
		panel.add(label);
		
		JButton button = new JButton("Активировать");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				cat.setName(name);
				label.setVisible(false);//исчезает  программа
				button.setVisible(false);
				field.setEditable(false);
				
			}
		});
		button.setFont(new Font("Trebuchet MS", Font.PLAIN, 27));
		button.setBounds(360, 11, 221, 31);
		panel.add(button);
	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements ActionListener {
	
	private JTextArea textArea;
	private JButton button;
	private JTextField textField;
	private JLabel label;

	public GameGUI() {
		buildWindow();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String s = textField.getText();
		Game.processCommand(s);
	}
	
	public void setAppendText(String text) {
		textArea.append(text + "\n");
	}
	
	public void updateRoomDisplay() {
		textArea.append(Game.currentRoom.getDesc() + "\n");
	}
	
	public void stopAcceptingInput() {
		textField.setEnabled(false);
		button.setEnabled(false);
	}

	private void buildWindow() {
		setTitle("Slay The Dragon");
		setLayout(new BorderLayout());
		
		//Center Area
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(480, 400));
        add(scrollPane, BorderLayout.CENTER);
		
		//South Area
		JPanel panel = new JPanel();
		button = new JButton("Execute");
		button.addActionListener(this);
		label = new JLabel();
		textField = new JTextField();
		panel.setLayout(new GridLayout(3,1));
		panel.add(label);
		panel.add(textField);
		panel.add(button);
		add(panel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}

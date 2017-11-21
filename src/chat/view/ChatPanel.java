package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import chat.controller.ChatController;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatPanel extends JPanel
{
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	
	public ChatPanel(ChatController appController)
	
	
	{
		super();
		this.appController = appController;
		
		//Intialize GUI data members
		chatButton = new JButton("chat");
		
		chatArea = new JTextArea(10, 25);
		inputField = new JTextField(20);
		appLayout = new SpringLayout();
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatArea, 44, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, chatArea, 37, SpringLayout.WEST, this);
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatArea);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		
	}
	
	private void setupLayout()
	{
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String dsiplayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}	
	});
	
	}
}



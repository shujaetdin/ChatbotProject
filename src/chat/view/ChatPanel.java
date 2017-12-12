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
//Need import for scrollpane
import javax.swing.JScrollPane;


/**
 * The JPanel subclass for the chatbot project
 * @author Shujaet Din
 *@version 21/11/17 1,2 Added a 
 */

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
		infoLabel = new JLabel("Type to chat with the chatbot")
		appLayout = new SpringLayout();
		//inithe scrollpane
		chatScrollPane = new JScrollPane();
		checkerButton= new JButton("Check contents");
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, inputField, -6, SpringLayout.WEST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatScrollPane, 44, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -31, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 0, SpringLayout.EAST, chatArea);
		appLayout.putConstraint(SpringLayout.WEST, chatScrollPane, 37, SpringLayout.WEST, this);
		
		//call new helper method
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizonalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
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
	
	checkerButton.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent click)
		{
			String userText = inputField.getText();
			String  displayText = appController.useCheckers(userText);
			chatArea.append(displayText);
			inputField.setText("");
		}
			});
	
	
	
	}
}



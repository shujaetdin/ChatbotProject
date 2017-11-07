package chat.controller;

import chat.view.*;
import chat.model.*;

public class ChatController 
{
private Chatbot chatbot;
private PopupdDisplay display;

public Chatbot controller()
{
	chatbot = new Chatbot ("Shujaet Din");
	display = new Popupdisplay();
}
public void start()
{
	String response = display.collectResponse("What do you want to talk about?");
	
	while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
	{
		response = popupChat(response);

	}
}



public String interactWithChatbot(String input)

private String popupChat(String chat)
{
	String chatbotSays = "";
	
	chatbotSays+= chatbot.processConversation(chat);
	
	return chatbotSays;
}
}

package chat.controller;

import chat.view.*;
import chat.model.*;

public class ChatController<display, PopupdDisplay> 
{
private Chatbot chatbot;
private PopupdDisplay display;

public ChatController()
{
	chatbot = new Chatbot ("Shujaet Din");
	display = new popupDisplay();
}
public void start()
{
	display.displayText("Welcome to Chatbot");
	String response = display.collectResponse("What do you want to talk about?");
	
//	while (chatbot.lengthChecker(response) && !chatbot.quitChecker(response))
//	{
//		response = popupChat(response);
//		response = display.collectResponse(response);
//	}
}



public String interactWithChatbot(String input)
{
	String chatbotSays = "";
	
	if(chatbot.quitecker(input))
	{
		close();
	}
	
	
	chatbotSays += chatbot.processConversation(input);
	
	chatbot.processConversation(input);
	
	return chatbotSays;
}

private String popupChat(String chat)
{
	String chatbotSays = ""; 
	
	chatbotSays+= chatbot.processConversation(chat);
	
	return chatbotSays;
}

private void close()
{
	display.displayText("Goodbye");
	System.exit(0);
}

}

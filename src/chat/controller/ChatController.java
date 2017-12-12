package chat.controller;

import chat.view.*;
import chat.model.*;

public class ChatController<display, PopupDisplay> 
{
private Chatbot chatbot;
private PopupDisplay display;

public ChatController()
{
	chatbot = new Chatbot ("Shujaet Din");
	display = new PopupDisplay();
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
	
	if(chatbot.quitChecker(input))
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

public void useCheckers(String text)
{
	String response = "";
	
	if(chatbot.contentChecker(text))
	{
		response += "This text mathes the special content\n";
	}
if(chatbot.cuteAnimalMemeChecker(text))
{
	response += "";
}
// continue with all 
}
private void close()
{
	display.displayText("Goodbye");
	System.exit(0);
}

}

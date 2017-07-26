package com.epam.lab.gmail.bisnes_layour;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.lab.gmail.GmailTest;
import com.epam.lab.gmail.models.Message;
import com.epam.lab.gmail.pages.GmailMainPage;
import com.epam.lab.gmail.pages.MessageWidget;

public class GmailBO {
	public static Logger logger = Logger.getLogger(GmailTest.class);
	private GmailMainPage mainPage;

	public GmailBO() {
		mainPage = new GmailMainPage();
	}

	public List<Message> getMassageModels() {
		logger.info("getMassages method");
		List<Message> mesageModelList = new ArrayList<>();
		for (MessageWidget messWidget : mainPage.getMessagesWidgets()) {
			mesageModelList.add(getMessage(messWidget));
		}
		return mesageModelList;
	}

	public List<Message> markMessagesAsImportant(int messagesToMurkNumber) {
		logger.info("markMessagesAsImportant method");
		List<Message> messageModelMarkedList = new ArrayList<>();
		int markedMessagesNumber = 0;
		for (MessageWidget messageWidget : mainPage.getMessagesWidgets()) {
			if (messageWidget.isNotImportant()) {
				messageWidget.clickOnImportantMarker();
				markedMessagesNumber++;
				messageModelMarkedList.add(getMessage(messageWidget));
			}
			if (markedMessagesNumber >= messagesToMurkNumber) {
				break;
			}
		}
		return messageModelMarkedList;
	}

	public void openImportantMesssagesList() {
		logger.info("openImportantMesssagesList metod");
		mainPage.navigationMenu().clikOnMore();
		mainPage.navigationMenu().clikOnImportant();
	}

	public void deleteMessages(List<Message> listToDelete) {
		logger.info("deleteMessages method");
		int markedMessagesNumber = 0;
		for (MessageWidget messWidget : mainPage.getMessagesWidgets()) {
			if (listToDelete.contains(getMessage(messWidget))) {
				messWidget.clickOnMarker();
				markedMessagesNumber++;
			}
			if (markedMessagesNumber >= listToDelete.size()) {
				break;
			}
		}
		mainPage.topEditMenu().clickDelete();
	}

	public boolean arePresent(List<Message> messagesList) {
		logger.info("arePresent method");
		List<Message> presentMessagesList = getMassageModels();
		boolean isPresent = false;
		for (Message message : messagesList) {
			isPresent = presentMessagesList.contains(message);
			if (isPresent) {
				break;
			}
		}
		return isPresent;
	}

	private Message getMessage(MessageWidget widget) {
		logger.info("getMessage method");
		return new Message(widget.getSender().trim(), widget.getTopic().trim(), widget.getDate().trim());
	}

}

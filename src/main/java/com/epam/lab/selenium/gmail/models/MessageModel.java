package com.epam.lab.selenium.gmail.models;

public class MessageModel {
	
	private String receiver;
	private String receiverShortened;
	private String subject;
	private String content;
	
	public MessageModel() {
	}
	
	public MessageModel(String receiver, String receiverShortened, String subject, String content) {
		this.receiver = receiver;
		this.receiverShortened = receiverShortened;
		this.subject = subject;
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String to) {
		this.receiver = to;
	}
	
	public String getReceiverShortened() {
		return receiverShortened;
	}
	public void setReceiverShortened(String receiverShortened) {
		this.receiverShortened = receiverShortened;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

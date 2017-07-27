package com.epam.businessobject;

import com.epam.control.Table;
import com.epam.models.MessageModel;
import com.epam.pages.GmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GmailBO{
    private GmailPage gmailPage = new GmailPage();

    public int getCountOfSelectedMessages(){
        return gmailPage.getCountOfSelectedMessages();
    }

    public void deleteSelectedMessages(){
        gmailPage.deleteSelectedMessages();
    }

    public void cancelDeleteMessages(){
        gmailPage.cancelDeleteMessages();
    }

    public String verificationThatMessagesWereNotDeleted(){
        return gmailPage.verificationThatMessagesWereNotDeleted();
    }

    public String getCancelDeleteLinkText(){
        return gmailPage.getCancelDeleteSpan().getText();
    }

    public MessageModel selectMessage(String from, String subject, String date){
        Table table = gmailPage.getTable();
        System.out.println("TABLE !!!!!!!!!!!");
        MessageModel messageModel = new MessageModel();

        WebElement element = table.getCellEditor(from, subject, date);
        System.out.println("WebElement !!!!!!!!!!!");
        if(!element.findElement(By.cssSelector("div.T-Jo-auh")).isSelected()){
            element.findElement(By.cssSelector("div.T-Jo-auh")).click();
            messageModel.setFrom(from);
            messageModel.setSubject(subject);
            messageModel.setDate(date);
        }
        return messageModel;
    }

}

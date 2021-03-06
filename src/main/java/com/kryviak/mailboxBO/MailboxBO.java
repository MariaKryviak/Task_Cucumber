package com.kryviak.mailboxBO;

import com.kryviak.models.MessageModel;
import com.kryviak.pages.mailbox.MailboxPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailboxBO {

    private MailboxPage mailboxPage = new MailboxPage();

    public void sendLetter(MessageModel messageModel) {
        mailboxPage.clickCreateNewLetterButton();
        mailboxPage.setEmailToTextField(messageModel.getEmailTo());
        mailboxPage.setSubjectToTextField(messageModel.getSubjectTo());
        mailboxPage.setMessageToTextField(messageModel.getMessageTo());
        mailboxPage.clickSendMessageButton();
    }

    public void deleteSentLetter(String messageTitle) {
        mailboxPage.clickSentMessageLink();
        mailboxPage.selectMessageByTitle(messageTitle);
        mailboxPage.deleteSelectedMessage();
    }

    public boolean isMessageSent(String msgTitle) {
        List<WebElement> mailTitlesList = new MailboxPage().getMessageTitles();
        mailTitlesList.get(0).isDisplayed();
        boolean isSent = false;
        for (WebElement element : mailTitlesList) {
            if (element.getText().equals(msgTitle)) {
                isSent = true;
                break;
            }
        }
        return isSent;
    }
}

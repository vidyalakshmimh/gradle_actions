package org.sherwin.pages;

import com.aventstack.extentreports.Status;
import org.sherwin.maps.EditJournalMap;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;


import static org.sherwin.utilities.ListenersImplementation.test;


public class EditJournalPage extends BaseTest
{
    EditJournalMap editJournalMap=new EditJournalMap();

    public void addNewJournal() throws InterruptedException {
        BaseCommands.scrollIntoView(editJournalMap.addJournalWithPlusIcon());
        BaseCommands.click(editJournalMap.addJournalWithPlusIcon(),"journal plus icon");
        Thread.sleep(3000);

    }

    public void fillJournalDetails(String JournalAdd,String JournalDescription, String Ledger,String AccountingDate, String Category){
        BaseCommands.sendKeys(editJournalMap.addJournal(),JournalAdd, "Journal");
        BaseCommands.sendKeys(editJournalMap.addDescription(),JournalDescription,"Journal description");
        BaseCommands.click(editJournalMap.addLedger(),"add ledger");
        BaseCommands.click(editJournalMap.selectLedger(Ledger),"ledger");
        BaseCommands.click(editJournalMap.okBtnFromWarningMessage(),"OK");
        BaseCommands.waitForElementInvisible(editJournalMap.okBtnFromWarningMessage());
        BaseCommands.clear(editJournalMap.addAccountingDate());
        BaseCommands.sendKeys(editJournalMap.addAccountingDate(),AccountingDate,"Accounting date");
        BaseCommands.sendKeys(editJournalMap.addCategory(),Category,"Category");
        BaseCommands.enter(editJournalMap.addCategory());

    }

    public void fillJournalLineDetails(String DebitAccount,String DebitAmount,String DebitDescription,String CreditAccount,String CreditAmount,String CreditDescription) throws InterruptedException {
        BaseCommands.click(editJournalMap.journalLine1(),"journal line1");
        sendAccountDetails(DebitAccount);
        BaseCommands.sendKeys(editJournalMap.debitAmount(),DebitAmount,"Debit amount");
        BaseCommands.sendKeys(editJournalMap.debitDescription(),DebitDescription,"Debit description");
        BaseCommands.click(editJournalMap.journalLine2(),"journal line2");
        BaseCommands.click(editJournalMap.fillAccountDetailsJournalLine2(),"fill journal line 2");
        sendAccountDetails(CreditAccount);
        BaseCommands.sendKeys(editJournalMap.creditAmount(),CreditAmount,"Credit amount");
        BaseCommands.sendKeys(editJournalMap.creditDescription(),CreditDescription,"Credit description");
        BaseCommands.scrollIntoView(editJournalMap.postJournal());
        BaseCommands.click(editJournalMap.postJournal(),"post");
        BaseCommands.click(editJournalMap.yesBtn(),"yes");
        BaseCommands.waitForElementInvisible(editJournalMap.yesBtn());
        BaseCommands.addScreenShotInReport("Confirmation Message is:- "+BaseCommands.getText(editJournalMap.getConformationMessage()),"temp1");
        BaseCommands.click(editJournalMap.okBtnConformation(),"OK");
        BaseCommands.waitForElementInvisible(editJournalMap.okBtnConformation());
  }

    public void sendAccountDetails(String accountDetails)  {
        String[] acc = BaseCommands.splitString(accountDetails);
        BaseCommands.click(editJournalMap.accountIcon(),"account icon");
        BaseCommands.waitForVisibilityOfElement(editJournalMap.interCompany());
        BaseCommands.sendKeys(editJournalMap.company(), acc[0],"company");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[0]),"company");
        BaseCommands.sendKeys(editJournalMap.profitCenter(), acc[1],"profit center");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[1]),"profit center");
        BaseCommands.sendKeys(editJournalMap.location(), acc[2],"location");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[2]),"location");
        BaseCommands.sendKeys(editJournalMap.account(), acc[3],"account");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[3]),"account");
        BaseCommands.sendKeys(editJournalMap.department(), acc[4],"department");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[4]),"department");
        BaseCommands.sendKeys(editJournalMap.brand(), acc[5],"brand");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[5]),"brand");
        BaseCommands.sendKeys(editJournalMap.interCompany(), acc[6],"inter company");
        BaseCommands.click(editJournalMap.selectAutoPopulateValue(acc[6]),"inter company");
        BaseCommands.click(editJournalMap.accountSearch(),"search");
        BaseCommands.waitForElementInvisible(editJournalMap.interCompany());
        BaseCommands.click(editJournalMap.accountOkBtn(),"OK");
        BaseCommands.waitForElementInvisible(editJournalMap.accountOkBtn());
    }

}

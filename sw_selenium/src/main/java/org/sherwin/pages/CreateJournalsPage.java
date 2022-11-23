package org.sherwin.pages;

import org.sherwin.maps.CreateJournalMaps;
import org.sherwin.utilities.BaseCommands;
import org.testng.Assert;

public class CreateJournalsPage {
    CreateJournalMaps createJournalMap = new CreateJournalMaps();
    public void sendJournalBatchData(String journalBatch, String journalBatchDescription, String accountinPeriod) throws InterruptedException {
       //Thread.sleep(2000);
        //BaseCommands.waitForPageLoad(createJournalMap.journalBatch());
        BaseCommands.sendKeys(createJournalMap.journalBatch(), journalBatch,"journal batch");
        BaseCommands.sendKeys(createJournalMap.journalBatchDescription(), journalBatchDescription,"journal batch description");
        if (accountinPeriod != "") {
            BaseCommands.click(createJournalMap.accountingPeriod(),"accounting period");
            BaseCommands.click(createJournalMap.accountingPeriodDropdown(accountinPeriod),"accounting period dropdown");
            Thread.sleep(2000);
            if (BaseCommands.isElementDisplayed((createJournalMap.warningOk()))) {
                BaseCommands.click(createJournalMap.warningOk(),"OK");
                BaseCommands.waitForElementInvisible(createJournalMap.warningOk());
            }
        }
    }

    public void sendjournalData(String journal, String journalDesc, String ledger, String legalEntity, String category, String currency) throws InterruptedException {
        BaseCommands.sendKeys(createJournalMap.journal(), journal,"journal");
        BaseCommands.sendKeys(createJournalMap.journalDescription(), journalDesc,"journal description");
        BaseCommands.click(createJournalMap.ledger(),"ledger");
        BaseCommands.click(createJournalMap.ledgerDropDown(ledger),"ledger dropdown");
        Thread.sleep(2000);
        if (BaseCommands.isElementDisplayed((createJournalMap.warningOk()))) {
            BaseCommands.click(createJournalMap.warningOk(),"OK");
            BaseCommands.waitForElementInvisible(createJournalMap.warningOk());
        }

        if(BaseCommands.isElementDisplayed(createJournalMap.legalEntityName()))
        {
            BaseCommands.click(createJournalMap.legalEntityName(),"legal entity");
            BaseCommands.click(createJournalMap.legalEntityNameDropDown(legalEntity),"legal entity drop down");
        }
        BaseCommands.click(createJournalMap.category(),"category");
        BaseCommands.clickUsingJS(createJournalMap.categoryDropDown(category));

        if (currency != "") {
            BaseCommands.clear(createJournalMap.currency());
            BaseCommands.sendAndClick(createJournalMap.currency(),currency);
            BaseCommands.click(createJournalMap.journalKey(),"journal key");
        }


    }

    public void sendJournalLinesData(String debitAccount, String debit, String debitDesc, String creditAccount, String creditAmmount, String creditDesc,String category) throws InterruptedException {
        sendAccountDetails(debitAccount);
        BaseCommands.sendKeys(createJournalMap.debit(), debit,"debit");
        BaseCommands.sendKeys(createJournalMap.debitDesc(), debitDesc,"debit description");
        BaseCommands.click(createJournalMap.newRow(),"add row");
        BaseCommands.click(createJournalMap.secondLine(),"second line");
        sendAccountDetails(creditAccount);
        BaseCommands.sendKeys(createJournalMap.creditAmount(), creditAmmount,"credit amount");
        BaseCommands.sendKeys(createJournalMap.creditDesc(), creditDesc,"credit description");
        BaseCommands.click(createJournalMap.category(),"category");
        BaseCommands.clickUsingJS(createJournalMap.categoryDropDown(category));
        BaseCommands.click(createJournalMap.saveButton(),"save");
        BaseCommands.click(createJournalMap.completeButton(),"complete");
        BaseCommands.staleWait(createJournalMap.postButton());
        BaseCommands.click(createJournalMap.postButton(),"post");
        BaseCommands.click(createJournalMap.okConfirmation(),"OK");
    }

    public void sendAccountDetails(String accountDetails) throws InterruptedException {
        String[] acc= BaseCommands.splitString(accountDetails);
        Thread.sleep(3000);
        BaseCommands.click(createJournalMap.accountSearchIcon(),"search");
        BaseCommands.sendKeys(createJournalMap.company(), acc[0],"company");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[0]),"company");
        BaseCommands.sendKeys(createJournalMap.profitCenter(), acc[1],"profit center");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[1]),"profit center");
        BaseCommands.sendKeys(createJournalMap.location(), acc[2],"location");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[2]),"location");
        BaseCommands.sendKeys(createJournalMap.account(), acc[3],"account");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[3]),"account");
        BaseCommands.sendKeys(createJournalMap.department(), acc[4],"department");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[4]),"department");
        BaseCommands.sendKeys(createJournalMap.brand(), acc[5],"brand");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[5]),"brand");
        BaseCommands.sendKeys(createJournalMap.interCompany(), acc[6],"inter company");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(acc[6]),"inter company");
        BaseCommands.click(createJournalMap.accountSearch(),"search");
        BaseCommands.waitForElementInvisible(createJournalMap.interCompany());
        BaseCommands.click(createJournalMap.accountOk(),"OK");
        BaseCommands.waitForElementInvisible(createJournalMap.accountOk());
    }

//ProcessJournalEntriesSTATCurrency methods
    public void journalLinesRegion(String debitAccount, String debit, String debitDesc) throws InterruptedException {
        sendAccountDetails(debitAccount);
        BaseCommands.click(createJournalMap.debit(),"debit");
        BaseCommands.sendKeys(createJournalMap.debit(), debit,"debit");
        BaseCommands.sendKeys(createJournalMap.debitDesc(), debitDesc,"debit description");
        BaseCommands.click(createJournalMap.newRow(),"add row");
        BaseCommands.waitForVisibilityOfElement(createJournalMap.secondLine());
        BaseCommands.click(createJournalMap.secondLine(),"second line");
        BaseCommands.click(createJournalMap.deleteButton(), "delete");
        BaseCommands.click(createJournalMap.deleteConfirmationButton(),"delete confirmation");
    }
    public void clickPostButton() throws InterruptedException {
        BaseCommands.waitForElementInvisible(createJournalMap.secondLine());
        BaseCommands.click(createJournalMap.postButton(),"post");
        BaseCommands.click(createJournalMap.postConfirmationButton(),"post confirmation");
        BaseCommands.click(createJournalMap.confirmationButton(),"confirmation");
        BaseCommands.waitForElementInvisible(createJournalMap.confirmationButton());

    }

//ProcessJournalEntries methods
    public void createJournal(String journalBatch, String journalBatchDescription,String AccountingPeriod,
                              String journal,String journalDescription, String Ledger, String LegalEntityName,String AccountingDate,String journalCategory,
                              String journalLegalEntityName,String Currency) throws InterruptedException {
        BaseCommands.sendKeys(createJournalMap.journalBatch(),journalBatch,"journal batch");
        BaseCommands.click(createJournalMap.journalBatchDescription(),"journal batch description");
        BaseCommands.sendKeys(createJournalMap.journalBatchDescription(),journalBatchDescription,"journal batch description");
        String Actual_AccountingPeriod = BaseCommands.getElementAttribute(createJournalMap.accountingPeriod(),"value");
        System.out.println("Actual_AccountingPeriod: "+Actual_AccountingPeriod);
        System.out.println("Expected_AccountingPeriod: "+AccountingPeriod);
        Assert.assertEquals(Actual_AccountingPeriod,AccountingPeriod,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_AccountingPeriod+" and expected is: "+AccountingPeriod);
        BaseCommands.sendKeys(createJournalMap.journal(),journal,"journal");
        BaseCommands.sendKeys(createJournalMap.journalDescription(),journalDescription,"journal description");
        String Actual_Ledger = BaseCommands.getElementAttribute(createJournalMap.ledger(),"value");
        System.out.println("Actual_Ledger: "+Actual_Ledger);
        System.out.println("Expected_Ledger: "+ Ledger);
        Assert.assertEquals(Actual_Ledger,Ledger,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_Ledger+" and expected is: "+Ledger);
        BaseCommands.scrollDown();
        String Actual_AccountingDate = BaseCommands.getElementAttribute(createJournalMap.accountingDate(),"value");
        System.out.println("Actual_AccountingPeriod: "+Actual_AccountingDate);
        System.out.println("Expected_AccountingPeriod: "+AccountingDate);
        Assert.assertEquals(Actual_AccountingPeriod,AccountingPeriod,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_AccountingDate+" and expected is: "+AccountingDate);
        BaseCommands.sendKeys(createJournalMap.journalCategory(),journalCategory,"journal category");
        BaseCommands.click(createJournalMap.journalCategoryValue(journalCategory),"journal category");
        String Actual_Currency = BaseCommands.getElementAttribute(createJournalMap.journalCurrency(),"value");
        System.out.println("Actual_Currency: "+Actual_Currency);
        System.out.println("Expected_Currency: "+Currency);
        Assert.assertEquals(Actual_AccountingPeriod,AccountingPeriod,"Actual and expected batch accounting data aren't same. Actual is: "+Actual_AccountingDate+" and expected is: "+Currency);

    }

    public void fillJournalLines(String[] accountSubDetails, String debitValue, String creditValue, String coupaBudgeValue, int counter) throws InterruptedException {
        if (counter == 2) {
            BaseCommands.click(createJournalMap.addRow(),"add row");
        }
        if (counter >= 1) {
            Thread.sleep(3000);
            if (counter == 1)
                BaseCommands.click(createJournalMap.enableJournalLinesTableRow(counter),"journal line");
            else
                BaseCommands.click(createJournalMap.enableJournalLinesTableRow(counter - 1),"journal line");
            Thread.sleep(3000);
        }
        BaseCommands.click(createJournalMap.accountSearchIcon(),"search");
        BaseCommands.sendKeys(createJournalMap.companyAutoPopulateTextBox(), accountSubDetails[0],"company");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[0]),"company");

        BaseCommands.sendKeys(createJournalMap.profitCenterAutoPopulateTextBox(), accountSubDetails[1],"profit center");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[1]),"profit center");

        BaseCommands.sendKeys(createJournalMap.locationAutoPopulateTextBox(), accountSubDetails[2],"location");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[2]),"location");

        BaseCommands.sendKeys(createJournalMap.accountAutoPopulateTextBox(), accountSubDetails[3],"account");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[3]),"account");

        BaseCommands.sendKeys(createJournalMap.departmentAutoPopulateTextBox(), accountSubDetails[4],"department");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[4]),"department");

        BaseCommands.sendKeys(createJournalMap.brandAutoPopulateTextBox(), accountSubDetails[5],"brand");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[5]),"brand");

        BaseCommands.sendKeys(createJournalMap.interCompanyAutoPopulateTextBox(), accountSubDetails[6],"inter company");
        BaseCommands.click(createJournalMap.selectAutoPopulateValue(accountSubDetails[6]),"inter company");

        BaseCommands.click(createJournalMap.okButtonOfAccount(),"OK");
        int debit = Integer.parseInt(debitValue);
        if (debit != 0) {
            Thread.sleep(2000);
            BaseCommands.sendKeys(createJournalMap.debitTextBox(), debitValue,"debit value");
        } else if (debit == 0){
            Thread.sleep(2000);
            BaseCommands.sendKeys(createJournalMap.creditTextBox(),creditValue, "credit value");
        }

        BaseCommands.click(createJournalMap.coupaBudgeDropdown(),"coupa budge dropdown");
        BaseCommands.click(createJournalMap.searchOnDropdownList(),"coupa budge dropdown list");
        BaseCommands.sendKeys(createJournalMap.valueOfSearchAndSelectCoupaScreen(),coupaBudgeValue,"coupa budge");
        BaseCommands.click(createJournalMap.searchButtonOfSearchAndSelectCoupaScreen(),"search");
        BaseCommands.click(createJournalMap.selectValueOnSearchAndSelectCoupaScreen(coupaBudgeValue),"coupa budge value");
        BaseCommands.click(createJournalMap.okButtonOfCoupaBudge(),"OK");
        BaseCommands.waitForElementInvisible(createJournalMap.okButtonOfCoupaBudge());

    }

    public void saveJournalPage() throws InterruptedException {
        BaseCommands.scrollUp();
        BaseCommands.waitForVisibilityOfElement(createJournalMap.saveButton());
        BaseCommands.click(createJournalMap.saveButton(),"save");
    }
}

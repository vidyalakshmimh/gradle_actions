package org.sherwin.pages;

import org.sherwin.maps.ManageJournalMap;
import org.sherwin.utilities.BaseCommands;

public class ManageJournalPage {
    ManageJournalMap manageJournalMap = new ManageJournalMap();
    public void manageJournal(String journalBatch, String path){
        BaseCommands.sendKeys(manageJournalMap.journalBatchId(),journalBatch,"journal batch");
        BaseCommands.clear(manageJournalMap.perioddateId());
        BaseCommands.click(manageJournalMap.searchButtonId(),"search button");
        BaseCommands.click(manageJournalMap.journallinkId(),"link");
        BaseCommands.click(manageJournalMap.attachImgId(),"attach image");
        BaseCommands.dropDownSelectByValue(manageJournalMap.fileTypeId(),"2");
        BaseCommands.click(manageJournalMap.urlfieldId(),"url");
        BaseCommands.sendKeys(manageJournalMap.urlfieldId(),"file:\\\\"+path,"url ");
        BaseCommands.click(manageJournalMap.okButtonId(),"OK");
        BaseCommands.refresh();
        BaseCommands.click(manageJournalMap.saveButton(),"save");
    }
    public void navigateManageJournalPage(String Journal, String accountingPeriod)
    {
        BaseCommands.waitForVisibilityOfElement(manageJournalMap.fillJournalFromData());
        BaseCommands.sendKeys(manageJournalMap.fillJournalFromData(),Journal,"journal");
        BaseCommands.waitForElement(manageJournalMap.clearAccountingPeriod());
        BaseCommands.clear(manageJournalMap.clearAccountingPeriod());
        if(!(accountingPeriod.equalsIgnoreCase("blank"))){
            BaseCommands.sendKeys(manageJournalMap.clearAccountingPeriod(),accountingPeriod,"accounting period");
        }
        BaseCommands.click(manageJournalMap.searchBtn(),"search");
        BaseCommands.waitForElement(manageJournalMap.searchResult(Journal));
        BaseCommands.click(manageJournalMap.searchResult(Journal),"journal");

    }
}

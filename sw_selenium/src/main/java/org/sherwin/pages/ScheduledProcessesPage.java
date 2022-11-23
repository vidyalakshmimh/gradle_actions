package org.sherwin.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.sherwin.maps.ScheduledProcessesMap;
import org.sherwin.utilities.BaseCommands;
import org.testng.Assert;

import java.util.List;

import static org.sherwin.utilities.BaseCommands.takeScreenshot;
import static org.sherwin.utilities.BaseTest.driver;
import static org.sherwin.utilities.ListenersImplementation.test;

public class ScheduledProcessesPage {
    public static String scheduledProcessID;
    static ScheduledProcessesMap scheduledProcessesMap = new ScheduledProcessesMap();

    public static void viewScheduledProcessPage() {
        BaseCommands.findElement(scheduledProcessesMap.scheduledProcessOverview());
        BaseCommands.findElement(scheduledProcessesMap.scheduledProcessSearchResults());
        BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton(),"refresh");
    }

    public static void viewAllGenProcessState() throws InterruptedException {
        BaseCommands.findElement(scheduledProcessesMap.genAllProcessID());
        String status = BaseCommands.getText(scheduledProcessesMap.genAllProcessStatus());
        while (!(status.equals("Succeeded"))) {
            BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton(),"refresh");
            Thread.sleep(3000);
            try {
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                WebElement elem = driver.findElement(scheduledProcessesMap.genAllProcessID());
                executor.executeScript("arguments[0].scrollIntoView()", elem);
            }
            catch (Exception e){
                String temp = takeScreenshot(driver);
                test.fail("ScrollIntoView on the element failed " + e, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
                Assert.fail();            }
            status = BaseCommands.getText(scheduledProcessesMap.genAllProcessStatus());
            if (status.equals("Error")||status.equals("Blocked")) {
                String temp = takeScreenshot(driver);
                test.fail("Process failed to generate allocations", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
                Assert.fail();
            }
        }
        BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton(),"refresh");
        String ledgerBalanceStatus = BaseCommands.getText(scheduledProcessesMap.genLedgerAllocationProcessStatus());
        test.info("Allocate general ledger balance process status is " + ledgerBalanceStatus);
        test.info("Generate allocation process status is " + status);
    }

    public  static void viewAllGenLedgerProcessParentID(){
        BaseCommands.scrollToCenter(scheduledProcessesMap.genLedgerAllocationProcessId());
        String ledgerBalanceProcessID = BaseCommands.getText(scheduledProcessesMap.genLedgerAllocationProcessId());
        BaseCommands.addScreenShotInReport("Allocate general ledger balance process ID is " + ledgerBalanceProcessID,"temp");
       // BaseCommands.refresh();
        BaseCommands.click(scheduledProcessesMap.genLedgerAllocationProcessId(),"general ledger allocation process ID");
        BaseCommands.findElement(scheduledProcessesMap.parentIDValue());
    }

    public static void scheduleNewProcesses(String Name) {
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcesses(),"schedule new processes");
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchDropdown(),"search dropdown");
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchButton(),"search button");
        BaseCommands.sendKeys(scheduledProcessesMap.scheduledNewProcessesSearchName(), Name,"process name");
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResultButton(),"search result");
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResult(Name),"result name");
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResultOKButton(),"OK");
        BaseCommands.click(scheduledProcessesMap.scheduledNewProcessesSearchResultOKConfirmButton(),"Confirm");
    }

    public static void fillScheduleNewProcessDetails(String DataAccessSet, String Ledger, String LedgerCurrency, String CurrencyType, String AccountingPeriod, String AmountType, String SummarizeBy){
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillDataAccessSet(),DataAccessSet);
        BaseCommands.clear(scheduledProcessesMap.fillLedger());
        BaseCommands.sendKeys(scheduledProcessesMap.fillLedger(),Ledger,"ledger name");
        BaseCommands.sendKeys(scheduledProcessesMap.fillLedgerCurrency(),LedgerCurrency,"ledger currency");
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillCurrencyType(),CurrencyType);
        BaseCommands.clear(scheduledProcessesMap.fillAccountingPeriod());
        BaseCommands.sendKeys(scheduledProcessesMap.fillAccountingPeriod(),AccountingPeriod,"accounting period");
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillAmountType(),AmountType);
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.fillSummarizeBy(),SummarizeBy);
    }

    public static void scheduleNewProcessedAdvanced(String Format){
        BaseCommands.click(scheduledProcessesMap.processDetailsAdvanced(),"advanced");
        BaseCommands.click(scheduledProcessesMap.processDetailsAdvancedOutput(),"output");
        BaseCommands.click(scheduledProcessesMap.processDetailsOutputAddButton(),"add button");
        BaseCommands.dropDownSelectByText(scheduledProcessesMap.outputFormatDropdown(),Format);
    }

    public static void scheduleNewProcessSubmit(){
        BaseCommands.click(scheduledProcessesMap.scheduleProcessSubmit(), "submit");
        BaseCommands.findElement(scheduledProcessesMap.scheduleProcessConfirmPopUp());
        String ActualConfirmationMsg=BaseCommands.getText(scheduledProcessesMap.scheduleProcessConfirmDialogue());
        scheduledProcessID = ActualConfirmationMsg.substring(8, 15);
        String ExpectedConfirmationMsg= "Process " + scheduledProcessID +" was submitted.";
        BaseCommands.AssertEquals(ExpectedConfirmationMsg, ActualConfirmationMsg);
        BaseCommands.addScreenShotInReport("Submitted scheduled process ID is " +scheduledProcessID,"temp");
        BaseCommands.click(scheduledProcessesMap.scheduleProcessConfirmOKButton(),"OK");
        BaseCommands.waitForElementInvisible(scheduledProcessesMap.scheduleProcessConfirmOKButton());
    }

    public static void viewTrialBalanceReportStatus() throws InterruptedException {
            BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton(),"refresh");
            BaseCommands.findElement(scheduledProcessesMap.trialBalanceReportProcessId());
        String trialBalanceReportStatus=BaseCommands.getText(scheduledProcessesMap.trialBalanceReportProcessStatus());
        while (!(trialBalanceReportStatus.equals("Succeeded"))) {
            BaseCommands.click(scheduledProcessesMap.scheduledProcessRefreshButton(),"refresh");
            Thread.sleep(2000);
                BaseCommands.scroll(scheduledProcessesMap.trialBalanceReportProcessId());
            trialBalanceReportStatus = BaseCommands.getText(scheduledProcessesMap.trialBalanceReportProcessStatus());
            if (trialBalanceReportStatus.equals("Error")||trialBalanceReportStatus.equals("Blocked")) {
                String temp = takeScreenshot(driver);
                test.fail("Process failed to generate trial balance report", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
                Assert.fail();
            }
        }
    }

    public static void downloadTrialBalanceReport() {
        BaseCommands.click(scheduledProcessesMap.trialBalanceReportProcessId(),"trial balance report process ID");
        BaseCommands.switchToFrame(scheduledProcessesMap.trialBalanceReportFrame());
        BaseCommands.scrollToCenter(scheduledProcessesMap.trialBalanceReportOutput());
        BaseCommands.click(scheduledProcessesMap.trialBalanceReportOutput(),"trial balance report output");
        BaseCommands.addScreenShotInReport("output file is a hyperlink","temp");
        BaseCommands.switchBackFromFrame();
    }
}

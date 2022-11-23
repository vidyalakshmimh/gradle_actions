package org.sherwin.pages;

import org.sherwin.maps.ScheduleReportJobMap;
import org.sherwin.utilities.BaseCommands;

public class ScheduleReportJobPage {
    static ScheduleReportJobMap scheduleReportJobMap= new ScheduleReportJobMap();

    public void fillAndSubmitRevaluationReport(String LedgerSet,String AccountingPeriod, String LedgerName, String BalancingSegment, String LedgerCurrency, String AccountLevel) throws InterruptedException {
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportJobIframe());
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportGenIframe());
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerSetDropdown(),"ledger set dropdown");
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerSet(LedgerSet),"ledger set");
        Thread.sleep(2000);
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccPeriodDropdown(),"accounting period dropdown");
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccPeriod(AccountingPeriod),"accounting period");
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerNameDropdown(),"ledger drop down");
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerName(LedgerName),"ledger name");
        Thread.sleep(2000);
        BaseCommands.click(scheduleReportJobMap.scheduleReportBalSegmentDropdown(),"balance segment drop down");
        BaseCommands.click(scheduleReportJobMap.scheduleReportBalancingSegment(BalancingSegment),"balancing segment");
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerCurrencyDropdown(),"ledger currency dropdown");
        BaseCommands.click(scheduleReportJobMap.scheduleReportLedgerCurrency(LedgerCurrency),"ledger currency");
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccLevelDropdown(),"accounting level dropdown");
        BaseCommands.click(scheduleReportJobMap.scheduleReportAccLevel(AccountLevel),"account level");
        BaseCommands.switchBackFromFrame();
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportJobIframe());
        BaseCommands.click(scheduleReportJobMap.scheduleReportSubmitBtn(),"submit");
        BaseCommands.findElement(scheduleReportJobMap.scheduleReportVerifyParams(LedgerSet, LedgerName, LedgerCurrency, AccountingPeriod, AccountLevel,BalancingSegment));
        BaseCommands.sendKeys(scheduleReportJobMap.scheduleReportJobName(),"Job123","Job name");
        BaseCommands.click(scheduleReportJobMap.scheduleReportVerifyOKBtn(),"OK");
        BaseCommands.switchBackFromFrame();
    }
    public void confirmAlertAndReturn() throws InterruptedException {
        BaseCommands.waitForAlert();
        BaseCommands.switchToAlertAccept();
        BaseCommands.switchToFrame(scheduleReportJobMap.scheduleReportJobIframe());
        BaseCommands.click(scheduleReportJobMap.scheduleReportReturn(),"return");
        Thread.sleep(10000);

    }
}

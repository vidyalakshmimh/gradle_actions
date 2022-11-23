package org.sherwin.pages;

import org.sherwin.maps.AnalyticsCatalogMap;
import org.sherwin.utilities.BaseCommands;

public class AnalyticsCatalogPage {
    AnalyticsCatalogMap analyticsCatalogMap=new AnalyticsCatalogMap();

    public void viewGenLedgerReport(){
        BaseCommands.switchToNewTab();
        BaseCommands.click(analyticsCatalogMap.folderSharedFolder(),"shared folder");
        BaseCommands.click(analyticsCatalogMap.sharedFolderCustom(),"custom");
        BaseCommands.click(analyticsCatalogMap.sharedFolderSWCustom(),"SW custom");
        BaseCommands.click(analyticsCatalogMap.sharedFolderFinancials(),"financials");
        BaseCommands.click(analyticsCatalogMap.sharedFolderGenLedger(),"general ledger");
        BaseCommands.click(analyticsCatalogMap.sharedFolderTrailBalance(),"trail balance");
        BaseCommands.click(analyticsCatalogMap.sharedFolderTrialRevaluationReport(),"trial revaluation report");
        BaseCommands.click(analyticsCatalogMap.sharedFolderReportSchedule(),"schedule");

    }


}

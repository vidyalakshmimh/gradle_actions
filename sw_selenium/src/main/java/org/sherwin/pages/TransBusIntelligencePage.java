package org.sherwin.pages;

import org.sherwin.maps.TransBusIntelligenceMap;
import org.sherwin.utilities.BaseCommands;

public class TransBusIntelligencePage {
    TransBusIntelligenceMap transBusIntelligenceMap=new TransBusIntelligenceMap();

    public void navigateToSWCRevaluationReport(){
        BaseCommands.click(transBusIntelligenceMap.SWCTrialBalReport(),"Trial balance report");
        BaseCommands.click(transBusIntelligenceMap.SWCTrialBalReportMore(),"More");
        BaseCommands.click(transBusIntelligenceMap.SWCTrialBalReportMoreHistory(),"History");
    }
}

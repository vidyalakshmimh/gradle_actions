package org.sherwin.pages;

import org.sherwin.maps.GenerateAllocationsMap;
import org.sherwin.utilities.BaseCommands;

import static org.sherwin.utilities.ListenersImplementation.test;

public class GenerateAllocationsPage {
    public static String processID;
    static GenerateAllocationsMap generateAllocationsMap=new GenerateAllocationsMap();
    public static void fillAndSubmitGenAllBasicOptions( String Rule,String JournalCategory,
                                                        String AccountingPeriod,String ConversionRateType){
        BaseCommands.findElement(generateAllocationsMap.genAllocationsHeader());
        BaseCommands.clear(generateAllocationsMap.genAllocationsRuleSet());
        BaseCommands.sendKeys(generateAllocationsMap.genAllocationsRuleSet(), Rule,"rule set");
        BaseCommands.clear(generateAllocationsMap.genAllocationsAccPeriod());
        BaseCommands.sendKeys(generateAllocationsMap.genAllocationsAccPeriod(),AccountingPeriod,"accounting period");
        BaseCommands.clear(generateAllocationsMap.genAllocationsJournalCategory());
        BaseCommands.sendKeys(generateAllocationsMap.genAllocationsJournalCategory(),JournalCategory,"journal category");
        BaseCommands.clear(generateAllocationsMap.genAllocationsConvRateType());
        BaseCommands.sendKeys(generateAllocationsMap.genAllocationsConvRateType(),ConversionRateType,"conversion rate type" );
        BaseCommands.checkBoxChecked(generateAllocationsMap.genAllocationsPostAllocations());
        BaseCommands.click(generateAllocationsMap.genAllocationsSubmit(),"submit");
    }
    public static void confirmProcessAllPopUp(){
        BaseCommands.findElement(generateAllocationsMap.genAllocationsConfirm());
        BaseCommands.findElement(generateAllocationsMap.genAllocationsConfirmDialogue());
        String ActualConfirmationMsg=BaseCommands.getText(generateAllocationsMap.genAllocationsConfirmDialogue());
        processID =ActualConfirmationMsg.substring(8,15);
        String ExpectedConfirmationMsg= "Process " + processID +" was submitted.";
        BaseCommands.addScreenShotInReport("Generate allocation process ID is " + processID,"temp");
        BaseCommands.AssertEquals(ExpectedConfirmationMsg, ActualConfirmationMsg);
        BaseCommands.click(generateAllocationsMap.genAllocationsConfirmOKButton(),"OK");
        BaseCommands.waitForElementInvisible(generateAllocationsMap.genAllocationsConfirmOKButton());

    }
}

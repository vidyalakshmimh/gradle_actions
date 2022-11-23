package org.sherwin.pages;

import org.sherwin.maps.HomePageMap;
import org.sherwin.utilities.BaseCommands;


public class HomePage
{
    HomePageMap homePageMap=new HomePageMap();

    public void openJournal(){
        BaseCommands.click(homePageMap.navBar(),"navigation bar");
        BaseCommands.click(homePageMap.generalAccountingFromNavigator(),"general accounting");
        BaseCommands.click(homePageMap.generalAccountingJournals(),"journals");
    }

    public void navigateToPeriodCloseFromHomePage()
    {
        BaseCommands.click(homePageMap.clickOnArrow(),"arrow");
        BaseCommands.click(homePageMap.generalAccounting(),"general accounting");
        BaseCommands.waitForVisibilityOfElement(homePageMap.periodClose());
        BaseCommands.click(homePageMap.periodClose(),"period close");
    }
    public void navigateToScheduledProcesses(){
        BaseCommands.click(homePageMap.navBar(),"navigation bar");
        BaseCommands.click(homePageMap.tools(),"tools");
        BaseCommands.click(homePageMap.scheduledProcesses(),"schedule processes");
    }

    public void navigateToReportAndAnalytics(){
        BaseCommands.click(homePageMap.navBar(),"navigation bar");
        BaseCommands.click(homePageMap.tools(),"tools");
        BaseCommands.click(homePageMap.reportAndAnalytics(),"report and analytics");
    }

}

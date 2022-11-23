package org.sherwin.pages;

import org.sherwin.maps.PeriodCloseMap;
import org.sherwin.utilities.BaseCommands;

import static org.sherwin.utilities.BaseTest.driver;

public class PeriodClosePage
{

    PeriodCloseMap SW_periodClose=new PeriodCloseMap();

    public void changeDataAccessInPeriodPage(String selectDataAccessSet)
    {
        BaseCommands.click(SW_periodClose.verifyDataAccess(), "data access");
        BaseCommands.dropDownSelectByText(SW_periodClose.selectDataAccessSetFromFile(),selectDataAccessSet);
        BaseCommands.click(SW_periodClose.okBtnFromDataAccessSet(),"OK");

    }


    public void navigateToMenageAccountPeriod()
    {
        driver.navigate().refresh();
        BaseCommands.waitForVisibilityOfElement(SW_periodClose.taskIconPeriodClose());
        BaseCommands.click(SW_periodClose.taskIconPeriodClose(),"task");
        BaseCommands.click(SW_periodClose.linkManageAccountingPeriod(),"manage accounting period");
    }

}

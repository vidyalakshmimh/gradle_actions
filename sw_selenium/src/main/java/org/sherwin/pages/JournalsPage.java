package org.sherwin.pages;


import org.sherwin.maps.JournalsMap;
import org.sherwin.utilities.BaseCommands;

import static org.sherwin.utilities.BaseTest.driver;

public class JournalsPage {
    JournalsMap journalsmap = new JournalsMap();
    public void journals(String DataAcessSet){
        BaseCommands.click(journalsmap.changeId(),"data access set change");
        BaseCommands.dropDownSelectByText(journalsmap.dataAcessSetId(),DataAcessSet);
        BaseCommands.click(journalsmap.clickOkId(),"OK");
        BaseCommands.refresh();
        BaseCommands.click(journalsmap.taskIconId(),"task");
    }

    public void navigateToGenAllocation(){
        BaseCommands.click(journalsmap.genAllocations(),"general allocation");
    }


    public void changeDataAccessSet(String SelectDataAccessSet){
        BaseCommands.click(journalsmap.changeDataAccessSet(),"data access set");
        BaseCommands.waitForElement(journalsmap.dataAccessSet());
        BaseCommands.dropDownSelectByText(journalsmap.dataAccessSet(),SelectDataAccessSet);
        BaseCommands.click(journalsmap.dataAccessSetOk(),"OK");
    }

    public void navigateToManageJournal()
    {
        BaseCommands.refresh();
        BaseCommands.click(journalsmap.task(),"task");
        BaseCommands.click(journalsmap.manageJournal(),"manage journal");
    }

    public void navigateToCreateJournal()
    {
        BaseCommands.refresh();
        BaseCommands.click(journalsmap.task(),"task");
        BaseCommands.click(journalsmap.createJournal(),"create journal");
        BaseCommands.click(journalsmap.resizePaneButton(),"resize pane");
    }

}

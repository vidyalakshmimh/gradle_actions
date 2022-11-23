package org.sherwin.pages;

import org.sherwin.maps.NavBarMap;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;
import org.testng.Assert;

public class NavBarPage extends BaseTest {

    NavBarMap navbarMap= new NavBarMap();
    public void navigateToJournalsViaNavigator()  {
        BaseCommands.click(navbarMap.navigatorIcon(),"navigator");
        BaseCommands.click(navbarMap.navBar(),"navigation bar");
        BaseCommands.scrollIntoView(navbarMap.generalAccounting());
        BaseCommands.click(navbarMap.generalAccounting(),"general accounting");
        BaseCommands.click(navbarMap.generalAccountingJournals(),"journals");
        BaseCommands.assertTitle("Oracle Fusion Cloud Applications");
    }


}

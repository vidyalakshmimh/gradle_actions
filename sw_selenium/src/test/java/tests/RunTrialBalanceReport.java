package tests;

import org.sherwin.pages.*;
import org.sherwin.utilities.BaseCommands;
import org.sherwin.utilities.BaseTest;
import org.sherwin.utilities.ExcelDataProvider;
import org.sherwin.utilities.ReadProperty;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class RunTrialBalanceReport extends BaseTest{
    private static ReadProperty readProperty = new ReadProperty();
    public static final String testDataExcel=readProperty.readProperties("testDataPath");
    public static final String URL = readProperty.readProperties("SWUrl");

    static LoginPage loginPage=new LoginPage();
    static HomePage homePage = new HomePage();
    ScheduledProcessesPage scheduledProcessesPage=new ScheduledProcessesPage();

    static ExcelDataProvider excelDataProvider = new ExcelDataProvider();

    @DataProvider(name="runTrailBalanceReport")
    public  Object[][] getData() {
        Map<Integer, Map<String, String>> runTrailBalanceReportData = excelDataProvider.excelDataMap(testDataExcel+ "\\RunTrialBalanceReport_Input.xlsx","Data");
        return new Object[][] {{runTrailBalanceReportData}};
    }

    @Test(dataProvider ="runTrailBalanceReport")
    public void  runTrailBalanceReport(Map<Integer, Map<String, String>> data) throws InterruptedException {
        BaseCommands.getURL(URL);
        loginPage.loginToGL(data.get(1).get("Username"),data.get(1).get("password"));
        homePage.navigateToScheduledProcesses();
        scheduledProcessesPage.scheduleNewProcesses(data.get(1).get("Name"));
        scheduledProcessesPage.fillScheduleNewProcessDetails(data.get(1).get("DataAccessSet"),data.get(1).get("Ledger"),data.get(1).get("LedgerCurrency"),data.get(1).get("CurrencyType"),data.get(1).get("AccountingPeriod"),data.get(1).get("AmountType"),data.get(1).get("SummarizeBy"));
        scheduledProcessesPage.scheduleNewProcessedAdvanced(data.get(1).get("Format"));
        scheduledProcessesPage.scheduleNewProcessSubmit();
        scheduledProcessesPage.viewTrialBalanceReportStatus();
        scheduledProcessesPage.downloadTrialBalanceReport();
        loginPage.logoutFromUserProfile();
    }
}

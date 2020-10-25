import com.jauntium.Browser;
import com.jauntium.Element;
import com.jauntium.NotFound;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class ReadFromCSL {

    private static final String URL = "https://cstarleague.com/league/114";
    private static final int WAIT_TIME = 6000;
    private static final String TABLE_IDENTIFITER = "<table class=\"css-11psm1x\">";

    public static void main(String[] args) throws InterruptedException, NotFound {
        System.setProperty("webdriver.chrome.driver", Private.PATH_TO_DRIVER);
        Browser browser = new Browser(new ChromeDriver());
        browser.visit(URL);
        Thread.sleep(WAIT_TIME);
        Element table = browser.doc.findFirst(TABLE_IDENTIFITER);
        String tableString = table.getText();
        browser.quit();

        Scanner sc = new Scanner(tableString);
        ArrayList<Team> teams = new ArrayList<>();
        HashMap<String, LinkedList<Team>> conferences = new HashMap<>();
        Utils.getSortedTeams(sc, teams, conferences);

        StringBuilder sb = new StringBuilder();

        for(LinkedList<Team> conference : conferences.values()){
            sb.append(Utils.getConferenceStandings(conference.get(0).conference, conferences));
        }

        System.out.println(sb.toString());


    }
}

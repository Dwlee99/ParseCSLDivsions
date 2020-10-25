import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromTxt {

    private static final String FILE_NAME = "raw.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(FILE_NAME));
        ArrayList<Team> teams = new ArrayList<>();
        HashMap<String, LinkedList<Team>> conferences = new HashMap<>();
        Utils.getSortedTeams(sc, teams, conferences);
    }

}

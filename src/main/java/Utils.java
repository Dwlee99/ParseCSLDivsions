import java.util.*;

public class Utils {

    private static final int EXTRA_LINES = 5;

    /**
     * Sorts the teams and puts them into their proper conferences.
     * @param sc - scanner containing the raw text to be processed
     * @param teams - a non-null array list that will contain all the teams
     * @param conferences - a non-null hashmap that will contain a list of teams for each conference
     */
    public static void getSortedTeams(Scanner sc, ArrayList<Team> teams, HashMap<String,
                LinkedList<Team>> conferences){
        teams.clear();
        conferences.clear();

        for(int i = 0; i < EXTRA_LINES; i++){
            sc.nextLine();
        }
        do{
            sc.nextLine();
            teams.add(new Team(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
        } while(sc.hasNextLine());

        Collections.sort(teams);
        String conference = "";
        for (Team t : teams) {
            if (!t.conference.equals(conference)) {
                conference = t.conference;
                conferences.put(conference, new LinkedList<>());
            }
            conferences.get(conference).add(t);
        }
    }

    private static final String LINE = "—————————————————————\n";

    /**
     * @param conference - a String representing the name of the conference we want to get
     * @param conferences - a HashMap containing a list of teams in each conference
     * @return a StringBuilder containing the conference and its standings (assuming the list in conferences was sorted)
     */
    public static StringBuilder getConferenceStandings(String conference,
                                                       HashMap<String, LinkedList<Team>> conferences){
        LinkedList<Team> teams = conferences.get(conference.toUpperCase());
        if(teams == null){
            return new StringBuilder();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(conference).append("\n").append(LINE);
        for (int i = 0; i < teams.size(); i++){
            Team t;
            sb.append(i + 1).append(". ").append((t = teams.get(i)).university).append(" — ").append(t.name).
                    append(" (").append(t.wins).append(" - ").append(t.losses).append(")\n");
        }
        sb.append(LINE);
        return sb;
    }
}



//"123456789" + "123456789"
//"123456789123456789"
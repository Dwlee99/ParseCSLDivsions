public class Team implements Comparable<Team>{

    String name;
    String university;
    String conference;
    int wins;
    int losses;

    public Team(String n, String u, String c, String standing){
        name = n;
        university = u;
        conference = c;
        int end;
        wins = Integer.parseInt(standing.substring(0, (end = standing.indexOf(" "))));
        losses = Integer.parseInt(standing.substring(end + 3));
    }

    @Override
    public int compareTo(Team o) {
        int c;
        if((c = conference.compareTo(o.conference)) != 0){
            return c;
        }
        else if((c = Integer.compare(wins, o.wins)) != 0){
            return -c;
        }
        else if((c = Integer.compare(losses, o.losses)) != 0) {
            return c;
        } else {
            return university.compareTo(o.university);
        }
    }
}
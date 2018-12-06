import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class input {
	Season test = new Season();
	String team1, team2;
	
	public void readfile() throws ParseException{
		test.readGames("season_05_19.txt");
	}
	
	public String getTeams() {
		ArrayList<String> teams = test.listTeams();
		System.out.println(teams);
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Team Name: ");
		String team = s.nextLine();
		boolean b = false;
			for(int i = 0; i < teams.size(); i++) {
				String tempteam = teams.get(i);
				System.out.println(tempteam);
				System.out.println(team);
				if(tempteam.equalsIgnoreCase(team)) {
					b = true;
				}
				if(b) {
					break;
				}
			}
			if(!b) {
				System.out.println("That is not a valid team name");
				return getTeams();
			}
			
		return team;
		}
	public void head2head() {
		Scanner n = new Scanner(System.in);
		System.out.println("The Head to Head method requires two teams, enter anything to continue or q to quit to main menu");
		String value = n.next();
		if(value.equals("q") || value.equals("Q")) {
			return;
		}
		team1 = getTeams();
		team2 = getTeams();
		System.out.println(test.head2Head(team1, team2));

	}

	public static void main(String[] args) {
		

	}
}

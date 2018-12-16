import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class input {
	Season test = new Season();
	String team1, team2;
	
	public void readfile() throws ParseException{
		test.readGames("season_05_19_champs.txt");
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
		System.out.println("The Head to Head method requires two teams,enter two team names or q to quit to main menu");
		team1 = getTeams();
		team2 = getTeams();
		System.out.println(test.head2Head(team1, team2));

	}
	
	public void dates() throws ParseException {
		Date start, end;
		
		Scanner s = new Scanner(System.in);
		System.out.println("The Dates method takes in two dates, a start and an end, please enter dates as dd/mm/yy");
		System.out.println("Enter start date");
			start = test.castDate(s.next());
		System.out.println("Enter end date");
			end = test.castDate(s.next());
			
		ArrayList<Games> games = test.findGames(start, end);
		for(int i = 0; i < games.size(); i++) {
			System.out.println(games.get(i));
		}
		
		
	}

	public static void main(String[] args) {
		

	}
}

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Season{
	public ArrayList<Games> games = new ArrayList<>();
	

	public void addGame(Games g) {
		games.add(g);
	}
	
	
	public void readGames(String filename) throws ParseException {
		File f = new File(filename);
		Scanner s;
		try {
			s = new Scanner(f);
			while(s.hasNextLine()) {
				String gameString = s.nextLine();
				processLine(gameString);
			}
			s.close();
		} catch(IOException ex) {
			System.err.println(ex);
			System.exit(-1);
		}
	}
	
	private void processLine(String gameString) throws ParseException{
		Scanner s = new Scanner(gameString);
		s.useDelimiter(",");
		String date = s.next(); 
		Date date1 = castDate(date);
		String hTeam = s.next(), aTeam = s.next();
		int hGoals = s.nextInt(), aGoals = s.nextInt();
		char result = s.next().charAt(0);
		int hShots = s.nextInt(), aShots = s.nextInt(), hShotsTarget = s.nextInt(), aShotsTarget = s.nextInt();
		addGame(new Games(date1, hTeam, aTeam, hGoals, aGoals, result, hShots, aShots, hShotsTarget, aShotsTarget));
		s.close();
		
	}
	
	private Date castDate(String date) throws ParseException {
		Date date1;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		date1 = formatter.parse(date);
		return date1;
	}
	
	public String toString() {
		return "All La Liga games in 17/18:\n" + games.toString();
	}
	
	public String findGames(Date start, Date end) {
		return start + " " + end;
	}
	
	

	
	public static void main(String[] args) throws ParseException {
		
		Season season_17_18 = new Season();
		season_17_18.readGames("6.txt");
		
		
		double totalGoals = 0;
		double totalShots = 0;
		double shotsOnTarget = 0;
		for(int i = 0; i < season_17_18.games.size(); i++) {
			totalGoals += season_17_18.games.get(i).aGoals + season_17_18.games.get(i).hGoals;
			totalShots += season_17_18.games.get(i).aShots + season_17_18.games.get(i).hShots;
			shotsOnTarget += season_17_18.games.get(i).aShotsTarget + season_17_18.games.get(i).hShotsTarget;
		}
		double goalsPerGame = (totalGoals / season_17_18.games.size());
		double shotsPerGoal = (totalShots/totalGoals);
		double shotsonTperGoal = (shotsOnTarget/totalGoals);
		System.out.printf("Total number of Goals scored in the 17/18 Season is %.0f\n", totalGoals);
		System.out.printf("Total number of Shots in the 17/18 Season is %.0f\n", totalShots);
		System.out.printf("Total number of Shots on target in the 17/18 Season is %.0f\n", shotsOnTarget);
		System.out.printf("There were %.3f goals per game\n", goalsPerGame);
		System.out.printf("There were %.3f shots per goal\n", shotsPerGoal);
		System.out.printf("There were %.3f shots on target per goal\n", shotsonTperGoal);
		
		/*System.out.println(season_17_18);
		
		Date start = Games.createDate("19-08-17");
		Date end = Games.createDate("23-12-17");
		System.out.println("Start date: " + start.toString());
		System.out.println("End date: " + end.toString());
		System.out.println(season_17_18.findGames(start, end));*/
		
		
	
		
		
		

	}

}

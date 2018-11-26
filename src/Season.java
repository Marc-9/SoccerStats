import java.io.*;
import java.util.*;
import java.text.*;

// Creates an ArrayList of the Constructor Games
public class Season{
	public ArrayList<Games> Season = new ArrayList<>();
	
	public Season() {
		
	}
	
	public Season(Date start, Date end) {
		
	}
	
// Adds games to the Array List
	public void addGame(Games g) {
		Season.add(g);
	}
	
// This method reads the file provided to add to the ArrayList	
	public void readGames(String filename) throws ParseException {
		File f = new File(filename);
		Scanner s;
		try {
			s = new Scanner(f);
			while(s.hasNextLine()) {
				String gameString = s.nextLine();
				// A small helper method I wrote to reduce clutter
				processLine(gameString);
			}
			s.close();
		} catch(IOException ex) {
			System.err.println(ex);
			System.exit(-1);
		}
	}
	
// Its important this method is separate, as this will need to be changed to fir your data set
	private void processLine(String gameString) throws ParseException{
		Scanner s = new Scanner(gameString);
		s.useDelimiter(",");
		String div = s.next();
		String date = s.next(); 
		Date date1 = castDate(date);
		String hTeam = s.next(), aTeam = s.next();
		int hGoals = s.nextInt(), aGoals = s.nextInt();
		char result = s.next().charAt(0);
		int htHGoals = s.nextInt(), htAGoals = s.nextInt();
		char htResult = s.next().charAt(0);
		String referee = s.next();
		int hShots = s.nextInt(), aShots = s.nextInt(), hShotsTarget = s.nextInt(), aShotsTarget = s.nextInt(), hFouls = s.nextInt(), aFouls = s.nextInt();
		int hCorners = s.nextInt(), aCorners = s.nextInt(), hYellows = s.nextInt(), aYellows = s.nextInt(), hRed = s.nextInt(), aRed = s.nextInt();
		addGame(new Games(div, date1, hTeam, aTeam, hGoals, aGoals, result, htHGoals, htAGoals, htResult, referee, hShots, aShots, hShotsTarget, aShotsTarget, hFouls, aFouls, hCorners, aCorners, hYellows, aYellows, hRed, aRed));
		s.close();
		
	}
	
// Casts String to Date to be put into the Constructor	
	private Date castDate(String date) throws ParseException {
		Date date1;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		date1 = formatter.parse(date);
		return date1;
	}
	
// To String that just adds a small string before it calls the ToString method in Games.java
	public String toString() {
		return "All La Liga games in 17/18:\n" + Season.toString();
	}
	
	
// Another in progress method to findgames within the Interval
	public String findGames(Date start, Date end) {
		return start + " " + end;
	}
	
	public ArrayList<String> listTeams(){
		ArrayList<String> temp = new ArrayList<>();
		for(int i = 0; i < Season.size(); i++) {
			temp.add(Season.get(i).hTeam);
		}
		for (int i = 0; i < temp.size(); i++) {
			for(int j = i+1; j < temp.size(); j++) {
				if(temp.get(i).equals(temp.get(j))) {
					temp.remove(j);
					j--;
				}
		}
		}
		return temp;
	}
	
	public ArrayList<Games> head2Head(String Team1, String Team2){
		ArrayList<Games> temp = new ArrayList<>();
		for(int i = 0; i < Season.size(); i++) {
			if((Season.get(i).hTeam.equals(Team1) && Season.get(i).aTeam.equals(Team2)) || (Season.get(i).hTeam.equals(Team2) && Season.get(i).aTeam.equals(Team1))) {
				temp.add(Season.get(i));
			}
		}
		int team1Goals, team2Goals, totGoals;
		ArrayList<Integer> goals = h2hGoals(temp, Team1, Team2);
		team1Goals = goals.get(0); team2Goals = goals.get(1); totGoals = goals.get(2);
		int team1hWins, team1hDraws, team1hLosses, team1aWins, team1aDraws, team1aLosses;
		int team2hWins, team2hDraws, team2hLosses, team2aWins, team2aDraws, team2aLosses;
		int team1totWins, team1totDraws, team1totLosses;
		int team2totWins, team2totDraws, team2totLosses;
		ArrayList<Integer> record = h2hRecord(temp, Team1, Team2);
		team1hWins = record.get(0); team1aWins = record.get(1); team1hDraws = record.get(2); team1aDraws = record.get(3); team1hLosses = record.get(4); team1aLosses = record.get(5); team1totWins = record.get(6); team1totDraws = record.get(7); team1totLosses = record.get(8);
		team2hWins = record.get(9); team2aWins = record.get(10); team2hDraws = record.get(11); team2aDraws = record.get(12); team2hLosses = record.get(13); team2aLosses = record.get(14); team2totWins = record.get(15); team2totDraws = record.get(16); team2totLosses = record.get(17);
		
		
		System.out.println("" + Team1 + " has played " + Team2 + " " + temp.size() + " times over " + Season.size()/380 + " seasons");
		System.out.println("There have been " + totGoals + " goals scored, " + team1Goals + " scored by " + Team1 + " and " + team2Goals + " scored by " + Team2);
		System.out.println("" + Team1 + " has " + team1totWins + " wins, " + team1totDraws + " draws, and " + team1totLosses + " losses");
		System.out.println("" + team1hWins + " wins were at home and " + team1aWins + " were away from home");
		System.out.println("" + team1hDraws + " draws were at home and " + team1aDraws + " were away from home" );
		System.out.println("" + team1hLosses + " losses were at home and " + team1aLosses + " were away from home");
		System.out.println();
		return temp;
	
	}
	
	public ArrayList<Integer> h2hGoals(ArrayList<Games> temp, String Team1, String Team2){
		ArrayList<Integer> goalValues = new ArrayList<>();
		int team1Goals = 0, team2Goals = 0, totGoals = 0;
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i).aTeam.equals(Team1)) {
				team1Goals += temp.get(i).aGoals;
			}
			if(temp.get(i).aTeam.equals(Team2)) {
				team2Goals += temp.get(i).aGoals;
			}
			if(temp.get(i).hTeam.equals(Team1)) {
				team1Goals += temp.get(i).hGoals;
			}
			if(temp.get(i).hTeam.equals(Team2)) {
				team2Goals += temp.get(i).hGoals;
			}
			
		}
		totGoals = team1Goals + team2Goals;
		goalValues.add(team1Goals); goalValues.add(team2Goals); goalValues.add(totGoals);
		return goalValues;
		
	}
	
	public ArrayList<Integer> h2hRecord(ArrayList<Games> temp, String Team1, String Team2){
		ArrayList<Integer> records = new ArrayList<>();
			int team1hWins = 0, team1hDraws = 0, team1hLosses = 0;
			int team1aWins = 0, team1aDraws = 0, team1aLosses = 0;
			int team2hWins = 0, team2hDraws = 0, team2hLosses = 0;
			int team2aWins = 0, team2aDraws = 0, team2aLosses = 0;
			int team1totWins = 0, team1totDraws = 0, team1totLosses = 0;
			int team2totWins = 0, team2totDraws = 0, team2totLosses = 0;
			for(int i = 0; i < temp.size(); i++) {
				if(temp.get(i).hTeam.equals(Team1)) {
					if(temp.get(i).result == 'H') {
						team1hWins++;
						team2aLosses++;
					}
					else if(temp.get(i).result == 'D') {
						team1hDraws++;
						team2aDraws++;
					}
					else if (temp.get(i).result == 'A') {
						team1hLosses++;
						team2aWins++;
					}
				}
				else if(temp.get(i).aTeam.equals(Team1)) {
						if(temp.get(i).result == 'H') {
							team1aLosses++;
							team2hWins++;
						}
						else if(temp.get(i).result == 'D') {
							team1aDraws++;
							team2hDraws++;
						}
						else if (temp.get(i).result == 'A') {
							team1aWins++;
							team2hLosses++;
						}
				}
			}
			team1totWins = team1hWins + team1aWins;
			team1totDraws = team1hDraws + team1aDraws;
			team1totLosses = team1hLosses + team1aLosses;
			team2totWins = team2hWins + team2aWins;
			team2totDraws = team2hDraws + team2aDraws;
			team2totLosses = team2hLosses + team2aLosses;
			
			records.add(team1hWins); records.add(team1aWins); records.add(team1hDraws); records.add(team1aDraws); records.add(team1hLosses); records.add(team1aLosses); records.add(team1totWins); records.add(team1totDraws); records.add(team1totLosses);
			records.add(team2hWins); records.add(team2aWins); records.add(team2hDraws); records.add(team2aDraws); records.add(team2hLosses); records.add(team2aLosses); records.add(team2totWins); records.add(team2totDraws); records.add(team2totLosses);
			
			return records;
		}

	
	

	
	public static void main(String[] args) throws ParseException {
		
		
		
		
		long startTime = System.currentTimeMillis();
		
		Season season_05_19 = new Season();
		season_05_19.readGames("season_05_19.txt");
		ArrayList<String> teams = new ArrayList<>();
		//teams = season_05_19.listTeams();
		//System.out.println(teams);
		
		
	
		
		
		
		//ArrayList<String> teams = season_05_19.listTeams();
		/*Teams Valencia = new Teams("Valencia", season_05_19.Season);
		System.out.println("Valencia scored " + Valencia.totGoalsScored());
		System.out.println("Valencia conceded " + Valencia.totGoalsConceded());
		Valencia.records();*/
		Teams Tottenham = new Teams("Tottenham", season_05_19.Season);
		System.out.println(season_05_19.head2Head("Barcelona", "Atletico Madrid"));
		//ArrayList<Games> Barca_Madrid = season_05_19.head2Head("Barcelona", "Real Madrid");
	
		long endTime = System.currentTimeMillis();
		System.out.println("The Process took " + (endTime-startTime)/1000.0 + " seconds");
		
		/*To get data from Season
		 * season_17_18.Season.size();
		 * season_17_18.Season.get(i).hYellows
		 */
		
		
		
		/*To get data from Team
		 * Teams Valencia = new Teams("Valencia", season_05_19.Season);
		 * Valencia.Games.size()
		 * Valencia.Games.get(i).hGoals
		 */
		
		
		
		/*ArrayList<String> temp = new ArrayList<>();
		season_10_18.listTeams(temp);
		System.out.println(temp);*/
		
		
		

		
		
	
		
		
		

	}

}

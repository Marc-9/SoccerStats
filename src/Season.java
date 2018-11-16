import java.io.*;
import java.util.*;
import java.text.*;

// Creates an ArrayList of the Constructor Games
public class Season{
	public ArrayList<Games> Season = new ArrayList<>();
	
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
		int hShots = s.nextInt(), aShots = s.nextInt(), hShotsTarget = s.nextInt(), aShotsTarget = s.nextInt(), hFouls = s.nextInt(), aFouls = s.nextInt();
		int hCorners = s.nextInt(), aCorners = s.nextInt(), hYellows = s.nextInt(), aYellows = s.nextInt(), hRed = s.nextInt(), aRed = s.nextInt();
		double b365H = s.nextDouble(), b365D = s.nextDouble(), b365A = s.nextDouble(), bwH = s.nextDouble();
		double bwD = s.nextDouble(), bwA = s.nextDouble(), iwH = s.nextDouble(), iwD = s.nextDouble(), iwA = s.nextDouble(), lbH = s.nextDouble(), lbD = s.nextDouble(), lbA = s.nextDouble();
		double psH = s.nextDouble(), psD = s.nextDouble(), psA = s.nextDouble(), whH = s.nextDouble(), whD = s.nextDouble(), whA = s.nextDouble(), vcH = s.nextDouble(), vcD = s.nextDouble(), vcA = s.nextDouble();
		addGame(new Games(div, date1, hTeam, aTeam, hGoals, aGoals, result, htHGoals, htAGoals, htResult, hShots, aShots, hShotsTarget, aShotsTarget, hFouls, aFouls, hCorners, aCorners, hYellows, aYellows, hRed, aRed, b365H, b365D, b365A, bwH, bwD, bwA, iwH, iwD, iwA, lbH, lbD, lbA, psH, psD, psA, whH, whD, whA, vcH, vcD, vcA));
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
	
	public ArrayList<String> listTeams(ArrayList<String> temp){
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
	
	

	
	public static void main(String[] args) throws ParseException {
		
		
		
		
		Season season_10_18 = new Season();
		season_10_18.readGames("season_10_18.txt");
		/*To get data from Season
		 * season_17_18.Season.size();
		 * season_17_18.Season.get(i).hYellows
		 */
		
		Teams Valencia = new Teams("Valencia", season_10_18.Season);
		/*To get data from Team
		 * Valencia.Games.size()
		 * Valencia.Games.get(i).hGoals
		 */
		
		
		ArrayList<String> temp = new ArrayList<>();
		season_10_18.listTeams(temp);
		System.out.println(temp);
		
		
		

		
		
	
		
		
		

	}

}

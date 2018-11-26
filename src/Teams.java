import java.io.*;
import java.util.ArrayList;

public class Teams{

	public String teamName;
	public ArrayList<Games> Games;
	
	public Teams() {
		
	}
	
	public Teams(String name, ArrayList<Games> games) {
		this.Games = parseGames(name, games);
		this.teamName = name;
		
	}
	
	
	
	public ArrayList<Games> parseGames(String teamName, ArrayList<Games> games){
		ArrayList<Games> team = new ArrayList<>();
		for (int i = 0; i < games.size(); i++) {
			String temp = games.get(i).aTeam;
			String temp2 = games.get(i).hTeam;
			if(temp.equals(teamName) || temp2.equals(teamName) ) {
				team.add(games.get(i));
			}
		}
		
		return team;	
	}
	
	public int totGoalsScored() {
		int totgoals = 0;
		for(int i = 0; i < Games.size(); i++) {
			if(Games.get(i).aTeam.equals(teamName)) {
				totgoals += Games.get(i).aGoals;
			}
			else if(Games.get(i).hTeam.equals(teamName)) {
				totgoals += Games.get(i).hGoals;
			}
		}
		return totgoals;
	}
	
	public int totGoalsConceded() {
		int totgoals = 0;
		for(int i = 0; i < Games.size(); i++) {
			if(!Games.get(i).aTeam.equals(teamName)) {
				totgoals += Games.get(i).aGoals;
			}
			else if(!Games.get(i).hTeam.equals(teamName)) {
				totgoals += Games.get(i).hGoals;
			}
		}
		return totgoals;
	}
	
	public void records() {
		int hWins = 0, hDraws = 0, hLosses = 0;
		int aWins = 0, aDraws = 0, aLosses = 0;
		int totWins = 0, totDraws = 0, totLosses = 0;
		for(int i = 0; i < Games.size(); i++) {
			if(Games.get(i).hTeam.equals(teamName)) {
				if(Games.get(i).result == 'H') {
					hWins++;
				}
				else if(Games.get(i).result == 'D') {
					hDraws++;
				}
				else if (Games.get(i).result == 'A') {
					hLosses++;
				}
			}
			else if(Games.get(i).aTeam.equals(teamName)) {
					if(Games.get(i).result == 'H') {
						aLosses++;
					}
					else if(Games.get(i).result == 'D') {
						aDraws++;
					}
					else if (Games.get(i).result == 'A') {
						aWins++;
					}
			}
		}
		totWins = hWins + aWins;
		totDraws = hDraws + aDraws;
		totLosses = hLosses + aLosses;
		System.out.println("" + teamName + " had " + totWins + " wins, " + totDraws + " draws, and " + totLosses + " losses in "+ Games.size() + " Games");
		System.out.println("" + hWins + " wins were at home and " + aWins + " were away from home");
		System.out.println("" + hDraws + " draws were at home and " + aDraws + " were away from home" );
		System.out.println("" + hLosses + " losses were at home and " + aLosses + " were away from home");
		
	}
	
	
	
	public void Write(String filename, ArrayList<Games> Games) throws IOException{
		File f = new File("test2.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(Games);
		
		oos.close();
		
		
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		
		
	}

}

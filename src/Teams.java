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
	
	public int totGoalsScored(String teamName, ArrayList<Games> Games) {
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
	
	public int totGoalsConceded(String teamName, ArrayList<Games> Games) {
		int totgoals = 0;
		for(int i = 0; i < Games.size(); i++) {
			if(!Games.get(i).aTeam.equals(teamName)) {
				totgoals += Games.get(i).hGoals;
			}
			else if(!Games.get(i).hTeam.equals(teamName)) {
				totgoals += Games.get(i).aGoals;
			}
		}
		return totgoals;
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

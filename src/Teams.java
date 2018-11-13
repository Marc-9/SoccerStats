import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Teams {
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
	
	/*public static void Write(String filename, ArrayList<Games> Games) throws IOException{
		BufferedWriter outputWriter = null;
		
		
	}*/
	
	
	

	public static void main(String[] args) {
		
		
	}

}

import java.text.SimpleDateFormat;
import java.util.Date;

// This is where you Declare all variables in your data set
public class Games{
	// Data provided by the Constructor
	int hGoals, aGoals, htHGoals, htAGoals, hShots, aShots, hShotsTarget, aShotsTarget, hFouls, aFouls, hCorners, aCorners, hYellows, aYellows, hRed, aRed, totGoals;
	String hTeam, aTeam, div, referee;
	Date date;
	char result, htResult;
	
// This is the Games Constructor to initialize each element in the ArrayList once again, change it to your dataset 
	public Games(String div, Date date, String hTeam, String aTeam, int hGoals, int aGoals, char result, int htHGoals, int htAGoals, char htResult, String referee, int hShots, int aShots, int hShotsTarget, int aShotsTarget, int hFouls, int aFouls, int hCorners, int aCorners, int hYellows, int aYellows, int hRed, int aRed) {
		this.div = div; this.date = date; this.hTeam = hTeam; this.aTeam = aTeam; this.hGoals = hGoals; this.aGoals = aGoals; this.result = result; this.htHGoals = htHGoals; this.htAGoals = htAGoals; this.htResult = htResult; this.referee = referee; this.hShots = hShots;
		this.aShots = aShots; this.hShotsTarget = hShotsTarget; this.aShotsTarget = aShotsTarget; this.hFouls = hFouls; this.aFouls = aFouls; this.hCorners = hCorners; this.aCorners = aCorners; this.hYellows = hYellows; this.aYellows = aYellows;
		this.hRed = hRed; this.aRed = aRed;
		this.totGoals = aGoals + hGoals;
	}

	
// A To-String I created to test the ArrayList, this grabs the char result to find out if the team won or lost
	public String toString() {
		String temp = "";
		String result = "";
		if (this.result == 'H') {
			result += "beat";
		}
		else if(this.result == 'A') {
			result += "lost to";
		}
		else if (this.result == 'D') {
			result += "drew with";
		}
		temp += "On " + date + " " + hTeam + " " + result + " " + aTeam + " " + hGoals + " to " + aGoals + "\n"
				+ hTeam + " had " + hShotsTarget + " shots on target to " + aTeam + "\'s " + aShotsTarget + " and at Halftime the score was " + htHGoals + " to " + htAGoals + "\n"
				+ hTeam + " commited " + hFouls + " fouls getting " + hYellows + " yellows and " + hRed + " red and " + aTeam + " commited " + aFouls + " fouls getting " + aYellows + " yellows and " + aRed + " red\n";
		return temp;
	}

// This will be used to sort games by Date
	public boolean inInterval(Date start, Date end) {
	    if(this.date.after(start) || this.date.equals(start)) {
	    	if(this.date.before(end) || this.date.equals(end)) {
	    		return true;
	    		}
	    	}
	    return false;
	    	
	    }
	
// A method to take provided Strings and cast them as dates, still in progress like the above method	
	public static Date createDate(String date) {
		Date returnDate = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
		String stringDate = date;
		try {
			returnDate = formatter.parse(stringDate);
		} catch (Exception e) {
			System.out.println("Invalid format: " + stringDate);
		}
		return returnDate;
    }
	
	


	
	

	
	
	
}

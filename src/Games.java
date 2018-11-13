import java.text.SimpleDateFormat;
import java.util.Date;

// This is where you Declare all variables in your data set
public class Games{
	String hTeam;
	Date date;
	String aTeam;
	int totGoals;
	int hGoals, aGoals, result, points, wins, draws, losses, hShots, aShots, hShotsTarget, aShotsTarget;
	
// This is the Games Constructor to initialize each element in the ArrayList once again, change it to your dataset 
	public Games(Date date, String hTeam, String aTeam, int hGoals, int aGoals, char result, int hShots, int aShots, int hShotsTarget, int aShotsTarget) {
		this.hTeam = hTeam;
		this.aTeam = aTeam;
		this.hGoals = hGoals;
		this.aGoals = aGoals;
		this.result = result;
		this.hShots = hShots;
		this.aShots = aShots;
		this.date = date;
		this.hShotsTarget = hShotsTarget;
		this.aShotsTarget = aShotsTarget;
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
		temp += "On " + date + " " + hTeam + " " + result + " " + aTeam + " " + hGoals + " to " + aGoals + "\n";
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");
		String stringDate = date;
		try {
			returnDate = formatter.parse(stringDate);
		} catch (Exception e) {
			System.out.println("Invalid format: " + stringDate);
		}
		return returnDate;
    }
	


	
	

	
	
	
}

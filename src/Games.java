import java.text.SimpleDateFormat;
import java.util.Date;

// This is where you Declare all variables in your data set
public class Games{
	// Data that must be calculated not from constructor
	double avgHomeOdds, avgAwayOdds;
	// Data provided by the Constructor
	int hGoals, aGoals, htHGoals, htAGoals, hShots, aShots, hShotsTarget, aShotsTarget, hFouls, aFouls, hCorners, aCorners, hYellows, aYellows, hRed, aRed;
	Double b365H, b365D, b365A, bwH, bwD, bwA, iwH, iwD, iwA, lbH, lbD, lbA, psH, psD, psA, whH, whD, whA, vcH, vcD, vcA;
	String hTeam, aTeam, div;
	Date date;
	char result, htResult;
	
// This is the Games Constructor to initialize each element in the ArrayList once again, change it to your dataset 
	public Games(String div, Date date, String hTeam, String aTeam, int hGoals, int aGoals, char result, int htHGoals, int htAGoals, char htResult, int hShots, int aShots, int hShotsTarget, int aShotsTarget, int hFouls, int aFouls, int hCorners, int aCorners, int hYellows, int aYellows, int hRed, int aRed, double b365H, double b365D, double b365A, double bwH, double bwD, double bwA, double iwH, double iwD, double iwA, double lbH, double lbD, double lbA, double psH, double psD, double psA, double whH, double whD, double whA, double vcH, double vcD, double vcA) {
		this.div = div; this.date = date; this.hTeam = hTeam; this.aTeam = aTeam; this.hGoals = hGoals; this.aGoals = aGoals; this.result = result; this.htHGoals = htHGoals; this.htAGoals = htAGoals; this.htResult = htResult; this.hShots = hShots;
		this.aShots = aShots; this.hShotsTarget = hShotsTarget; this.aShotsTarget = aShotsTarget; this.hFouls = hFouls; this.aFouls = aFouls; this.hCorners = hCorners; this.aCorners = aCorners; this.hYellows = hYellows; this.aYellows = aYellows;
		this.hRed = hRed; this.aRed = aRed; this.b365H = b365H; this.b365D = b365D; this.b365A = b365A; this.bwH = bwH; this.bwD = bwD; this.bwA = bwA; 
		this.iwH = iwH; this.iwD = iwD; this.iwA = iwA; this.lbH = lbH; this.lbD = lbD; this.lbA = lbA; this.psH = psH; this.psD = psD; this.psA = psA; this.whH= whH; this.whD = whD; this.whA = whA; this.vcH = vcH; this.vcD = vcD; this.vcA = vcA;
		this.avgHomeOdds = (b365H +  bwH + iwH + lbH + psH + whH + vcH)/7.0;
		this.avgAwayOdds = (b365A +  bwA + iwA + lbA + psA + whA + vcA)/7.0;
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

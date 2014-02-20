package validate;

public class Result {
	String autoGraphName;
	int points;
	
	
	
	private Result(String autoGraphName, int points) {
		super();
		this.autoGraphName = autoGraphName;
		this.points = points;
	}
	
	public String getAutoGraphName() {
		return autoGraphName;
	}
	public void setAutoGraphName(String autoGraphName) {
		this.autoGraphName = autoGraphName;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	

}

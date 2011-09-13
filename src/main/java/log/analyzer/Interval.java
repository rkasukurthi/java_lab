package log.analyzer;

import java.util.Date;

public class Interval {
	
	Date start;
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	Date end;

	public boolean isIn(Date date)
	{
		if (start==null || end==null) return false; 
		return (date.before(end) && date.after(start));
	}
}

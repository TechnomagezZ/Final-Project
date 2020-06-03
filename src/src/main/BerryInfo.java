package src.main;

public class BerryInfo {
	public final String berryName;
	public final Integer berrySize;
	public final Integer berryTime;

	public BerryInfo(final String berName, final Integer berSize, final Integer berTime) {
		super();
		berryName = berName;
		berrySize = berSize;
		berryTime = berTime;
	}
	
	public String getBerryName() {
		return berryName;
	}
	
	public Integer getBerrySize() {
		return berrySize;
	}
	
	public Integer getBerryTime() {
		return berryTime;
	}

	public String toString() {
		return "Name:" + berryName + ", Size:" + berrySize + ", Time to Grow:" + berryTime + ". ";
	}
}


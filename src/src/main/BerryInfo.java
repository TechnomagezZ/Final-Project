package src.main;

public class BerryInfo implements Comparable<BerryInfo>{
	public final String berryName;
	public final Integer berrySize;
	public final Integer berryTime;
	public final Integer growthEfficiency;

	public BerryInfo(final String berName, final Integer berSize, final Integer berTime,final Integer grwEff) {
		berryName = berName;
		berrySize = berSize;
		berryTime = berTime;
		growthEfficiency = grwEff;
	}

	public String toString() {
		return "Name:" + berryName + ", Size:" + berrySize + ", Time to Grow:" + berryTime + ", Growth Efficiency:" + growthEfficiency + ". ";
	}

	@Override
	public int compareTo(BerryInfo o) {
		return growthEfficiency.compareTo(o.growthEfficiency);
	}
}


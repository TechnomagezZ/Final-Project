package src.main;

import java.util.function.Predicate;

public class BerriesList {
	
	public static Predicate<BerryInfo> isSizeBiggerThan(final int berrySize) {
		return berryInfo -> berryInfo.berrySize > berrySize;
	}
	
	public static Predicate<BerryInfo> isTimeLessThan(final Integer berryTime) {
		return berryInfo -> berryInfo.berryTime < berryTime;
	}
}

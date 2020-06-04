package src.main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class pokiBerry {

	public static final List<String> berryID = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
			"12", "13", "14", "15", "16", "17", "18", "19", "20");

	final static List<BerryInfo> berries = new ArrayList<BerryInfo>();

	static BerryInfo berryInfo = new BerryInfo(null, null, null, null);

	static String berName = null;
	static Integer berTime = null;
	static Integer berSize = null;
	static Integer growthEfficiency = 0;

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < berryID.size(); i++) {
			final String berry = berryID.get(i);
			String rootURL = "https://pokeapi.co/api/v2/berry/";
			rootURL += berry + "/";

			URL request = new URL(rootURL);

			InputStream openStream = request.openStream();
			String response = IOUtils.toString(openStream);
			JSONObject root = new JSONObject(response);
			JSONObject item = (JSONObject) root.get("item");

			final String berName = (String) item.get("name");
			final Integer berSize = (Integer) root.get("size");
			final Integer berTime = (Integer) root.get("growth_time");
			final Integer grwEff = (berSize / berTime);

			BerryInfo berryInfo = new BerryInfo(berName, berSize, berTime, grwEff);

			berries.add(berryInfo);

		}

		berries.sort(null);
		List<BerryInfo> berry = berries.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println("Biggest most efficient berry to grow is: " + berry.get(0));

	}
}

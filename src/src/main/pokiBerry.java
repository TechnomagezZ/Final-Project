package src.main;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class pokiBerry {
	
	public static final List<String> berryID = Arrays.asList("1", "2", "3", "4", "5",
			"6", "7", "8", "9", "10", "11", "12", "13", "14", "15","16", "17", "18",
			"19", "20");
	final static List<BerryInfo> berries =  new ArrayList<BerryInfo>();
	static List<BerryInfo> BigBerry = new ArrayList<BerryInfo>();
	
	
	static BerryInfo berryInfo = new BerryInfo(null, null, null);
	static BerryInfo berryInfo1 = null;
	static BerryInfo berryInfo2 = null;
	static BerryInfo bigBerry = null;
	
	static String berName = null;
	static Integer berTime = null;
	static Integer berSize = null;
	static int berrySize = 0;
	
	public static void main(String[] args) throws IOException {
		
		for(int i = 0; i < berryID.size(); i++) {
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
			
			BerryInfo berryInfo1 = new BerryInfo(berName, berSize, berTime);
			
			berries.add(berryInfo1);
			
		}
		//System.out.println(berries);
		
		for(int i = 0; i < berries.size(); i++) {
			for(int j = 1; j < berries.size(); j++) {
				berryInfo1 = berries.get(i);
				berryInfo2 = berries.get(j);
				//berrySize = berries.get(i).getBerrySize();
				//BigBerry = BerriesList.filteredList(berries,
					  	//BerriesList.isSizeBiggerThan(berrySize));
				bigBerry = BerriesList.pickBiggest(berryInfo1, berryInfo2);
				BerriesList.lessTime(berryInfo1, berryInfo2);
				BigBerry.add(bigBerry);
			}
		}
		System.out.println(BigBerry);
		
		//List<BerryInfo> berry = berries.stream().filter(null)
												//.collect(Collectors.toList());
		//System.out.println(berry);
		
	}
}

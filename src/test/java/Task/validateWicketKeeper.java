package Task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class validateWicketKeeper {
	@Test
	public void ValidateWicketKeeperTest() throws FileNotFoundException, IOException, ParseException {
		int wicketKeeperCount = 0;
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobj = (JSONObject) jsonparser.parse(new FileReader("./TeamRCB.json"));
		JSONArray jsonArr = (JSONArray) jsonobj.get("player");
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject player = (JSONObject) jsonArr.get(i);
			String country = (String) player.get("role");
			if (country.equalsIgnoreCase("Wicket-keeper"))
				wicketKeeperCount++;
		}
		if (wicketKeeperCount == 1)
			System.out.println("Team has " + wicketKeeperCount + " wicket Keeper");
		else
			System.out.println("Team is not have wicket Keeper");

	}

}

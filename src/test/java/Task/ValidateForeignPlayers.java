package Task;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateForeignPlayers {
	@Test
	public void validateForeignPlayersTest() throws FileNotFoundException, IOException, ParseException {
		int ForeignPlayersCount = 0;
		JSONParser jsonparser = new JSONParser();
		JSONObject jsonobj = (JSONObject) jsonparser.parse(new FileReader("./TeamRCB.json"));
		JSONArray jsonArr = (JSONArray) jsonobj.get("player");
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject player = (JSONObject) jsonArr.get(i);
			String country = (String) player.get("country");
			if (!country.equalsIgnoreCase("India"))
				ForeignPlayersCount++;
		}
		// Assert.assertEquals(ForeignPlayersCount, 4);
		if (ForeignPlayersCount >= 4) {
			System.out.println("Team has only " + ForeignPlayersCount + " Foreign Players");
		} else {
			System.out.println("Team is not having 4 Foreign Players");
			Assert.fail();
		}

	}

}

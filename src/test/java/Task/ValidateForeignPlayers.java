package Task;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Genric.BaseClass;
import Genric.GetJsonValue;

public class ValidateForeignPlayers extends BaseClass {
	@Test
	public void validateForeignPlayersTest() throws FileNotFoundException, IOException, ParseException {
		int ForeignPlayersCount = 0;
		jsonArr = GetJsonValue.getJsonObjectArray(jsonobj, "player");
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject player = (JSONObject) jsonArr.get(i);
			String country = GetJsonValue.getJsonObjectValue(player, "country");
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

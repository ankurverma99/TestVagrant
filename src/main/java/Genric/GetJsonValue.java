package Genric;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class GetJsonValue {

	public static String getJsonObjectValue(JSONObject jsonobj, String key) {
		return (String) jsonobj.get(key);

	}

	public static JSONArray getJsonObjectArray(JSONObject jsonobj, String key) {
		return (JSONArray) jsonobj.get(key);

	}

}

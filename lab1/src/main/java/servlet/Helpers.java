package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jakarta.servlet.http.HttpServletRequest;
import juice.Juice;

public class Helpers {
	public static JsonElement bodyParse(HttpServletRequest request) {
		JsonElement jsonElement = null;
		
		try {
			jsonElement = JsonParser.parseReader(request.getReader());
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			e.printStackTrace();
		}
		
		return jsonElement;
	}
	
	public static Juice juiceParse(HttpServletRequest request) {
		Juice juice = new Juice();
		JsonElement jsonElement = bodyParse(request);
		juice.setId(jsonElement.getAsJsonObject().get("id").getAsInt());
		juice.setTitle(jsonElement.getAsJsonObject().get("title").getAsString());
		juice.setDescr(jsonElement.getAsJsonObject().get("descr").getAsString());
		juice.setImg(jsonElement.getAsJsonObject().get("img").getAsString());
		
		return juice;
	}
	
	public static int getNextId(List<Juice> list) {
		int maxId = 0;
		if (list == null) return 0;
		Iterator<Juice> iterator = list.iterator();
		while (iterator.hasNext()) {
			int currentId = iterator.next().getId();
			if (currentId > maxId) maxId = currentId;
		}
		
		return maxId + 1;
	}
	
	public static int getIndexByJuiceId(int id, List<Juice> list) {
		int listId = id;
		
		Iterator<Juice> iterator = list.iterator();
		while (iterator.hasNext()) {
			Juice temp = iterator.next();
			if (temp.getId() == listId) {
				listId = list.indexOf(temp);
				break;
			}
		}
		
		return listId;
	}

}

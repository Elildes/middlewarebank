package main.java.application;

import org.json.JSONObject;

import main.java.middleware.annotations.Get;
import main.java.middleware.annotations.Post;
import main.java.middleware.annotations.RequestMap;
import main.java.middleware.annotations.RequestMap;

@RequestMap(router = "/fin")
public class BankMiddleware {

	@Post(router = "/dep")
	public JSONObject dep(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}
	
	@Get(router = "/sal")
	public JSONObject sal(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}
	

	@Post(router = "/sac")
	public JSONObject sac(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}

	@Post(router = "/tra")
	public JSONObject tra(JSONObject jsonObject) throws Throwable {
		
		return jsonObject;
	}

	
}

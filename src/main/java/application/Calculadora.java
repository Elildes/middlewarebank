package main.java.application;

import main.java.middleware.annotations.Post;
import main.java.middleware.annotations.Put;
import main.java.middleware.annotations.RequestMap;
import main.java.middleware.annotations.Delete;
import main.java.middleware.annotations.Get;

import org.json.JSONObject;

@RequestMap(router = "/calc")
public class Calculadora {

	private int memoria = 0;

	@Get(router = "/soma")
	public JSONObject soma(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");
		Double var2 = jsonObject.getDouble("var2");

		JSONObject result = new JSONObject();
		result.put("result", var1+var2);

		return result;
	}

	@Post(router = "/sub")
	public JSONObject sub(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");
		Double var2 = jsonObject.getDouble("var2");

		JSONObject result = new JSONObject();
		result.put("result", var1-var2);

		return result;
	}



	@Put(router = "/div")
	public JSONObject div(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");
		Double var2 = jsonObject.getDouble("var2");

		JSONObject result = new JSONObject();

		if (var2 != 0) {
			result.put("result", var1/var2);
			return result;

		}

		else {

			result.put("result", "error");
		}


		return result;
	}


	@Delete(router = "/mult")
	public JSONObject mult(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");
		Double var2 = jsonObject.getDouble("var2");

		JSONObject result = new JSONObject();
		result.put("result", var1*var2);

		return result;
	}

	@Get(router = "/somamem")
	public JSONObject somamem(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");

		JSONObject result = new JSONObject();
		result.put("result", memoria+var1);

		return result;
	}


	@Get(router = "/submem")
	public JSONObject submem(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");

		JSONObject result = new JSONObject();
		result.put("result", memoria-var1);

		return result;
	}

	@Get(router = "/divmem")
	public JSONObject divmem(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");

		JSONObject result = new JSONObject();


		if (var1 != 0) {
			result.put("result", memoria/var1);
			return result;

		}

		else {

			result.put("result", "error: impossible division");
		}



		result.put("result", memoria/var1);

		return result;
	}

	@Get(router = "/multmem")
	public JSONObject multmem(JSONObject jsonObject) throws Throwable {

		Double var1 = jsonObject.getDouble("var1");

		JSONObject result = new JSONObject();
		result.put("result", memoria*var1);

		return result;
	}


}
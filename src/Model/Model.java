package Model;

public class Model {
	
	public static Model ModelInstance;
	private Model() {
		
	}
	
	public static Model getInstance() throws ClassNotFoundException{
		if(ModelInstance == null) {
			ModelInstance = new Model();
		}
		return ModelInstance;
	}
	
	public String checkForempty(String s) {
		String result = "yes";
		if(s.equals("")) {
			result = "no";
		}
		return result;
	}
}

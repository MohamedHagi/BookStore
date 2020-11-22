package Model;

public class Model {
	
	public static Model ModelInstance;
	private Model() {
		
	}
	
	public Model getInstance() {
		if(ModelInstance == null) {
			ModelInstance = new Model();
		}
		return ModelInstance;
	}
}

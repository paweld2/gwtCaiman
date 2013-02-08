package pmsoft.gwt.sample.shared.logic.model;

public class InMemoryAppModel implements AppModel {

	private boolean login = false; 
	
	@Override
	public boolean isUserLogin() {
		return login;
	}

}

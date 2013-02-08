package pmsoft.gwt.sample.client.event;

import pmsoft.gwt.sample.shared.domain.User;

import com.google.gwt.event.shared.EventHandler;

public interface ModelBus {
	public void userLogin(User user);
	public static interface UserLoginHandler extends EventHandler{
		public void userLogin(User user);
	}
	public void onUserLogin(UserLoginHandler handler);

}

package pmsoft.gwt.sample.client.event;

import pmsoft.gwt.sample.shared.domain.User;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;

public class ModelBusImpl implements ModelBus {

	EventBus bus = new SimpleEventBus();
	
	private static Type<UserLoginHandler> userLoginType = new Type<UserLoginHandler>();
	private static class UserLoginEvent extends GwtEvent<UserLoginHandler> {
		User user;

		@Override
		public Type<UserLoginHandler> getAssociatedType() {
			return userLoginType;
		}

		@Override
		protected void dispatch(UserLoginHandler handler) {
			handler.userLogin(user);
		}
	}
	@Override
	public void userLogin(User user) {
		UserLoginEvent event = new UserLoginEvent();
		event.user = user;
		bus.fireEvent(event);
	}

	@Override
	public void onUserLogin(UserLoginHandler handler) {
		HandlerRegistration regis = bus.addHandler(userLoginType, handler);
		
		regis.removeHandler();
	}

}

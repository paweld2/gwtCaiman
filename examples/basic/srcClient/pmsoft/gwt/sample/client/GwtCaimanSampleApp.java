package pmsoft.gwt.sample.client;


import net.customware.gwt.dispatch.client.DispatchAsync;
import pmsoft.gwt.sample.shared.app.activity.LoginActivity;
import pmsoft.gwt.sample.shared.ar.PingAction;
import pmsoft.gwt.sample.shared.ar.PingResult;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

import eu.caimandesign.gwt.lib.presenter.client.place.PlaceManager;

public class GwtCaimanSampleApp {

	private boolean sessionSet = false;
	
	public boolean isHttpSessionSet() {
		return sessionSet;
	}
	
	private final PlaceManager manager;
	private final DispatchAsync displatcher;
	
	@Inject
	public GwtCaimanSampleApp( PlaceManager manager,
			DispatchAsync displatcher) {
		super();
		this.manager = manager;
		this.displatcher = displatcher;
	}



	public void startApplication() {
//		manager.fireCurrentPlace();
		displatcher.execute(new PingAction(), new AsyncCallback<PingResult>(){
			@Override
			public void onFailure(Throwable caught) {
				manager.fireActivity(new LoginActivity());
				sessionSet = false;
			}

			@Override
			public void onSuccess(PingResult result) {
				sessionSet = true;
				manager.fireActivity(new LoginActivity());
			}
		});
	}

}

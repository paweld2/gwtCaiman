package eu.caimandesign.gwt.lib.presenter.client.activity;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanActivity;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanPlace;

public class WrappingActivityController extends EmptyActivityController {

	private final CaimanActivity activity;

	public WrappingActivityController(CaimanActivity activity) {
		super();
		this.activity = activity;
	}

	@Override
	public Class<? extends CaimanPlace> getActivityPlace() {
		return activity.getCurrentPlace();
	}

	@Override
	public void startActivity() {
		super.startActivity();
	}

	public void stopActivity() {
		super.stopActivity();
	};

}

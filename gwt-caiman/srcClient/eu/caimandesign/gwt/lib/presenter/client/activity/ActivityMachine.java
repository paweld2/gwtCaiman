package eu.caimandesign.gwt.lib.presenter.client.activity;

import java.util.Stack;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import eu.caimandesign.gwt.lib.presenter.client.api.CaimanActivity;
import eu.caimandesign.gwt.lib.presenter.client.api.CaimanLogging;

@Singleton
public class ActivityMachine {
	
	@Inject
	public ActivityMachine() {
		super();
		this.activities = new Stack<ActivityController>();
	}

	private final Stack<ActivityController> activities;

	public ActivityController peekActivity() {
		if (activities.isEmpty()) {
			CaimanLogging.getLogger().fine("pushing default activity to stack");
			activities.push(getDefaultActivity());
		}
		return activities.peek();
	}

	private ActivityController getDefaultActivity() {
		return new EmptyActivityController();
	}

	public void pushActivity(CaimanActivity activity) {
		CaimanLogging.getLogger().fine("activity to top: " + activity);
		ActivityController current = peekActivity();
		current.stopActivity();
		ActivityController controller = new WrappingActivityController(activity);
		activities.push(controller);
	}

}

package pmsoft.gwt.sample.shared.logic.presenter;

import pmsoft.gwt.sample.shared.flow.navigation.NavigationActionFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationDisplayFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationPresenterFlow;

import com.google.inject.Inject;

public class NavigationPresenter implements NavigationPresenterFlow,
		NavigationActionFlow {

	protected final NavigationDisplayFlow display;

	@Inject
	public NavigationPresenter(NavigationDisplayFlow display) {
		super();
		this.display = display;
	}

	@Override
	public NavigationActionFlow getActionFlow() {
		return this;
	}

	@Override
	public NavigationDisplayFlow getDisplay() {
		return display;
	}

}

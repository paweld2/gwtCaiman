package pmsoft.gwt.sample.shared.flow;

import pmsoft.gwt.sample.shared.flow.navigation.NavigationActionFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationDisplayFlow;
import pmsoft.gwt.sample.shared.flow.navigation.NavigationPresenterFlow;

import com.google.inject.Inject;
import com.google.inject.Provider;

import eu.caimandesign.gwt.lib.presenter.client.api.flow.AbstractFlowContract;

public class NavigationFlow
		extends
		AbstractFlowContract<NavigationPresenterFlow, NavigationDisplayFlow, NavigationActionFlow> {

	@Inject
	public NavigationFlow(Provider<NavigationPresenterFlow> presenterProvider,
			Provider<NavigationDisplayFlow> displayProvider) {
		super(presenterProvider, displayProvider);
	}

}

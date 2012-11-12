package eu.caimandesign.gwt.lib.presenter.client.activity;

import com.google.gwt.user.client.ui.AcceptsOneWidget;

import eu.caimandesign.gwt.lib.presenter.client.api.flow.AbstractFlowContract;

public interface ActivityContextSupport {

	public void bind(AbstractFlowContract<?,?,?> contract, AcceptsOneWidget panel);
}

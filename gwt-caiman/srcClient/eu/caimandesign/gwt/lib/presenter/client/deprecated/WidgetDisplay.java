package eu.caimandesign.gwt.lib.presenter.client.deprecated;


import com.google.gwt.user.client.ui.Widget;


public interface WidgetDisplay extends Display {
    /**
     * Returns the display as a GWT {@link Widget}. This may be the same
     * Display instance, or another object completely.
     * 
     * @return The widget.
     */
    Widget asWidget();
}

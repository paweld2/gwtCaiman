package eu.caimandesign.gwt.lib.presenter.client.place;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;



public class PlaceRevealedEvent extends GwtEvent<PlaceRevealedHandler> {

    private static GwtEvent.Type<PlaceRevealedHandler> TYPE = new GwtEvent.Type<PlaceRevealedHandler>();

    public static GwtEvent.Type<PlaceRevealedHandler> getType() {
        return TYPE;
    }

    private final PlaceController place;

    public PlaceRevealedEvent( PlaceController place ) {
        this.place = place;
    }

    /**
     * Returns the place that was revealed.
     *
     * @return the place.
     */
    public PlaceController getPlace() {
        return place;
    }

    @Override
    protected void dispatch( PlaceRevealedHandler handler ) {
        handler.onPlaceRevealed( this );
    }

    @Override
    public GwtEvent.Type<PlaceRevealedHandler> getAssociatedType() {
        return TYPE;
    }

    /**
     * Call this method to fire place revealed events.
     *
     * @param eventBus The eventBus.
     * @param place    The place.
     */
    public static void fire( EventBus eventBus, PlaceController place ) {
        eventBus.fireEvent( new PlaceRevealedEvent( place ) );
    }
}

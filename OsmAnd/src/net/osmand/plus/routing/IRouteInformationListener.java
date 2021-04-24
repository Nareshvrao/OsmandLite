package net.osmand.plus.routing;

import net.osmand.ValueHolder;

public interface IRouteInformationListener {

	void newRouteIsCalculated(boolean newRoute, ValueHolder<Boolean> showToast);

	void routeWasCancelled();

	void routeWasFinished();
}
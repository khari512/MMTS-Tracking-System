package com.mangocrab.controller;

import org.slim3.controller.router.RouterImpl;

public class AppRouter extends RouterImpl {

	public AppRouter() {
		addRouting("/_ah/mail/{address}", "/mail/receive?address={address}");
		addRouting("/{app}/edit/{key}/{version}",
				"/{app}/edit?key={key}&version={version}");
		addRouting("/{app}/delete/{key}/{version}",
				"/{app}/delete?key={key}&version={version}");
		addRouting("/{app}/find/*path", "/{app}/find?path={path}");
		addRouting("/sharetrain/UpdateTrackingInfo/{destination}/{currentStation}/{trainNumber}/{time}/{trainName}",
				"/sharetrain/UpdateTrackingInfoController?destination={destination}&currentStation={currentStation}&trainNumber={trainNumber}&time={time}&trainName={trainName}");
	}
}
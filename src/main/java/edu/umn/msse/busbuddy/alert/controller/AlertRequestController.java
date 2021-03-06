package edu.umn.msse.busbuddy.alert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.umn.msse.busbuddy.alert.controller.model.AlertRequestModel;
import edu.umn.msse.busbuddy.alert.controller.model.AlertResponseModel;
import edu.umn.msse.busbuddy.alert.controller.model.TrackingAlertRequestModel;
import edu.umn.msse.busbuddy.alert.controller.model.TransitAlertRequestModel;
import edu.umn.msse.busbuddy.alert.controller.model.UserAlertRequestModel;
import edu.umn.msse.busbuddy.common.BusBuddyForbiddenException;

/**
 * This is a front facing controller that takes in request from other module via REST call and returns a JSON
 * representation data. User module calls the alert module to create new alert, delete alert, update alert or to get a
 * list of alert for a user. Transit module can call alert module to create, delete and update a new alert. Tracking
 * module can call alert module to create a new alert. As far as public facing end points go, we have implemented one
 * endpoint for each module. During implementation there might be different GET, POST, PUT and DELETE methods. But for
 * now, we are putting only one method per module as a placeholder assuming that it can take different actions depending
 * upon the information in the AlertRequestModel.
 */
@Controller
public class AlertRequestController {

	/**
	 * Session Verification Factory picks the appropriate type of session verification strategy depending upon which
	 * module is initiating the call.
	 */
	@Autowired
	private SessionVerificationFactory sessionVerificationFactory;

	/**
	 * Processes Alert manipulation request from User module.
	 * 
	 * @param userAlertRequest
	 *            An alertRequestModel that has the necessary information regarding creation of an alert. {@see
	 *            alert.controller.model.UserAlertRequestModel}
	 * @param encryptedToken
	 *            An encrypted token that can be validated.
	 * @return An {@link alert.controller.model.AlertResponseModel} that has the success/error information.
	 */
	public AlertResponseModel processUserAlertRequest(UserAlertRequestModel userAlertRequest, String encryptedToken) {
		verifySession(userAlertRequest, encryptedToken);

		return new AlertResponseModel();
	}

	/**
	 * Processes Alert manipulation request from Transit module
	 * 
	 * @param transitAlertRequest
	 *            {@see alert.controller.model.TransitAlertRequestModel}
	 * @param encryptedToken
	 *            - An encrypted token that can be validated.
	 * @return An {@link alert.controller.model.AlertResponseModel} that has the success/error information.
	 */
	public AlertResponseModel processTransitAlertRequest(TransitAlertRequestModel transitAlertRequest, String encryptedToken) {
		verifySession(transitAlertRequest, encryptedToken);
		return new AlertResponseModel();
	}

	/**
	 * Processes Alert manipulation request from Tracking module
	 * 
	 * @param trackingAlertRequest
	 *            {@see alert.controller.model.TrackingAlertRequestModel}
	 * @param encryptedToken
	 *            An encrypted token that can be validated.
	 * @return An {@link alert.controller.model.AlertResponseModel} that has the success/error information.
	 */
	public AlertResponseModel processTrackingAlertRequest(TrackingAlertRequestModel trackingAlertRequest, String encryptedToken) {
		verifySession(trackingAlertRequest, encryptedToken);
		return new AlertResponseModel();
	}

	/**
	 * Method to verify the validity of session token being passed. If token verification fails, it automatically throws
	 * an error the request is terminated.
	 * 
	 * @param requestModel
	 *            An object representation of JSON that has the request.
	 * @param encryptedToken
	 *            An encrypted token that can be validated.
	 */
	private void verifySession(AlertRequestModel requestModel, String encryptedToken) {
		ISessionHandler sessionHandler = SessionVerificationFactory.getSessionTokenVerificationStrategy(requestModel.getAlertInitiator());
		try {
			sessionHandler.verifySessionToken(encryptedToken);
		} catch (BusBuddyForbiddenException ex) {
			// TODO handle the exception.
			//

		}

	}
}

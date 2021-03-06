package edu.umn.msse.busbuddy.alert.controller;

import edu.umn.msse.busbuddy.common.BusBuddyForbiddenException;

/**
 * An interface to verify the validity of encrypted token being passed. The implementation of this interface must
 * decrpyt the session token or certificate and then verify it.
 */
public interface ISessionHandler {

	/**
	 * This method takes in an encrypted token in a form of string and then validates for its authenticity.
	 * 
	 * @param encryptedToken
	 *            - An encrypted string.
	 * @return A boolean indicating whether the token was valid or not.
	 * @throws BusBuddyForbiddenException
	 *             - Throws an exception when the token is not valid.
	 */
	public boolean verifySessionToken(String encryptedToken) throws BusBuddyForbiddenException;
}

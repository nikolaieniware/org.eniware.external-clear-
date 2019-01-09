/* ==================================================================
 * This program is free software; you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation; either version 2 of 
 * the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * ==================================================================
 */

/*
 * ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

package ocpp.v15.support;

/**
 * Enumeration of the OCPP 1.5 standard configuration key values.
 * @version 1.0
 * @since 1.7
 */
public enum ConfigurationKeys {

	HeartBeatInterval("HeartBeatInterval"),
	ConnectionTimeOut("ConnectionTimeOut"),
	ResetRetries("ResetRetries"),
	BlinkRepeat("BlinkRepeat"),
	LightIntensity("LightIntensity"),
	MeterValueSampleInterval("MeterValueSampleInterval"),
	ClockAlignedDataInterval("ClockAlignedDataInterval"),
	MeterValuesSampledData("MeterValuesSampledData"),
	MeterValuesAlignedData("MeterValuesAlignedData"),
	StopTxnSampledData("StopTxnSampledData"),
	StopTxnAlignedData("StopTxnAlignedData"),

	// the following are deprecated in OCPP 1.5
	ProximityLockRetries("ProximityLockRetries"),
	ProximityContactRetries("ProximityContactRetries"),
	ChargePointId("ChargePointId");

	private final String key;

	private ConfigurationKeys(String key) {
		this.key = key;
	}

	/**
	 * Get the OCPP key value for this enum.
	 * 
	 * @return The key value.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Get a {@link ConfigurationKeys} instance for a given key value.
	 * 
	 * @param key
	 *        The OCCP key value.
	 * @return The instance.
	 * @throws IllegalArgumentException
	 *         if {@code key} is not a valid value
	 */
	public static ConfigurationKeys forKey(String key) {
		for ( ConfigurationKeys obj : ConfigurationKeys.values() ) {
			if ( obj.key.equals(key) ) {
				return obj;
			}
		}
		throw new IllegalArgumentException(key);
	}

}

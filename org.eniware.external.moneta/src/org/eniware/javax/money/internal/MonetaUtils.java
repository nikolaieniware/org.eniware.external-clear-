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

package org.eniware.javax.money.internal;

import java.util.Locale;
import javax.money.format.AmountFormatQueryBuilder;
import org.javamoney.moneta.format.CurrencyStyle;

/**
 * Utilities specific to the Moneta implementation of {@code javax.money}.
 * @version 1.0
 */
public final class MonetaUtils {

	private MonetaUtils() {
		// don't construct me
	}

	/**
	 * Get a amount format query builder that uses currency symbols.
	 * 
	 * <p>
	 * This method exists because Moneta requires an implementation-specific
	 * {@link CurrencySymbol} class to get the desired format.
	 * </p>
	 * 
	 * @param locale
	 *        the desired locale of the builder
	 * @return the builder
	 * @see https://github.com/JavaMoney/javamoney-examples/issues/25
	 */
	public static AmountFormatQueryBuilder ofSymbolCurrencyStyle(Locale locale) {
		return AmountFormatQueryBuilder.of(locale).set(CurrencyStyle.SYMBOL);
	}

}

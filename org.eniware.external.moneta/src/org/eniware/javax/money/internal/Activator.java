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

import javax.money.spi.Bootstrap;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Activator for the {@code javax.money} SPI using Moneta.
 * 
 * <p>
 * This will call {@code Bootstrap#init(javax.money.spi.ServiceProvider)},
 * passing in a {@link ClassLoaderServiceProvider} configured with this class'
 * {@code ClassLoader}.
 * </p>
 * @version 1.0
 */

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		Bootstrap.init(new ClassLoaderServiceProvider(getClass().getClassLoader()));
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		// nadda
	}

}

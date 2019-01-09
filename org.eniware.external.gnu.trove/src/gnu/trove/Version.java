//////////////////////////////////////////////////////////////////////////////
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
///////////////////////////////////////////////////////////////////////////////

package gnu.trove;

/* ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

public class Version {
    public static void main(String[] args) {
        System.out.println(getVersion());
    }

    /**
     * Returns the implementation version of trove4j. Intended for applications
     * wanting to return the version of trove4j they are using
     * <p/>
     * NOTE: this method will only return a useful version when working
     * with a trove4j jar as it requires a manifest file
     *
     * @return
     */
    public static String getVersion() {
        String version = Version.class.getPackage().getImplementationVersion();
        //
        if (version != null) {
            return "trove4j version " + version;
        }

        return "Sorry no Implementation-Version manifest attribute available";
    }
}

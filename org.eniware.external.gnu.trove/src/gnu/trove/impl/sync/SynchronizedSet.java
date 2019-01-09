// ////////////////////////////////////////////////////////////////////////////
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
///////////////////////////////////////////////////////////////////////////////

/* ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

package gnu.trove.impl.sync;

import java.util.Set;


/** Local implementation of SynchronizedSet so we can set the mutex explicitly. */
class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
	private static final long serialVersionUID = 487447009682186044L;

	SynchronizedSet( Set<E> s, Object mutex ) { super( s, mutex ); }
	public boolean equals( Object o ) { synchronized( mutex ) { return c.equals( o ); } }
	public int hashCode() { synchronized( mutex ) { return c.hashCode(); } }
}
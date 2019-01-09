// ////////////////////////////////////////////////////////////////////////////
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// ////////////////////////////////////////////////////////////////////////////

/*
 * ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

package gnu.trove.iterator;

/**
 * Common interface for iterators that operate via the "advance" method for moving the
 * cursor to the next element.
 */
public interface TAdvancingIterator extends TIterator {
    /**
     * Moves the iterator forward to the next entry.
     *
     * @throws java.util.NoSuchElementException if the iterator is already exhausted
     */
    public void advance();
}

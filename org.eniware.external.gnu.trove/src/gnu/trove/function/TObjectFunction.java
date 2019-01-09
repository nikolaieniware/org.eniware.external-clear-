//////////////////////////////////////////////////////////////////////////////

// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public
// License along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
///////////////////////////////////////////////////////////////////////////////

/* ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

package gnu.trove.function;

/**
 * Interface for functions that accept and return one Object reference.
 * <p/>
 * Created: Mon Nov  5 22:19:36 2001
 *
 * @author Eric D. Friedman
 * @version $Id: TObjectFunction.java,v 1.1.2.1 2009/09/06 17:02:19 upholderoftruth Exp $
 */

public interface TObjectFunction<T, R> {

    /**
     * Execute this function with <tt>value</tt>
     *
     * @param value an <code>Object</code> input
     * @return an <code>Object</code> result
     */
    public R execute( T value );
}// TObjectFunction

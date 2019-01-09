///////////////////////////////////////////////////////////////////////////////
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
///////////////////////////////////////////////////////////////////////////////

package gnu.trove.decorator;

import gnu.trove.list.TByteList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractList;
import java.util.List;


//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////


/* ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */


public class TByteListDecorator extends AbstractList<Byte>
	implements List<Byte>, Externalizable, Cloneable {

	static final long serialVersionUID = 1L;

    /** the wrapped primitive list */
    protected TByteList list;


    /**
     * FOR EXTERNALIZATION ONLY!!
     */
    public TByteListDecorator() {}


    /**
     * Creates a wrapper that decorates the specified primitive map.
     *
     * @param list the <tt>TByteList</tt> to wrap.
     */
    public TByteListDecorator( TByteList list ) {
        super();
        this.list = list;
    }


    /**
     * Returns a reference to the list wrapped by this decorator.
     *
     * @return the wrapped <tt>TByteList</tt> instance.
     */
    public TByteList getList() {
        return list;
    }


	@Override
	public int size() {
		return list.size();
	}


	@Override
	public Byte get( int index ) {
		byte value = list.get( index );
		if ( value == list.getNoEntryValue() ) return null;
		else return Byte.valueOf( value );
	}


	@Override
	public Byte set( int index, Byte value ) {
		byte previous_value = list.set( index, value );
		if ( previous_value == list.getNoEntryValue() ) return null;
		else return Byte.valueOf( previous_value );
	}


	@Override
	public void add( int index, Byte value ) {
		list.insert( index, value.byteValue() );
	}


	@Override
	public Byte remove( int index ) {
		byte previous_value = list.removeAt( index );
		if ( previous_value == list.getNoEntryValue() ) return null;
		else return Byte.valueOf( previous_value );
	}


	// Implements Externalizable
	public void readExternal( ObjectInput in )
        throws IOException, ClassNotFoundException {

        // VERSION
        in.readByte();

        // LIST
        list = ( TByteList ) in.readObject();
    }


    // Implements Externalizable
    public void writeExternal( ObjectOutput out ) throws IOException {
        // VERSION
        out.writeByte(0);

        // LIST
        out.writeObject( list );
    }

}

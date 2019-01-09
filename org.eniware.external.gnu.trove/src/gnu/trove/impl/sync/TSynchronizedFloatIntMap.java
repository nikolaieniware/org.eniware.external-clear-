///////////////////////////////////////////////////////////////////////////////
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

/* ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

package gnu.trove.impl.sync;


//////////////////////////////////////////////////
// THIS IS A GENERATED CLASS. DO NOT HAND EDIT! //
//////////////////////////////////////////////////

////////////////////////////////////////////////////////////
// THIS IS AN IMPLEMENTATION CLASS. DO NOT USE DIRECTLY!  //
// Access to these methods should be through TCollections //
////////////////////////////////////////////////////////////


import gnu.trove.iterator.*;
import gnu.trove.procedure.*;
import gnu.trove.set.*;
import gnu.trove.list.*;
import gnu.trove.function.*;
import gnu.trove.map.*;
import gnu.trove.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Random;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.IOException;


public class TSynchronizedFloatIntMap implements TFloatIntMap, Serializable {
	private static final long serialVersionUID = 1978198479659022715L;

	private final TFloatIntMap m;     // Backing Map
	final Object      mutex;	// Object on which to synchronize

	public TSynchronizedFloatIntMap( TFloatIntMap m ) {
		if ( m == null )
			throw new NullPointerException();
		this.m = m;
		mutex = this;
	}

	public TSynchronizedFloatIntMap( TFloatIntMap m, Object mutex ) {
		this.m = m;
		this.mutex = mutex;
	}

	public int size() {
		synchronized( mutex ) { return m.size(); }
	}
	public boolean isEmpty(){
		synchronized( mutex ) { return m.isEmpty(); }
	}
	public boolean containsKey( float key ) {
		synchronized( mutex ) { return m.containsKey( key ); }
	}
	public boolean containsValue( int value ){
		synchronized( mutex ) { return m.containsValue( value ); }
	}
	public int get( float key ) {
		synchronized( mutex ) { return m.get( key ); }
	}

	public int put( float key, int value ) {
		synchronized( mutex ) { return m.put( key, value ); }
	}
	public int remove( float key ) {
		synchronized( mutex ) { return m.remove( key ); }
	}
	public void putAll( Map<? extends Float, ? extends Integer> map ) {
		synchronized( mutex ) { m.putAll( map ); }
	}
	public void putAll( TFloatIntMap map ) {
		synchronized( mutex ) { m.putAll( map ); }
	}
	public void clear() {
		synchronized( mutex ) { m.clear(); }
	}

	private transient TFloatSet keySet = null;
	private transient TIntCollection values = null;

	public TFloatSet keySet() {
		synchronized( mutex ) {
			if ( keySet == null )
				keySet = new TSynchronizedFloatSet( m.keySet(), mutex );
			return keySet;
		}
	}
	public float[] keys() {
		synchronized( mutex ) { return m.keys(); }
	}
	public float[] keys( float[] array ) {
		synchronized( mutex ) { return m.keys( array ); }
	}

	public TIntCollection valueCollection() {
		synchronized( mutex ) {
			if ( values == null )
				values = new TSynchronizedIntCollection( m.valueCollection(), mutex );
			return values;
		}
	}
	public int[] values() {
		synchronized( mutex ) { return m.values(); }
	}
	public int[] values( int[] array ) {
		synchronized( mutex ) { return m.values( array ); }
	}

	public TFloatIntIterator iterator() {
		return m.iterator(); // Must be manually synched by user!
	}

	// these are unchanging over the life of the map, no need to lock
	public float getNoEntryKey() { return m.getNoEntryKey(); }
	public int getNoEntryValue() { return m.getNoEntryValue(); }

	public int putIfAbsent( float key, int value ) {
		synchronized( mutex ) { return m.putIfAbsent( key, value ); }
	}
	public boolean forEachKey( TFloatProcedure procedure ) {
		synchronized( mutex ) { return m.forEachKey( procedure ); }
	}
	public boolean forEachValue( TIntProcedure procedure ) {
		synchronized( mutex ) { return m.forEachValue( procedure ); }
	}
	public boolean forEachEntry( TFloatIntProcedure procedure ) {
		synchronized( mutex ) { return m.forEachEntry( procedure ); }
	}
	public void transformValues( TIntFunction function ) {
		synchronized( mutex ) { m.transformValues( function ); }
	}
	public boolean retainEntries( TFloatIntProcedure procedure ) {
		synchronized( mutex ) { return m.retainEntries( procedure ); }
	}
	public boolean increment( float key ) {
		synchronized( mutex ) { return m.increment( key ); }
	}
	public boolean adjustValue( float key, int amount ) {
		synchronized( mutex ) { return m.adjustValue( key, amount ); }
	}
	public int adjustOrPutValue( float key, int adjust_amount, int put_amount ) {
		synchronized( mutex ) { return m.adjustOrPutValue( key, adjust_amount, put_amount ); }
	}

	public boolean equals( Object o ) {
		synchronized( mutex ) { return m.equals( o ); }
	}
	public int hashCode() {
		synchronized( mutex ) { return m.hashCode(); }
	}
	public String toString() {
		synchronized( mutex ) { return m.toString(); }
	}
	private void writeObject( ObjectOutputStream s ) throws IOException {
		synchronized( mutex ) { s.defaultWriteObject(); }
	}
}

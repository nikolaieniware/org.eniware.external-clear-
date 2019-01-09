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

/*
 * ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */


package gnu.trove.procedure.array;

import gnu.trove.procedure.TObjectProcedure;



/**
 * A procedure which stores each value it receives into a target array.
 * <p/>
 * @version $Id: ToObjectArrayProceedure.java,v 1.1.2.1
 */

public final class ToObjectArrayProceedure<T> implements TObjectProcedure<T> {

    private final T[] target;
    private int pos = 0;


    public ToObjectArrayProceedure( final T[] target ) {
        this.target = target;
    }


    public final boolean execute( T value ) {
        target[pos++] = value;
        return true;
    }
} // ToObjectArrayProcedure
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

package gnu.trove.list;

import java.io.Serializable;



/**
 * Interface for Objects which can be inserted into a TLinkedList.
 *
 * @author Eric D. Friedman
 * @version $Id: TLinkable.java,v 1.1.2.2 2009/09/04 12:32:33 upholderoftruth Exp $
 * @see gnu.trove.list.linked.TLinkedList
 */

public interface TLinkable<T extends TLinkable> extends Serializable {
	static final long serialVersionUID = 997545054865482562L;

    /**
     * Returns the linked list Edge after this one.
     *
     * @return a <code>TLinkable</code> value
     */
    public T getNext();


    /**
     * Returns the linked list Edge before this one.
     *
     * @return a <code>TLinkable</code> value
     */
    public T getPrevious();


    /**
     * Sets the linked list Edge after this one.
     *
     * @param linkable a <code>TLinkable</code> value
     */
    public void setNext( T linkable );


    /**
     * Sets the linked list Edge before this one.
     *
     * @param linkable a <code>TLinkable</code> value
     */
    public void setPrevious( T linkable );
}// TLinkable

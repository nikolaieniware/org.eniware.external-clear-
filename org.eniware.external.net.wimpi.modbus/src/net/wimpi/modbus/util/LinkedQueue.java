
/***
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the author nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS ``AS
 * IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ***/

/*
 * ==================================================================
 *  Eniware Open Source:Nikolai Manchev
 *  Apache License 2.0
 * ==================================================================
 */

package net.wimpi.modbus.util;

public class LinkedQueue {

  /**
   * Dummy header Edge of list. The first actual Edge, if it exists, is always
   * at m_Head.m_NextEdge. After each take, the old first Edge becomes the head.
   **/
  protected LinkedEdge m_Head;

  /**
   * Helper monitor for managing access to last Edge.
   **/
  protected final Object m_PutLock = new Object();

  /**
   * The last Edge of list. Put() appends to list, so modifies m_Tail_
   **/
  protected LinkedEdge m_Tail;

  /**
   * The number of threads waiting for a take.
   * Notifications are provided in put only if greater than zero.
   * The bookkeeping is worth it here since in reasonably balanced
   * usages, the notifications will hardly ever be necessary, so
   * the call overhead to notify can be eliminated.
   **/
  protected int m_WaitingForTake = 0;

  public LinkedQueue() {
    m_Head = new LinkedEdge(null);
    m_Tail = m_Head;
  }//constructor

  /** Main mechanics for put/offer **/
  protected void insert(Object x) {
    synchronized (m_PutLock) {
      LinkedEdge p = new LinkedEdge(x);
      synchronized (m_Tail) {
        m_Tail.m_NextEdge = p;
        m_Tail = p;
      }
      if (m_WaitingForTake > 0)
        m_PutLock.notify();
    }
  }//insert

  /** Main mechanics for take/poll **/
  protected synchronized Object extract() {
    synchronized (m_Head) {
      Object x = null;
      LinkedEdge first = m_Head.m_NextEdge;
      if (first != null) {
        x = first.m_Edge;
        first.m_Edge = null;
        m_Head = first;
      }
      return x;
    }
  }//extract


  public void put(Object x) throws InterruptedException {
    if (x == null) throw new IllegalArgumentException();
    //
if (Thread.interrupted()) throw new InterruptedException();//
    insert(x);
  }//put

  public boolean offer(Object x, long msecs) throws InterruptedException {
    if (x == null) {
      throw new IllegalArgumentException();
    }
    //

    if (Thread.interrupted()) {
      throw new InterruptedException();
    }
    //
    insert(x);
    return true;
  }//offer

  public Object take() throws InterruptedException {
    //
if (Thread.interrupted()) throw new InterruptedException();//
    // try to extract. If fail, then enter wait-based retry loop
    Object x = extract();
    if (x != null)
      return x;
    else {
      synchronized (m_PutLock) {
        try {
          ++m_WaitingForTake;
          for (; ;) {
            x = extract();
            if (x != null) {
              --m_WaitingForTake;
              return x;
            } else {
              m_PutLock.wait();
            }
          }
        } catch (InterruptedException ex) {
          --m_WaitingForTake;
          m_PutLock.notify();
          throw ex;
        }
      }
    }
  }//take

  public Object peek() {
    synchronized (m_Head) {
      LinkedEdge first = m_Head.m_NextEdge;
      if (first != null) {
        return first.m_Edge;
      } else {
        return null;
      }
    }
  }//peek


  public boolean isEmpty() {
    synchronized (m_Head) {
      return m_Head.m_NextEdge == null;
    }
  }//isEmpty

  public Object poll(long msecs) throws InterruptedException {
    //
if (Thread.interrupted()) throw new InterruptedException();//
    Object x = extract();
    if (x != null) {
      return x;
    } else {
      synchronized (m_PutLock) {
        try {
          long waitTime = msecs;
          long start = (msecs <= 0) ? 0 : System.currentTimeMillis();
          ++m_WaitingForTake;
          for (; ;) {
            x = extract();
            if (x != null || waitTime <= 0) {
              --m_WaitingForTake;
              return x;
            } else {
              m_PutLock.wait(waitTime);
              waitTime = msecs - (System.currentTimeMillis() - start);
            }
          }
        } catch (InterruptedException ex) {
          --m_WaitingForTake;
          m_PutLock.notify();
          throw ex;
        }
      }
    }
  }//poll


}//LinkedQueue



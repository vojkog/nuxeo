/*
 * (C) Copyright 2009 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Florent Guillaume
 */

package org.nuxeo.ecm.core.storage;

import java.io.Serializable;
import java.util.List;

/**
 * The bundling of a list and a total size.
 * <p>
 * The list MUST be {@link Serializable}.
 */
public class PartialList<E> implements Serializable {

    private static final long serialVersionUID = 1L;

    public final List<E> list;

    public final long totalSize;

    /**
     * Constructs a partial list.
     * <p>
     * The list MUST be {@link Serializable}.
     *
     * @param list the list (MUST be {@link Serializable})
     * @param totalSize the total size
     */
    public PartialList(List<E> list, long totalSize) {
        this.list = list;
        this.totalSize = totalSize;
    }

}
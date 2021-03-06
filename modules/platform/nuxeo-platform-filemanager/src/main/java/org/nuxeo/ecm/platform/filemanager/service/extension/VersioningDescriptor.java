/*
 * (C) Copyright 2006-2017 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Thierry Martins
 *     Florent Guillaume
 */
package org.nuxeo.ecm.platform.filemanager.service.extension;

import org.nuxeo.common.xmap.annotation.XNode;
import org.nuxeo.common.xmap.annotation.XObject;
import org.nuxeo.runtime.model.Descriptor;

/**
 * @since 5.7
 * @deprecated since 9.1 automatic versioning mechanism has been moved to versioning service
 */
@Deprecated
@XObject("versioning")
public class VersioningDescriptor implements Descriptor {

    @XNode("defaultVersioningOption")
    public String defaultVersioningOption;

    @XNode("versionAfterAdd")
    public Boolean versionAfterAdd;

    @Override
    public String getId() {
        return toString();
    }
}

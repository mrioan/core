/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.switchyard.config.model.switchyard;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

import org.switchyard.config.model.ModelResource;

/**
 * DefaultSwitchYardScanner.
 *
 * @author David Ward &lt;<a href="mailto:dward@jboss.org">dward@jboss.org</a>&gt; (C) 2011 Red Hat Inc.
 */
public class DefaultSwitchYardScanner implements SwitchYardScanner {

    @Override
    public List<SwitchYardModel> scan(List<URL> urls) throws IOException {
        SwitchYardModel switchyard = (SwitchYardModel)new ModelResource().pull("/META-INF/switchyard.xml");
        if (switchyard != null) {
            return Collections.singletonList(switchyard);
        } else {
            return Collections.emptyList();
        }
    }

}

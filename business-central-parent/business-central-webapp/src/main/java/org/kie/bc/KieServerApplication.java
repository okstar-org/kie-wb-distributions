/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.bc;


import org.kie.server.controller.rest.RestKieServerControllerImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;


@ApplicationPath("/")
public class KieServerApplication extends Application {

    private final Set<Object> instances;

    public KieServerApplication() {
        instances = new CopyOnWriteArraySet<Object>() {
            {
                add(new RestKieServerControllerImpl());
            }
        };
    }

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.emptySet();
    }

    @Override
    public Set<Object> getSingletons() {
        return instances;
    }

}

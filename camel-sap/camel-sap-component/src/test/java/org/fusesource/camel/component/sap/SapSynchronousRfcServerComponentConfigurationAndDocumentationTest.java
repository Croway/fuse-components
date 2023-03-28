/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.camel.component.sap;


import java.net.URI;
import java.util.Map;

import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.util.URISupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SapSynchronousRfcServerComponentConfigurationAndDocumentationTest extends CamelTestSupport {

    @Override
    public boolean isUseRouteBuilder() {
        return false;
    }

    @Test
    public void testComponentConfiguration() throws Exception {
        SapSynchronousRfcServerComponent comp = context.getComponent("sap-srfc-server", SapSynchronousRfcServerComponent.class);
        SapSynchronousRfcServerEndpoint endpoint = new SapSynchronousRfcServerEndpoint("sap-srfc-server:serverName:rfcName?stateful=true", comp);
        String fullEndpointUri = endpoint.getEndpointUri();
        URI uri = new URI(fullEndpointUri);
        Map<String, Object> parameters = URISupport.parseParameters(uri);
        
        assertEquals("true", parameters.get("stateful"));

    }

}

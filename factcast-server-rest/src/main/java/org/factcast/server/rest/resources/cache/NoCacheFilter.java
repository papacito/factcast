//
//
// Copyright 2017-2018 Mercateo AG <uwe.schaefer@mercateo.com>
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.factcast.server.rest.resources.cache;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.HttpHeaders;

import lombok.NonNull;

/**
 * Filter for inserting a HTTP-Header for not caching the response seconds
 * 
 * @author joerg_adler
 *
 */
@NoCache
@Priority(Priorities.HEADER_DECORATOR)
public class NoCacheFilter implements ContainerResponseFilter {

    @Override
    public void filter(@NonNull ContainerRequestContext requestContext,
            @NonNull ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().putSingle(HttpHeaders.CACHE_CONTROL, "no-cache");
    }

}

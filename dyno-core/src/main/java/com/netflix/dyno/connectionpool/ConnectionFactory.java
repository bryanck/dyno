/*******************************************************************************
 * Copyright 2011 Netflix
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.netflix.dyno.connectionpool;

import com.netflix.dyno.connectionpool.exception.DynoConnectException;
import com.netflix.dyno.connectionpool.exception.ThrottledException;


/**
 * Factory used to create and open new connections on a host.
 *
 * @param <CL>
 * @author poberai
 */
public interface ConnectionFactory<CL> {

    /**
     * Create a connection for this {@link HostConnectionPool}
     *
     * @param pool
     * @return
     * @throws DynoConnectException
     * @throws ThrottledException
     */
    Connection<CL> createConnection(HostConnectionPool<CL> pool) throws DynoConnectException;

    Connection<CL> createConnectionWithDataStore(HostConnectionPool<CL> pool)
            throws DynoConnectException;

    Connection<CL> createConnectionWithConsistencyLevel(HostConnectionPool<CL> pool, String consistency)
            throws DynoConnectException;
}

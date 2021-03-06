package org.apache.maven.cli.logging;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.codehaus.plexus.util.PropertyUtils;
import org.slf4j.ILoggerFactory;

/**
 * Slf4jConfiguration factory, loading implementations from <code>META-INF/maven/slf4j-configuration.properties</code>
 * configuration files in class loader.
 *
 * @author Hervé Boutemy
 */
public class Slf4jConfigurationFactory
{
    public static final String RESOURCE = "META-INF/maven/slf4j-configuration.properties";

    public static Slf4jConfiguration getConfiguration( ILoggerFactory loggerFactory )
    {
        try
        {
            Enumeration<URL> resources = Slf4jConfigurationFactory.class.getClassLoader().getResources( RESOURCE );

            String key = loggerFactory.getClass().getCanonicalName();

            while ( resources.hasMoreElements() )
            {
                URL resource = resources.nextElement();

                Properties conf = PropertyUtils.loadProperties( resource.openStream() );

                String impl = conf.getProperty( key );

                if ( impl != null )
                {
                    return (Slf4jConfiguration) Class.forName( impl ).newInstance();
                }
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        catch ( InstantiationException e )
        {
            e.printStackTrace();
        }
        catch ( IllegalAccessException e )
        {
            e.printStackTrace();
        }
        catch ( ClassNotFoundException e )
        {
            e.printStackTrace();
        }

        return new BaseSlf4jConfiguration();
    }
}

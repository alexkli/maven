package org.apache.maven;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 * If there was an error in the settings file.
 * 
 * @deprecated use {@link org.apache.maven.settings.SettingsConfigurationException}
 *
 * @author <a href="mailto:brett@apache.org">Brett Porter</a>
 * @version $Id$
 */
public class SettingsConfigurationException
    extends org.apache.maven.settings.SettingsConfigurationException
{
    public SettingsConfigurationException( String message )
    {
        super( message );
    }

    public SettingsConfigurationException( String message, Throwable cause )
    {
        super( message, cause );
    }

    public SettingsConfigurationException( String message, Throwable cause, int lineNumber, int columnNumber )
    {
        super( message, cause, lineNumber, columnNumber );
    }

}
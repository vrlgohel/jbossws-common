/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.ws.common.deployment;

import java.net.URL;

import org.jboss.wsf.spi.metadata.webservices.WebservicesDescriptorParser;
import org.jboss.wsf.spi.metadata.webservices.WebservicesFactory;
import org.jboss.wsf.spi.metadata.webservices.WebservicesMetaData;

/**
 * Webservices descriptor parser implementation.
 * 
 * @author <a href="ropalka@redhat.com">Richard Opalka</a>
 * @author alessio.soldano@jboss.com
 */
public final class WebservicesDescriptorParserImpl implements WebservicesDescriptorParser
{
   private String descriptorName;
   
   @Override
   public String getDescriptorName()
   {
      return this.descriptorName;
   }

   /**
    * Invoked via MC.
    * @param descriptorName
    */
   public void setDescriptorName(final String descriptorName)
   {
      this.descriptorName = descriptorName;
   }

   @Override
   public WebservicesMetaData parse(URL url)
   {
      return new WebservicesFactory(url).load(url);
   }
}

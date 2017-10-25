/*
 * Copyright (c) 2002-2017, Mairie de Paris
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */ 
package fr.paris.lutece.plugins.recast.business;

import java.util.List;
import java.util.List;


/**
 * This is the business class for the object NLP
 */ 
public class NLP
{
        // Variables declarations 
        private String _strUuid;
        private String _strSource;
        private String _strAct;
        private List<Intent> _listIntents;
        private List<Entity> _listEntities;
        private String _strLanguage;
        private String _strProcessingLanguage;
        private String _strVersion;
        private String _strTimestamp;
        private int _nStatus;
    
    
       /**
        * Returns the Uuid
        * @return The Uuid
        */ 
        public String getUuid()
        {
            return _strUuid;
        }
    
       /**
        * Sets the Uuid
        * @param strUuid The Uuid
        */ 
        public void setUuid( String strUuid )
        {
            _strUuid = strUuid;
        }
    
       /**
        * Returns the Source
        * @return The Source
        */ 
        public String getSource()
        {
            return _strSource;
        }
    
       /**
        * Sets the Source
        * @param strSource The Source
        */ 
        public void setSource( String strSource )
        {
            _strSource = strSource;
        }
    
       /**
        * Returns the Act
        * @return The Act
        */ 
        public String getAct()
        {
            return _strAct;
        }
    
       /**
        * Sets the Act
        * @param strAct The Act
        */ 
        public void setAct( String strAct )
        {
            _strAct = strAct;
        }
    
       /**
        * Returns the Intents
        * @return The Intents
        */ 
        public List<Intent> getIntents()
        {
            return _listIntents;
        }
    
       /**
        * Sets the Intents
        * @param listIntents The Intents
        */ 
        public void setIntents( List<Intent> listIntents )
        {
            _listIntents = listIntents;
        }
    
       /**
        * Returns the Entities
        * @return The Entities
        */ 
        public List<Entity> getEntities()
        {
            return _listEntities;
        }
    
       /**
        * Sets the Entities
        * @param listEntities The Entities
        */ 
        public void setEntities( List<Entity> listEntities )
        {
            _listEntities = listEntities;
        }
    
       /**
        * Returns the Language
        * @return The Language
        */ 
        public String getLanguage()
        {
            return _strLanguage;
        }
    
       /**
        * Sets the Language
        * @param strLanguage The Language
        */ 
        public void setLanguage( String strLanguage )
        {
            _strLanguage = strLanguage;
        }
    
       /**
        * Returns the ProcessingLanguage
        * @return The ProcessingLanguage
        */ 
        public String getProcessingLanguage()
        {
            return _strProcessingLanguage;
        }
    
       /**
        * Sets the ProcessingLanguage
        * @param strProcessingLanguage The ProcessingLanguage
        */ 
        public void setProcessingLanguage( String strProcessingLanguage )
        {
            _strProcessingLanguage = strProcessingLanguage;
        }
    
       /**
        * Returns the Version
        * @return The Version
        */ 
        public String getVersion()
        {
            return _strVersion;
        }
    
       /**
        * Sets the Version
        * @param strVersion The Version
        */ 
        public void setVersion( String strVersion )
        {
            _strVersion = strVersion;
        }
    
       /**
        * Returns the Timestamp
        * @return The Timestamp
        */ 
        public String getTimestamp()
        {
            return _strTimestamp;
        }
    
       /**
        * Sets the Timestamp
        * @param strTimestamp The Timestamp
        */ 
        public void setTimestamp( String strTimestamp )
        {
            _strTimestamp = strTimestamp;
        }
    
       /**
        * Returns the Status
        * @return The Status
        */ 
        public int getStatus()
        {
            return _nStatus;
        }
    
       /**
        * Sets the Status
        * @param nStatus The Status
        */ 
        public void setStatus( int nStatus )
        {
            _nStatus = nStatus;
        }
 }

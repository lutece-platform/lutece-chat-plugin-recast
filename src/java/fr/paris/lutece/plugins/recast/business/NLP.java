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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * This is the business class for the object NLP
 */
public class NLP implements Serializable
{
    // Variables declarations
    private String _strUuid;
    private String _strSource;
    private String _strAct;
    private List<Intent> _listIntents;
    private Map<String, Entity> _mapEntities;
    private String _strLanguage;
    private String _strProcessingLanguage;
    private String _strType;
    private String _strSentiment;
    private String _strVersion;
    private String _strTimestamp;
    private int _nStatus;

    /**
     * Returns the Uuid
     * 
     * @return The Uuid
     */
    public String getUuid( )
    {
        return _strUuid;
    }

    /**
     * Sets the Uuid
     * 
     * @param strUuid
     *            The Uuid
     */
    public void setUuid( String strUuid )
    {
        _strUuid = strUuid;
    }

    /**
     * Returns the Source
     * 
     * @return The Source
     */
    public String getSource( )
    {
        return _strSource;
    }

    /**
     * Sets the Source
     * 
     * @param strSource
     *            The Source
     */
    public void setSource( String strSource )
    {
        _strSource = strSource;
    }

    /**
     * Returns the Act
     * 
     * @return The Act
     */
    public String getAct( )
    {
        return _strAct;
    }

    /**
     * Sets the Act
     * 
     * @param strAct
     *            The Act
     */
    public void setAct( String strAct )
    {
        _strAct = strAct;
    }

    /**
     * Returns the Intents
     * 
     * @return The Intents
     */
    public List<Intent> getIntents( )
    {
        return _listIntents;
    }

    /**
     * Sets the Intents
     * 
     * @param listIntents
     *            The Intents
     */
    public void setIntents( List<Intent> listIntents )
    {
        _listIntents = listIntents;
    }

    /**
     * Returns the Entities
     * 
     * @return The Entities
     */
    public Map<String, Entity> getEntities( )
    {
        return _mapEntities;
    }

    /**
     * Sets the Entities
     * 
     * @param mapEntities
     *            The Entities
     */
    public void setEntities( Map<String, Entity> mapEntities )
    {
        _mapEntities = mapEntities;
    }

    /**
     * Returns the Language
     * 
     * @return The Language
     */
    public String getLanguage( )
    {
        return _strLanguage;
    }

    /**
     * Sets the Language
     * 
     * @param strLanguage
     *            The Language
     */
    public void setLanguage( String strLanguage )
    {
        _strLanguage = strLanguage;
    }

    /**
     * Returns the ProcessingLanguage
     * 
     * @return The ProcessingLanguage
     */
    public String getProcessingLanguage( )
    {
        return _strProcessingLanguage;
    }

    /**
     * Sets the ProcessingLanguage
     * 
     * @param strProcessingLanguage
     *            The ProcessingLanguage
     */
    @JsonProperty( "processing_language" )
    public void setProcessingLanguage( String strProcessingLanguage )
    {
        _strProcessingLanguage = strProcessingLanguage;
    }

    /**
     * Returns the Version
     * 
     * @return The Version
     */
    public String getVersion( )
    {
        return _strVersion;
    }

    /**
     * Sets the Version
     * 
     * @param strVersion
     *            The Version
     */
    public void setVersion( String strVersion )
    {
        _strVersion = strVersion;
    }

    /**
     * Returns the Type
     * 
     * @return The Type
     */
    public String getType( )
    {
        return _strType;
    }

    /**
     * Sets the Type
     * 
     * @param strType
     *            The Type
     */
    public void setType( String strType )
    {
        _strType = strType;
    }

    /**
     * Returns the Sentiment
     * 
     * @return The Sentiment
     */
    public String getSentiment( )
    {
        return _strSentiment;
    }

    /**
     * Sets the Sentiment
     * 
     * @param strSentiment
     *            The Sentiment
     */
    public void setSentiment( String strSentiment )
    {
        _strSentiment = strSentiment;
    }

    /**
     * Returns the Timestamp
     * 
     * @return The Timestamp
     */
    public String getTimestamp( )
    {
        return _strTimestamp;
    }

    /**
     * Sets the Timestamp
     * 
     * @param strTimestamp
     *            The Timestamp
     */
    public void setTimestamp( String strTimestamp )
    {
        _strTimestamp = strTimestamp;
    }

    /**
     * Returns the Status
     * 
     * @return The Status
     */
    public int getStatus( )
    {
        return _nStatus;
    }

    /**
     * Sets the Status
     * 
     * @param nStatus
     *            The Status
     */
    public void setStatus( int nStatus )
    {
        _nStatus = nStatus;
    }
}

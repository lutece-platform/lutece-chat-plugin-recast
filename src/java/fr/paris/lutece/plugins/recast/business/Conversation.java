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
 * Conversation
 */
public class Conversation implements Serializable
{

    // Variables declarations
    private String _strId;
    private String _strLanguage;
    private Map<String, Object> _mapMemory;
    private String _strSkill;
    private int _nSkillOccurences;

    /**
     * Returns the Id
     * 
     * @return The Id
     */
    public String getId( )
    {
        return _strId;
    }

    /**
     * Sets the Id
     * 
     * @param strId
     *            The Id
     */
    public void setId( String strId )
    {
        _strId = strId;
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
     * Returns the Memory
     * 
     * @return The Memory
     */
    public Map<String, Object> getMemory( )
    {
        return _mapMemory;
    }

    /**
     * Sets the Memory
     * 
     * @param mapMemory
     *            The Memory
     */
    public void setMemory( Map<String, Object> mapMemory )
    {
        _mapMemory = mapMemory;
    }

    /**
     * Returns the Skill
     * 
     * @return The Skill
     */
    public String getSkill( )
    {
        return _strSkill;
    }

    /**
     * Sets the Skill
     * 
     * @param strSkill
     *            The Skill
     */
    public void setSkill( String strSkill )
    {
        _strSkill = strSkill;
    }

    /**
     * Returns the SkillOccurences
     * 
     * @return The SkillOccurences
     */
    public int getSkillOccurences( )
    {
        return _nSkillOccurences;
    }

    /**
     * Sets the SkillOccurences
     * 
     * @param nSkillOccurences
     *            The SkillOccurences
     */
    @JsonProperty( "skill_occurences" )
    public void setSkillOccurences( int nSkillOccurences )
    {
        _nSkillOccurences = nSkillOccurences;
    }
}

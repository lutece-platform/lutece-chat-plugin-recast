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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.paris.lutece.plugins.recast.service.card.CardRenderer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


/**
 * Message
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public class Message extends HashMap<String, Object> implements Serializable
{
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_CARD = "card";
    private static final String FIELD_TYPE = "type";
    private static final String FIELD_CONTENT = "content";

   
    /**
     * Returns the Type
     * 
     * @return The Type
     */
    public String getType( )
    {
        return (String) get( FIELD_TYPE );
    }

   /**
     * Returns the Content
     * 
     * @return The Content
     */
    public String getContent()
    {
        return getContent( null );
    }
    
    
    /**
     * Returns the Content
     * 
     * @param renderer Card Renderer
     * @return The Content
     */
    public String getContent( CardRenderer renderer )
    {
        String strType = getType ();
        if( strType.equals( TYPE_TEXT ))
        {
            return (String) get( FIELD_CONTENT );
        }
        if( strType.equals( TYPE_CARD ) && renderer != null )
        {
            Map mapCard = (Map) get( FIELD_CONTENT );
            return renderer.render( mapCard );
        }
        return "";
    }
   
}

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
import java.io.Serializable;
import java.util.List;

/**
 * DialogResponse
 */
@JsonIgnoreProperties( ignoreUnknown = true )
public class DialogResponse implements Serializable
{
    // Variables declarations
    private List<Message> _listMessages;
    private Conversation _conversation;
    private NLP _nlp;

    /**
     * Returns the Messages
     * 
     * @return The Messages
     */
    public List<Message> getMessages( )
    {
        return _listMessages;
    }

    /**
     * Sets the Messages
     * 
     * @param listMessages
     *            The Messages
     */
    public void setMessages( List<Message> listMessages )
    {
        _listMessages = listMessages;
    }

    /**
     * Returns the Conversation
     * 
     * @return The Conversation
     */
    public Conversation getConversation( )
    {
        return _conversation;
    }

    /**
     * Sets the Conversation
     * 
     * @param conversation
     *            The Conversation
     */
    public void setConversation( Conversation conversation )
    {
        _conversation = conversation;
    }

    /**
     * Returns the Nlp
     * 
     * @return The Nlp
     */
    public NLP getNlp( )
    {
        return _nlp;
    }

    /**
     * Sets the Nlp
     * 
     * @param nlp
     *            The Nlp
     */
    public void setNlp( NLP nlp )
    {
        _nlp = nlp;
    }
}

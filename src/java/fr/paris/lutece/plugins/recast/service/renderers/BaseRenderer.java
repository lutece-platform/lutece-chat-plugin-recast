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

package fr.paris.lutece.plugins.recast.service.renderers;

import fr.paris.lutece.plugins.recast.service.BotMessageRenderer;
import fr.paris.lutece.portal.service.template.AppTemplateService;
import fr.paris.lutece.portal.web.l10n.LocaleService;
import fr.paris.lutece.util.html.HtmlTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseRenderer
 */
public class BaseRenderer implements BotMessageRenderer
{
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_SUBTITLE = "subtitle";
    public static final String FIELD_BUTTONS = "buttons";
    public static final String FIELD_VALUE = "value";
    private static final String MARK_CONTENT = "content";

    private String _strMessageType;
    private String _strTemplate;

    

    /**
     * {@inheritDoc }
     */
    @Override
    public String render( Object content )
    {

        Map mapContent = (Map) content;
        Map<String, Object> model = new HashMap<>( );
        model.put( MARK_CONTENT, mapContent );
        HtmlTemplate template = AppTemplateService.getTemplate( _strTemplate , LocaleService.getDefault( ), model );

        return template.getHtml( );
    }

    /**
     * Get message title
     * @param mapContent The map content
     * @return The title
     */
    protected String getTitle( Map<String, Object> mapContent )
    {
        return (String) mapContent.get( FIELD_TITLE );
    }

    /**
     * Get message subtitle
     * @param mapContent The map content
     * @return The subtitle
     */
    protected String getSubTitle( Map<String, Object> mapContent )
    {
        return (String) mapContent.get( FIELD_SUBTITLE );
    }

    /**
     * Gets the buttons list
     * @param mapContent The content
     * @return The list
     */
    protected List<Map<String, Object>> getButtons( Map<String, Object> mapContent )
    {
        return (List<Map<String, Object>>) mapContent.get( FIELD_BUTTONS );
    }

    /**
     * The button title 
     * @param mapButton the button map
     * @return the button title
     */
    protected String getButtonTitle( Map<String, Object> mapButton )
    {
        return (String) mapButton.get( FIELD_TITLE );
    }

    /**
     * The button value
     * @param mapButton The button map
     * @return the button value
     */
    protected String getButtonValue( Map<String, Object> mapButton )
    {
        return (String) mapButton.get( FIELD_VALUE );
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public String getMessageType()
    {
        return _strMessageType;
    }
    /**
     * Set the message type
     * @param strType The type
     */
    public void setMessageType( String strType )
    {
        _strMessageType = strType;
    }
    
    /**
     * Set the template to convert from JSON to HTML 
     * @param strTemplate The template
     */
    public void setTemplate( String strTemplate )
    {
        _strTemplate = strTemplate;
    }
    
    /**
     * Returns the template
     * @return the template
     */
    public String getTemplate()
    {
        return _strTemplate;
    }
}

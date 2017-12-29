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
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TextRenderer
 */
public class TextRenderer implements BotMessageRenderer
{
    private static final String TEMPLATE_LINK = "skin/plugins/recast/link.html";
    private static final String MARK_URL = "url";
    private static final String MESSAGE_TYPE = "text";

    // Pattern for recognizing a URL, based off RFC 3986
    private static final Pattern PATTERN_URL = Pattern.compile( "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)" + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
            + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL );

     /**
     * {@inheritDoc }
     */
    @Override
    public String getMessageType()
    {
        return MESSAGE_TYPE;
    }
    
   /**
     * {@inheritDoc }
     */
    @Override
    public String render( Object content )
    {
        String strContent = (String) content;
        StringBuilder sbRendered = new StringBuilder( );
        Matcher matcher = PATTERN_URL.matcher( strContent );
        int nPos = 0;
        while ( matcher.find( ) )
        {
            int nMatchStart = matcher.start( 1 );
            int nMatchEnd = matcher.end( );
            String strUrl = strContent.substring( nMatchStart, nMatchEnd );
            sbRendered.append( strContent.substring( nPos, nMatchStart ) );
            sbRendered.append( linkBuilder( strUrl ) );
            nPos = nMatchEnd;
        }
        sbRendered.append( strContent.substring( nPos ) );

        String strRendered = sbRendered.toString( );

        strRendered = strRendered.replace( '\n', ' ' );
        strRendered = strRendered.replace( '\r', ' ' );

        return strRendered;
    }
    
    /**
     * Build an HTML link for a given URL
     * @param strUrl The URL
     * @return The link code
     */
    private String linkBuilder( String strUrl )
    {
        Map<String, Object> model = new HashMap<>();
        model.put( MARK_URL , strUrl );
        HtmlTemplate template = AppTemplateService.getTemplate( TEMPLATE_LINK , LocaleService.getDefault(), model );
        return template.getHtml();
    }

}

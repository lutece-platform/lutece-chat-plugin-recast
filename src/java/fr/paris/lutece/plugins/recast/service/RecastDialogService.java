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
package fr.paris.lutece.plugins.recast.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.paris.lutece.plugins.recast.business.DialogResponse;
import fr.paris.lutece.portal.service.util.AppLogService;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * RecastDialogService
 */
public final class RecastDialogService
{
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String PROPERTY_DIALOG_API_URL = "recast.dialog.api.url";
    private static final String PROPERTY_DEBUG = "recast.debug";
    private static final String LOGGER_NAME = "recast";
    private static final Logger LOGGER = Logger.getLogger( LOGGER_NAME );

    private static ObjectMapper _mapper = new ObjectMapper( );


    /** Private constructor */
    private RecastDialogService( )
    {
    }

    /**
     * Call the Dialog API
     *
     * @param strText
     *            The message
     * @param strConversationId
     *            The consersation ID
     * @param strToken
     *            The Recast bot token
     * @param strLanguage
     *            The language
     * @return The Dialog response
     * @throws HttpAccessException
     *             If an error occurs
     * @throws IOException
     *             If an error occurs
     */
    public static DialogResponse getDialogResponse( String strText, String strConversationId, String strToken, String strLanguage ) throws HttpAccessException,
            IOException
    {
        DialogResponse response;
        HttpAccess client = new HttpAccess( );
        String strURL = AppPropertiesService.getProperty( PROPERTY_DIALOG_API_URL );
        String strJson = getJson( strText, strConversationId, strLanguage );
        Map<String, String> mapHeaders = getHeaders( strToken );
        String strResponse = client.doPostJSON( strURL, strJson, mapHeaders, null );
        trace( strText , strResponse );
        response = parse( strResponse );
        return response;
    }

    /**
     * Parse the response
     *
     * @param strJSON
     *            The response as JSON
     * @return The DialogResponse object
     * @throws IOException
     *             An exception
     */
    public static DialogResponse parse( String strJSON ) throws IOException
    {
        JsonNode nodeRoot = _mapper.readTree( strJSON );
        JsonNode nodeResults = nodeRoot.get( "results" );
        String strResponseJSON = nodeResults.toString( );
        DialogResponse response = _mapper.readValue( strResponseJSON, DialogResponse.class );

        AppLogService.debug( "Recast Response JSON : " + strResponseJSON );

        return response;
    }

    /**
     * Build the JSON for the request
     * 
     * @param strText
     *            The user message
     * @param strConversationId
     *            The conversation ID
     * @param strLanguage
     *            The language
     * @return The JSON
     */
    private static String getJson( String strText, String strConversationId, String strLanguage )
    {
        String strJSON = String.format( "{\"message\": {\"content\":\"%s\",\"type\":\"text\"}, \"conversation_id\": \"%s\" , \"language\": \"%s\" }", strText,
                strConversationId, strLanguage );
        AppLogService.debug( "Recast Request JSON : " + strJSON );
        return strJSON;
    }

    /**
     * Build the header for the request
     * 
     * @param strToken
     *            The Access Token
     * @return The headers map
     */
    private static Map<String, String> getHeaders( String strToken )
    {
        Map<String, String> mapHeaders = new HashMap<>( );
        mapHeaders.put( HEADER_AUTHORIZATION, "Token " + strToken );

        return mapHeaders;
    }
    
    /**
     * Trace for debug
     * @param strText Text sent to the server
     * @param strResponse The server response
     */
    private static void trace( String strText, String strResponse )
    {
        boolean bDebug = AppPropertiesService.getPropertyBoolean( PROPERTY_DEBUG , true );
        if( bDebug )
        {
            String strPrettyJson = ( new JSONObject( strResponse )).toString( 4 );
            LOGGER.debug( "DIALOG API CALL :\n --> Message sent to server '" + strText + "'\n <-- Server response : " + strPrettyJson );
        }
    }
    
}

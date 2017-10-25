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

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.paris.lutece.plugins.recast.business.DialogResponse;
import fr.paris.lutece.portal.service.util.AppPropertiesService;
import fr.paris.lutece.util.httpaccess.HttpAccess;
import fr.paris.lutece.util.httpaccess.HttpAccessException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * RecastDialogService
 */
public class RecastDialogService
{
    private static final String HEADER_AUTHORIZATION = "";
    private static final String HEADER_CONTENT_TYPE = "";
    private static final String CONTENT_TYPE = "";

    private static final String PROPERTY_DIALOG_API_URL = "recast.dialog.api.url";
    private static final String PROPERTY_TOKEN = "recast.authorization.token";

    private static ObjectMapper _mapper = new ObjectMapper( );

    /**
     * Scan the CNI
     *
     * @param strText
     *            The message
     * @return The Dialog response
     * @throws HttpAccessException
     * @throws IOException
     */
    public static DialogResponse getDialogResponse( String strText ) throws HttpAccessException, IOException
    {
        DialogResponse response;
        HttpAccess client = new HttpAccess( );
        String strURL = AppPropertiesService.getProperty( PROPERTY_DIALOG_API_URL );
        String strJson = getJson( strText );
        Map<String, String> mapHeaders = getHeaders( );
        String strResponse = client.doPostJSON( strURL, strJson, mapHeaders, null );
        response = parse( strResponse );
        return response;
    }

    /**
     * Parse the response of the scanner server
     *
     * @param strJSON
     *            The response as JSON
     * @return The DialogResponse object
     * @throws IOException
     *             An exception
     */
    public static DialogResponse parse( String strJSON ) throws IOException
    {
        DialogResponse response = _mapper.readValue( strJSON, DialogResponse.class );

        return response;
    }

    private static String getJson( String strText )
    {
        return String.format( "{\"message\": {\"content\":\"%s\",\"type\":\"text\"}, \"conversation_id\": \"CONVERSATION_ID\"}", strText );
    }

    private static Map<String, String> getHeaders( )
    {
        Map<String, String> mapHeaders = new HashMap<>( );
        String strToken = AppPropertiesService.getProperty( PROPERTY_TOKEN );
        mapHeaders.put( HEADER_AUTHORIZATION, strToken );
        mapHeaders.put( HEADER_CONTENT_TYPE, CONTENT_TYPE );
        return mapHeaders;
    }
}

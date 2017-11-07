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

import fr.paris.lutece.plugins.recast.business.DialogResponse;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pierre
 */
public class RecastDialogServiceTest
{
    private static final String JSON = "{\n" + "    \"messages\": [\n" + "        {\n" + "            \"type\": \"text\",\n"
            + "            \"content\": \"Hello :-)\"\n" + "        }\n" + "    ],\n" + "    \"conversation\": {\n" + "        \"id\": \"CONVERSATION_ID\",\n"
            + "        \"language\": \"en\",\n" + "        \"memory\": {},\n" + "        \"skill\": \"default\",\n" + "        \"skill_occurences\": 1\n"
            + "    },\n" + "    \"nlp\": {\n" + "        \"uuid\": \"b96bc782-6aba-4fac-aeaa-2326936b08bf\",\n" + "        \"source\": \"Hello Recast\",\n"
            + "        \"intents\": [\n" + "            {\n" + "                \"slug\": \"greetings\",\n" + "                \"confidence\": 0.99\n"
            + "            }\n" + "        ],\n" + "        \"act\": \"assert\",\n" + "        \"type\": null,\n" + "        \"sentiment\": \"neutral\",\n"
            + "        \"entities\": {},\n" + "        \"language\": \"en\",\n" + "        \"processing_language\": \"en\",\n"
            + "        \"version\": \"2.10.1\",\n" + "        \"timestamp\": \"2017-10-19T13:24:12.984856+00:00\",\n" + "        \"status\": 200\n" + "    }\n"
            + "}";

    /**
     * Test of getDialogResponse method, of class RecastDialogService.
     */
    /*
     * @Test public void testGetDialogResponse() throws Exception { System.out.println("getDialogResponse"); String strText = "Hello"; DialogResponse result =
     * RecastDialogService.getDialogResponse(strText); System.out.println( result ); }
     */
    /**
     * Test of parse method, of class RecastDialogService.
     */
    @Test
    public void testParse( ) throws Exception
    {
        System.out.println( "parse" );
        DialogResponse expResult = null;
        DialogResponse result = RecastDialogService.parse( JSON );
    }

}

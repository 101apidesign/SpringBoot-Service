package com.apidesign.Design;


import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TestScenario {

	private static final String APPLICATION_JSON = "application/json";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final HttpGet rootGetRequest = new HttpGet("http://localhost:8080/");
    private String responseString=null;
    
    @Given("^Authorization header is set to proper token$")
    public void authorization_header_is_set_to_proper_token() {//throws Throwable {
    	rootGetRequest.addHeader("authorization", "Bearer 123456789");
    	Header[] headers = rootGetRequest.getHeaders("authorization");

    	Assert.assertEquals(1, headers.length);
    	
    	Assert.assertEquals("authorization".toLowerCase(), headers[0].getName().toLowerCase());
    	Assert.assertEquals("Bearer 123456789".toLowerCase(), headers[0].getValue().toLowerCase());
    	
    }
    
    @When("^I execute GET method on /$")
    public void i_execute_GET_method_on() throws Throwable {
    	HttpGet request = new HttpGet("http://localhost:8080/");
    	request.addHeader("accept", APPLICATION_JSON);
        HttpResponse httpResponse=null;
        responseString=null;
		try {
			httpResponse = httpClient.execute(request);
		} catch (IOException e) {
			//e.printStackTrace();
			Assert.fail("IOException when executing GET on /");
		}
		
        try {
			responseString = Helper.convertResponseToString(httpResponse);
		} catch (IOException e) {
			//e.printStackTrace();
			Assert.fail("IOException when converting response to String");
		}
    	Assert.assertNotNull(responseString);
    }

    @Then("^Hello World should be returned$")
    public void hello_World_should_be_returned() throws Throwable {
    	Assert.assertEquals("{\"message\":\"Hello World!\"}", responseString);
    }

}

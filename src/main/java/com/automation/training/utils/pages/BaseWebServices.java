package com.automation.training.utils.pages;

import com.automation.training.utils.text.WebServices;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Description:BaseWebServices
 *
 */
public class BaseWebServices {
	protected RequestSpecification request = RestAssured.with();
	protected Response response;
	/**
	 * Returns a request with id.
	 * 
	 * 
	 * @return 
	 */
	public int requestPostWithtAuthorization() {

		return request.given().header(WebServices.AUTHORIZATION, WebServices.BASIC + WebServices.TOKEN)
				.contentType(ContentType.JSON).body(WebServices.BODY).when().post(WebServices.BASE_POST).then()
				.extract().path(WebServices.ID);

	}
	/**
	 * Returns a request and delete.
	 * 
	 * 
	 * @param id : int
	 */
	public Response requestDeleteWithtAuthorization(int id) {

		return request.given().contentType(ContentType.JSON)
				.delete(WebServices.DELETE_FIRST + id + WebServices.DELETE_SECOND);

	}

}

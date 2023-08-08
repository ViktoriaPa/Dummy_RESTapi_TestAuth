package com.coherentsolutions.training.auto.API.pashkovskaya.specs;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specs {
    public static RequestSpecification requestSpec(String baseUri){
        return new RequestSpecBuilder()
                .setBaseUri(baseUri)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    public  static ResponseSpecification responseSpec(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

    public  static ResponseSpecification responseSpecOK200(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).expectStatusCode(200).build();
    }

    public static void instalSpec(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}

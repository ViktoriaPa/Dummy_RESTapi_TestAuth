package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.model.TokenRes;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.User;
import com.coherentsolutions.training.auto.API.pashkovskaya.util.PropertiesFileReader;
import com.coherentsolutions.training.auto.API.pashkovskaya.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

public class Auth extends BaseTest {
    @Test
    public void testAuthorizationIsSuccessful() throws JsonProcessingException {
        User user = new User(PropertiesFileReader.getUsername(), PropertiesFileReader.getPassword());

        String resBodyJson = given()
                .when()
                .body(user)
                .post("auth/login")
                .then()
                .extract().body().asPrettyString();

        TokenRes token = objectMapper.readValue(resBodyJson, TokenRes.class);
        assertNotNull(token, "Token is null");
    }
}

package com.coherentsolutions.training.auto.API.pashkovskaya.tests;

import com.coherentsolutions.training.auto.API.pashkovskaya.model.TokenRes;
import com.coherentsolutions.training.auto.API.pashkovskaya.model.User;
import com.coherentsolutions.training.auto.API.pashkovskaya.util.PropertiesFileReader;
import com.coherentsolutions.training.auto.API.pashkovskaya.base.BaseTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

public class Auth extends BaseTest {
    @Test
    public void testAuthorizationIsSuccessful(){
        User user = new User(PropertiesFileReader.getUsername(), PropertiesFileReader.getPassword());

        TokenRes.getInstance().setToken(given()
                .when()
                .body(user)
                .post("auth/login")
                .then()
                .extract().body().jsonPath().getString("token"));

        assertNotNull(TokenRes.getInstance().getToken(), "Token is null");
    }
}

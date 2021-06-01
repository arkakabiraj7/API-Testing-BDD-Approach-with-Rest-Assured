package com.sample.test;


import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;



public class Test {

    public void getMethod()
    {
        given()
                .get("https://reqres.in/api/users?page=2")
        .then()
                 .statusCode(200).
                    body("data.id[0]", Matchers.equalTo(7)).
                    log().all();

    }



    public void postMethod() throws JSONException {

        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
                given().
                     header("Content-Type","application/json").
                        body(request.toString()).
                        log().all().
                when().
                      post("https://reqres.in/api/users").

               then().
                        statusCode(201).
                        body("name",Matchers.equalTo("morpheus")).
                        body("job",Matchers.equalTo("leader")).
                        log().all();

    }

    public void putMethod() throws JSONException {

        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","zion resident");
        given().
                header("Content-Type","application/json").
                body(request.toString()).
                log().all().
                when().
                put("https://reqres.in/api/users/2").

                then().
                statusCode(200).
                body("name",Matchers.equalTo("morpheus")).
                body("job",Matchers.equalTo("zion resident")).
                log().all();

    }


    public void deleteMethod()
    {
        Calendar time = Calendar.getInstance();
        time.add(Calendar.MILLISECOND, -time.getTimeZone().getOffset(time.getTimeInMillis()));
        Date date = time.getTime();

        given()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204).
                header("Server",Matchers.equalTo("cloudflare")).
                header("Connection",Matchers.equalTo("keep-alive")).
               // header("Date", String.valueOf(date)).
                log().all();

    }

}

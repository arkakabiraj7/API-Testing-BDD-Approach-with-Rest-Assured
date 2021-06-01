package com.sample.test;

import org.json.JSONException;

public class MainClass {

    public static void main(String[] args) throws JSONException {
        com.sample.test.Test t= new com.sample.test.Test();
        t.getMethod();
        t.postMethod();
        t.putMethod();
        t.deleteMethod();
    }
}

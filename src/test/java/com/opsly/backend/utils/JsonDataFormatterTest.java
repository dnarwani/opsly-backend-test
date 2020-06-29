package com.opsly.backend.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class JsonDataFormatterTest {


    @Test
    void formatBody() {


        ArrayList<HashMap> body= new ArrayList<>();

        HashMap<String, String> hipster1 = new HashMap<>();
        hipster1.put("username","hipster1" );
        hipster1.put("picture","food" );
        body.add(hipster1);

        HashMap<String, String> hipster2 = new HashMap<>();
        hipster2.put("username","hipster2" );
        hipster2.put("picture","coffee" );
        body.add(hipster2);


        HashMap<String, String> hipster3 = new HashMap<>();
        hipster3.put("username","hipster3" );
        hipster3.put("picture","coffe2" );
        body.add(hipster3);



        HashMap<String, String> keyValuePair= new HashMap<>();
        keyValuePair.put("firstKey", "username");
        keyValuePair.put("secondKey", "picture");

        String jsonContent = JsonDataFormatter.formatBody(body, keyValuePair);
        assert (jsonContent!=null);


    }
}
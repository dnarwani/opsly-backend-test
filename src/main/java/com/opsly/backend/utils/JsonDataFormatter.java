package com.opsly.backend.utils;

import java.util.*;

public class JsonDataFormatter {

    public  static String formatBody(ArrayList<HashMap> body, HashMap<String, String> keyValuePair) {
        StringBuilder sb = new StringBuilder();
        String keyName = keyValuePair.get("firstKey".toString());
        String valueName = keyValuePair.get("secondKey".toString());

        body.forEach(element -> {
                    sb.append("{");
                    sb.append('"' + keyName + '"' + ":");
                    sb.append('"' + element.get(keyName).toString() + '"');
                    sb.append(",");
                    sb.append('"' + valueName + '"' + ":");
                    sb.append('"' + element.get(valueName).toString() + '"');
                    sb.append("},");
                }
        );
        return sb.toString();

    }


}

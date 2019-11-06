package com.example.voxsmart;

import android.util.Log;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NumberParser {
    private Map<String, Integer> countryCode;
    private Map<String, String> prefix;

    public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {

        callingCodes.put("GB", 44);
        callingCodes.put("US", 1);
        callingCodes.put("FR", 33);
        callingCodes.put("IT", 39);
        callingCodes.put("IN", 91);
        callingCodes.put("CN", 86);

        prefixes.put("GB", "0");
        prefixes.put("US", "1");
        prefixes.put("FR", "0");
        prefixes.put("CN", "0");
        prefixes.put("IT", "0");
        prefixes.put("IN", "0");
        Log.d("prefix", prefixes.toString());

        countryCode = callingCodes;
        prefix = prefixes;
    }

    public String parse(String dialledNumber, String userNumber) {
        String internationalFormat = "";

        Set entrySet = countryCode.entrySet();
        Set entrySet2 = prefix.entrySet();
        Iterator countryCodeIterator = entrySet.iterator();
        Iterator prefixIterator = entrySet2.iterator();


        if (dialledNumber.startsWith("+")) {
            internationalFormat = dialledNumber;
            Log.d("Dialled number : ", dialledNumber);

        } else {
            if (dialledNumber.startsWith("0") || dialledNumber.startsWith("1")) {

                while (countryCodeIterator.hasNext() && prefixIterator.hasNext()) {
                    Map.Entry country = (Map.Entry) countryCodeIterator.next();
                    Map.Entry preffix = (Map.Entry) prefixIterator.next();

                    if (userNumber.contains(country.getValue().toString()) && preffix.getKey().toString().equals(country.getKey().toString())) {
                        internationalFormat = dialledNumber.replaceFirst(preffix.getValue().toString(), "+" + country.getValue().toString());
                        Log.d("check info", preffix.getValue().toString());
                        Log.d("check info", preffix.getKey().toString());

                        break;
                    }
                }

            }
        }
        return internationalFormat;

    }
}



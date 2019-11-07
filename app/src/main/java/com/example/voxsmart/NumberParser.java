package com.example.voxsmart;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class NumberParser {
    private Map<String, Integer> countryCode;
    private Map<String, String> prefix;

    public NumberParser(Map<String, Integer> callingCodes, Map<String, String> prefixes) {

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
        } else {
            while (countryCodeIterator.hasNext() && prefixIterator.hasNext()) {
                Map.Entry country = (Map.Entry) countryCodeIterator.next();
                Map.Entry prefix = (Map.Entry) prefixIterator.next();

                if (userNumber.contains(country.getValue().toString()) && prefix.getKey().toString().equals(country.getKey().toString())) {
                    internationalFormat = dialledNumber.replaceFirst(prefix.getValue().toString(), "+" + country.getValue().toString());
                    break;
                }
            }
        }
        return internationalFormat;

    }
}



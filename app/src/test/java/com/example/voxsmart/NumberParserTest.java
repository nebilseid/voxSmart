package com.example.voxsmart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
    public class NumberParserTest {

        @Test
        public void testNumberParser() {
            Map<String, Integer> countryCodes = new HashMap<>();
            Map<String, String> prefixes = new HashMap<>();
            countryCodes.put("GB", 44);
            prefixes.put("GB", "0");
            countryCodes.put("US", 1);
            prefixes.put("US", "1");
            countryCodes.put("FR", 33);
            prefixes.put("FR", "0");
            NumberParser parser = new NumberParser(countryCodes, prefixes);

            assertEquals("+447277822334", parser.parse("07277822334", "+447866866886"));
            assertEquals("+447277822334", parser.parse("07277822334", "+447866866886"));
            assertEquals("+331278822665", parser.parse("01278822665", "+331922833883"));

        }
    }


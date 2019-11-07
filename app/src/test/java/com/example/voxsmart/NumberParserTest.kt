package com.example.voxsmart

import javax.swing.UIManager.put
import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runner.RunWith


@RunWith(BlockJUnit4ClassRunner::class)
class NumberParserTest {

    @Test
    fun testNumberParser() {
        val countryCodes = HashMap()
        val prefixes = HashMap()
        countryCodes.put("GB", 44)
        prefixes.put("GB", "0")
        countryCodes.put("US", 1)
        prefixes.put("US", "1")
        countryCodes.put("FR", 33)
        prefixes.put("FR", "0")
        val parser = NumberParser(countryCodes, prefixes)

        assertEquals("+447277822334", parser.parse("07277822334", "+447866866886"))
        assertEquals("+447277822334", parser.parse("07277822334", "+447866866886"))
        assertEquals("+331278822665", parser.parse("01278822665", "+331922833883"))

    }
}
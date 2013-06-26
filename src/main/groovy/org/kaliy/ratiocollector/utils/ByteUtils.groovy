package org.kaliy.ratiocollector.utils

class ByteUtils {
    final static UNITS_REGEXP =
            "(?i)" + // Case insensitive
            "([0-9]+(?:\\.[0-9]*)?)" + // Integer or decimal number
            "\\s*" + // Any whitespace character before...
            "([KMGTP]?)" // Unit
    static Long convertStringToBytes(String rawBytesString) {
        def numberMatcher = rawBytesString=~UNITS_REGEXP
        def units = ["", "K", "M", "G", "T", "P"]
        if (0 == numberMatcher.size()) {
            throw new IllegalArgumentException("Invalid size string")
        }
        String size = numberMatcher[0][1]
        String unit = numberMatcher[0][2]
        return size.toDouble()*(1024**(units.indexOf(unit.toUpperCase()))).toLong()
    }
}

package org.kaliy.ratiocollector.utils

class ByteUtils {
    final static UNITS_REGEXP =
            "(?i)" + // Case insensitive
            "([0-9]+(?:\\.[0-9]*)?)" + // Integer or decimal number
            ".*?" + // Any character before...
            "([KMPT]){0,1}" // Unit
    static Long convertStringToBytes(String rawBytesString) {
        null
    }
}

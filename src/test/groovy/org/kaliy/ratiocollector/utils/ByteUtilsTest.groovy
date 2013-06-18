package org.kaliy.ratiocollector.utils

class ByteUtilsTest extends GroovyTestCase {
    void testStringConverterInterpretsNumberAsBytes() {
        def bytes = "123456789"
        assert 123_456_789L == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsKilobytesWithSpace() {
        def bytes = "20 Kb"
        assert 1024 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsMegabytesWithSpace() {
        def bytes = "20 Mb"
        assert 1024**2 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsGigabytesWithSpace() {
        def bytes = "20 Gb"
        assert 1024**3 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsTerabytesWithSpace() {
        def bytes = "20 Tb"
        assert 1024**4 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsPetabytesWithSpace() {
        def bytes = "20 Pb"
        assert 1024**5 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsOneCharacterUnit() {
        def bytes = "20 K"
        assert 1024 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsUnitWithoutSpace() {
        def bytes = "20Kb"
        assert 1024 * 20 == ByteUtils.convertStringToBytes(bytes)
    }

    void testStringConverterInterpretsIecBinaryPrefix() {
        def bytes = "20 KiB"
        assert 1024 * 20 == ByteUtils.convertStringToBytes(bytes)
    }
}

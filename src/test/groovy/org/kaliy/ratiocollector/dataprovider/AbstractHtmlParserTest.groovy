package org.kaliy.ratiocollector.dataprovider

import groovy.util.slurpersupport.GPathResult
import org.cyberneko.html.parsers.SAXParser

abstract class AbstractHtmlParserTest extends GroovyTestCase {
    protected GPathResult parseFile(def fileName) {
        new XmlSlurper(new SAXParser()).parseText(this.class.getResource(fileName).text)
    }
}

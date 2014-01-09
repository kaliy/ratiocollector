package org.kaliy.ratiocollector.dataprovider

import com.google.inject.ImplementedBy

@ImplementedBy(PageParserFactoryImpl)
interface PageParserFactory {
    def createParser(Class clazz, data)
}

package org.kaliy.ratiocollector.dataprovider

class PageParserFactoryImpl implements PageParserFactory {
    @Override
    def createParser(Class clazz, Object data) {
        return clazz.newInstance(data)
    }
}

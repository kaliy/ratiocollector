package org.kaliy.ratiocollector.dataprovider

// TODO: guice
@Singleton
class TrackerCookiesHolder {

    ConfigObject cookies

    private final static COOKIES_HOLDER_FILE_NAME = "${System.getProperty("user.home")}/.ratiocollector_cookies.groovy"

    def persistCookies() {
        if (cookies) {
            new File(COOKIES_HOLDER_FILE_NAME).withWriter { writer ->
                cookies.writeTo(writer)
            }
        }
    }

    def updateCookiesFromFileSystem() {
        def cookiesFile = new File(COOKIES_HOLDER_FILE_NAME)
        if (!cookiesFile.exists()) {
            cookiesFile.createNewFile()
        }
        cookies = new ConfigSlurper().parse(cookiesFile.toURI().toURL())
    }

}

package org.kaliy.ratiocollector.config

import org.kaliy.ratiocollector.dataprovider.data.Tracker

import javax.inject.Singleton

@Singleton
class ConfigObjectCookiesHolder implements TrackerCookiesHolder {

    ConfigObject cookies

    private final static COOKIES_HOLDER_FILE_NAME = "${System.getProperty("user.home")}/.ratiocollector_cookies.groovy"

    ConfigObjectCookiesHolder() {
        updateCookiesFromFileSystem()
    }

    private persistCookies() {
        if (cookies) {
            new File(COOKIES_HOLDER_FILE_NAME).withWriter { writer ->
                cookies.writeTo(writer)
            }
        }
    }

    private updateCookiesFromFileSystem() {
        def cookiesFile = new File(COOKIES_HOLDER_FILE_NAME)
        if (!cookiesFile.exists()) {
            cookiesFile.createNewFile()
        }
        cookies = new ConfigSlurper().parse(cookiesFile.toURI().toURL())
    }

    @Override
    String getCookie(Tracker tracker) {
        cookies."${tracker.configName}"
    }

    @Override
    String setCookie(Tracker tracker, cookie) {
        cookies."${tracker.configName}" = cookie
        persistCookies()
    }
}

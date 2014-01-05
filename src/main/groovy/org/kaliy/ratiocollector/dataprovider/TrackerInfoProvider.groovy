package org.kaliy.ratiocollector.dataprovider

import groovy.util.logging.Slf4j
import groovyx.net.http.HTTPBuilder
import org.kaliy.ratiocollector.config.TrackerCookiesHolder
import org.kaliy.ratiocollector.config.TrackerCredentialsHolder
import org.kaliy.ratiocollector.dataprovider.data.Tracker
import org.kaliy.ratiocollector.dataprovider.data.TrackerInfo

import javax.inject.Inject

@Slf4j
abstract class TrackerInfoProvider {
    @Inject
    TrackerCookiesHolder cookiesHolder
    @Inject
    TrackerCredentialsHolder credentialsHolder

    abstract TrackerInfo getInfo() throws NotLoggedInException

    abstract void login()
    abstract Tracker getTracker()

    Map getCredentials() {
        credentialsHolder.getCredentials(tracker)
    }

    HTTPBuilder createHttpBuilder(url, params = [:]) {
        def httpBuilder = new HTTPBuilder(url)
        httpBuilder.headers."Cookie" = cookiesHolder.getCookie(tracker)
        httpBuilder.headers."User-Agent" = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36"
        if (params.cookieExtractor) {
            httpBuilder.handler.success = { response ->
                def cookie = response.getHeaders("Set-Cookie").collect { it.value.split(";")[0] }.join(";")
                if (cookie) {
                    log.info "Cookie for ${tracker.name}: $cookie"
                    cookiesHolder.setCookie tracker, cookie
                } else {
                    throw new UnsuccessfulLoginException()
                }
            }
        }
        httpBuilder
    }


}

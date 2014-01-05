package org.kaliy.ratiocollector.dataprovider

import groovy.util.logging.Slf4j
import groovyx.net.http.HTTPBuilder
import org.kaliy.ratiocollector.dataprovider.data.Tracker
import org.kaliy.ratiocollector.dataprovider.data.TrackerInfo

@Slf4j
abstract class TrackerInfoProvider {
    abstract TrackerInfo getInfo() throws NotLoggedInException

    abstract void login()

    abstract Tracker getTracker()

    HTTPBuilder createHttpBuilder(url, params = [:]) {
        def httpBuilder = new HTTPBuilder(url)
        httpBuilder.headers."Cookie" = TrackerCookiesHolder.instance.cookies."${tracker.url.replace('.', '_')}"
        httpBuilder.headers."User-Agent" = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36"
        if (params.cookieExtractor) {
            httpBuilder.handler.success = { response ->
                def cookie = response.getHeaders("Set-Cookie").collect { it.value.split(";")[0] }.join(";")
                if (cookie) {
                    log.info "Cookie for ${tracker.name}: $cookie"
                    TrackerCookiesHolder.instance.cookies."${tracker.url.replace('.', '_')}" = cookie
                    TrackerCookiesHolder.instance.persistCookies()
                } else {
                    throw new UnsuccessfulLoginException()
                }
            }
        }
        httpBuilder
    }


}

package org.kaliy.ratiocollector.config

import com.google.inject.ImplementedBy
import org.kaliy.ratiocollector.dataprovider.data.Tracker

@ImplementedBy(ConfigObjectCookiesHolder)
interface TrackerCookiesHolder {
    String getCookie(Tracker tracker)

    String setCookie(Tracker tracker, cookie)
}

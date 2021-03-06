package org.kaliy.ratiocollector.dataprovider.torrentday

import groovy.util.logging.Slf4j
import org.kaliy.ratiocollector.dataprovider.AbstractOnePageWithoutCaptchaInfoProvider
import org.kaliy.ratiocollector.dataprovider.data.Tracker

@Slf4j
class TorrentDayInfoProvider extends AbstractOnePageWithoutCaptchaInfoProvider {

    @Override
    String getMainPageUrl() {
        "http://www.td.af"
    }

    @Override
    String getLoginUrl() {
        "http://www.td.af/torrents/"
    }

    @Override
    Class getMainPageParserClass() {
        TorrentDayMainPageParser
    }

    @Override
    Tracker getTracker() {
        new TorrentDayTracker()
    }

}

package org.kaliy.ratiocollector.dataprovider.torrentday

import groovy.util.logging.Slf4j
import org.kaliy.ratiocollector.dataprovider.NotLoggedInException
import org.kaliy.ratiocollector.dataprovider.TrackerInfoProvider
import org.kaliy.ratiocollector.dataprovider.data.Tracker
import org.kaliy.ratiocollector.dataprovider.data.TrackerInfo

@Slf4j
class TorrentDayInfoProvider extends TrackerInfoProvider {

    @Override
    TrackerInfo getInfo() throws NotLoggedInException {
        log.info "Requesting http://www.td.af"
        def html = createHttpBuilder("http://www.td.af").get([:])
        log.info "Parsing TorrentDay main page"
        def pageParser = new TorrentDayMainPageParser(html)
        def info = new TrackerInfo(
                upload: pageParser.upload,
                download: pageParser.download,
                ratio: pageParser.ratio,
                bonusPoints: pageParser.bonusPoints,
                invites: pageParser.invitesNumber
        )
        log.info "Found ${info}"
        info
    }

    @Override
    void login() {
        log.info "Requesting http://www.td.af/torrents/"
        createHttpBuilder("http://www.td.af/torrents/", [cookieExtractor: true]).post(
                body: [username: credentials.username, password: credentials.password]
        )
    }

    @Override
    Tracker getTracker() {
        new TorrentDayTracker()
    }

}

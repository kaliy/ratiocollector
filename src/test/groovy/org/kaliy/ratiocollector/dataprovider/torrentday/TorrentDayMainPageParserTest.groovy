package org.kaliy.ratiocollector.dataprovider.torrentday

import org.kaliy.ratiocollector.dataprovider.AbstractHtmlParserTest
import org.kaliy.ratiocollector.dataprovider.NotLoggedInException

class TorrentDayMainPageParserTest extends AbstractHtmlParserTest {

    def notLoggedInMainPageGpath = parseFile("/tracker/torrentday/not_logged_in_main_page.html")
    def loggedInMainPageGpath = parseFile("/tracker/torrentday/logged_in_main_page.html")

    void testParserThrowsNotLoggedInErrorOnNotLoggedInMainPage() {
        shouldFail(NotLoggedInException) {
            new TorrentDayMainPageParser(notLoggedInMainPageGpath)
        }
    }

    void testParserParsesInvitesFromLoggedInMainPage() {
        assert 2 == new TorrentDayMainPageParser(loggedInMainPageGpath).invitesNumber
    }

    void testParserParsesBonusPointsFromLoggedInMainPage() {
        assert 1234.5 == new TorrentDayMainPageParser(loggedInMainPageGpath).bonusPoints
    }

    void testParserParsesUploadFromLoggedInMainPage() {
        assert (1024L**3 * 123.456 as Long) == new TorrentDayMainPageParser(loggedInMainPageGpath).upload
    }

    void testParserParsesDownloadFromLoggedInMainPage() {
        assert (1024L**3 * 12.345 as Long) == new TorrentDayMainPageParser(loggedInMainPageGpath).download
    }

    void testParserParsesRatioFromLoggedInMainPage() {
        assert 1.234 == new TorrentDayMainPageParser(loggedInMainPageGpath).ratio
    }
}

package org.kaliy.ratiocollector.dataprovider.scenetime

import org.kaliy.ratiocollector.dataprovider.AbstractHtmlParserTest
import org.kaliy.ratiocollector.dataprovider.NotLoggedInException

class SceneTimeMainPageParserTest extends AbstractHtmlParserTest {
    def notLoggedInMainPageGpath = parseFile("/tracker/scenetime/not_logged_in_main_page.html")
    def loggedInMainPageGpath = parseFile("/tracker/scenetime/logged_in_main_page.html")

    void testParserThrowsNotLoggedInErrorOnNotLoggedInMainPage() {
        shouldFail(NotLoggedInException) {
            new SceneTimeMainPageParser(notLoggedInMainPageGpath)
        }
    }

    void testParserParsesInvitesFromLoggedInMainPage() {
        assert 2 == new SceneTimeMainPageParser(loggedInMainPageGpath).invitesNumber
    }

    void testParserParsesBonusPointsFromLoggedInMainPage() {
        assert 1234.5 == new SceneTimeMainPageParser(loggedInMainPageGpath).bonusPoints
    }

    void testParserParsesUploadFromLoggedInMainPage() {
        assert (1024L**3 * 123.456 as Long) == new SceneTimeMainPageParser(loggedInMainPageGpath).upload
    }

    void testParserParsesDownloadFromLoggedInMainPage() {
        assert (1024L**3 * 12.345 as Long) == new SceneTimeMainPageParser(loggedInMainPageGpath).download
    }

    void testParserParsesRatioFromLoggedInMainPage() {
        assert 1.234 == new SceneTimeMainPageParser(loggedInMainPageGpath).ratio
    }
}

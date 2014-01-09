package org.kaliy.ratiocollector.dataprovider

import org.kaliy.ratiocollector.dataprovider.data.TrackerInfo

import javax.inject.Inject

abstract class AbstractOnePageWithoutCaptchaInfoProvider extends TrackerInfoProvider {

    @Inject
    def PageParserFactory pageParserFactory

    abstract String getMainPageUrl()
    abstract String getLoginUrl()
    abstract Class getMainPageParserClass()

    String getUsernameLoginParameter() {
        "username"
    }
    String getPasswordLoginParameter() {
        "password"
    }

    @Override
    TrackerInfo getInfo() throws NotLoggedInException {
        log.info "Requesting ${mainPageUrl}"
        def html = createHttpBuilder("${mainPageUrl}").get([:])
        log.info "Parsing ${tracker.name} main page"
        def pageParser = pageParserFactory.createParser(mainPageParserClass, html)
        def trackerInfo = new TrackerInfo(
                upload: pageParser.metaClass.respondsTo(pageParser, "getUpload") ? pageParser.upload : null,
                download: pageParser.metaClass.respondsTo(pageParser, "getDownload") ? pageParser.download : null,
                ratio: pageParser.metaClass.respondsTo(pageParser, "getRatio") ? pageParser.ratio : null,
                bonusPoints: pageParser.metaClass.respondsTo(pageParser, "getBonusPoints") ? pageParser.bonusPoints : null,
                invites: pageParser.metaClass.respondsTo(pageParser, "getInvitesNumber") ? pageParser.invitesNumber : null
        )
        log.info "Found ${trackerInfo}"
        trackerInfo
    }

    @Override
    void login() {
        log.info "Requesting ${loginUrl}"
        createHttpBuilder(loginUrl, [cookieExtractor: true]).post(
                body: ["${usernameLoginParameter}": credentials.username, "${passwordLoginParameter}": credentials.password]
        )
    }

}

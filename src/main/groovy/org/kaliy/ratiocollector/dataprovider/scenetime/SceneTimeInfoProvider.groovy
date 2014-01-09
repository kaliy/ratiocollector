package org.kaliy.ratiocollector.dataprovider.scenetime

import groovy.util.logging.Slf4j
import org.kaliy.ratiocollector.dataprovider.AbstractOnePageWithoutCaptchaInfoProvider
import org.kaliy.ratiocollector.dataprovider.data.Tracker

@Slf4j
class SceneTimeInfoProvider extends AbstractOnePageWithoutCaptchaInfoProvider {
    @Override
    Tracker getTracker() {
        new SceneTimeTracker()
    }

    @Override
    String getMainPageUrl() {
        "http://www.scenetime.com"
    }

    @Override
    String getLoginUrl() {
        "http://www.scenetime.com/takelogin.php"
    }

    @Override
    Class getMainPageParserClass() {
        SceneTimeMainPageParser
    }
}

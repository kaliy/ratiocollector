package org.kaliy.ratiocollector.dataprovider.scenetime

import org.kaliy.ratiocollector.dataprovider.*
import org.kaliy.ratiocollector.utils.ByteUtils

class SceneTimeMainPageParser  implements
        TrackerBonusPointsInfoProvider,
        TrackerDownloadInfoProvider,
        TrackerRatioInfoProvider,
        TrackerUploadInfoProvider,
        TrackerInvitesInfoProvider {

    def pageGpathResult

    SceneTimeMainPageParser(gpathResult) {
        pageGpathResult = gpathResult
        if (pageGpathResult."**".find { it.@href.text().toLowerCase() == "/signup.php" }) {
            throw new NotLoggedInException()
        }
    }

    @Override
    Double getBonusPoints() {
        (infoString =~ /Bonus Points: ([\d,\.]+)/)[0][1].replace(",", "") as Double
    }

    @Override
    Long getDownload() {
        ByteUtils.convertStringToBytes((infoString =~ /Downloaded: (.+)/)[0][1])
    }

    @Override
    Integer getInvitesNumber() {
        (infoString =~ /Invites: (\d+)/)[0][1] as Integer
    }

    @Override
    Double getRatio() {
        (infoString =~ /Ratio: ([\d\.]+)/)[0][1] as Double
    }

    @Override
    Long getUpload() {
        ByteUtils.convertStringToBytes((infoString =~ /Uploaded: (.+)/)[0][1])
    }

    def private getInfoString() {
        def fullText = pageGpathResult."**".find{it.@id.text() == "Statusdiv"}."**".find{it.@class.text().toLowerCase() == "fll"}.text()
        (fullText =~ "\\s+").replaceAll(" ")
    }

}

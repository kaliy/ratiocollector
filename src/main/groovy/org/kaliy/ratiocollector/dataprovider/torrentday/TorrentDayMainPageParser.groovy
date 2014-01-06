package org.kaliy.ratiocollector.dataprovider.torrentday

import org.kaliy.ratiocollector.dataprovider.*
import org.kaliy.ratiocollector.utils.ByteUtils

class TorrentDayMainPageParser implements
        TrackerBonusPointsInfoProvider,
        TrackerDownloadInfoProvider,
        TrackerRatioInfoProvider,
        TrackerUploadInfoProvider,
        TrackerInvitesInfoProvider {

    def pageGpathResult

    TorrentDayMainPageParser(gpathResult) {
        pageGpathResult = gpathResult
        if (pageGpathResult."**".find { it.@href.text().toLowerCase() == "/signup.php" }) {
            throw new NotLoggedInException()
        }
    }

    @Override
    Double getBonusPoints() {
        mainInfoDiv."*".find { it.name() == "A" && it.@href == "mybonus.php" }
                ."*".find {true}.text().replace(",", "") as Double
    }

    @Override
    Long getDownload() {
        ByteUtils.convertStringToBytes(findNextFontWithPreviousFontWithText("Downloaded:"))
    }

    @Override
    Double getRatio() {
        findNextFontWithPreviousFontWithText("Ratio:") as Double
    }

    @Override
    Long getUpload() {
        ByteUtils.convertStringToBytes(findNextFontWithPreviousFontWithText("Uploaded:"))
    }

    @Override
    Integer getInvitesNumber() {
        mainInfoDiv."**".find { it.name() == "A" && it.@href == "/invite.php" }.text().trim() as Integer
    }

    private String findNextFontWithPreviousFontWithText(text) {
        def previous = null
        mainInfoDiv.FONT.find { current ->
            if (previous?.text()?.trim() == text) {
                return true
            } else {
                previous = current
                return false
            }
        }.text().trim()
    }

    private def getMainInfoDiv() {
        pageGpathResult."**".find {
            it.name() == "TD" &&
                    it.@class.text() == "bottom" &&
                    it.@align.text() == "left"
        }
    }
}

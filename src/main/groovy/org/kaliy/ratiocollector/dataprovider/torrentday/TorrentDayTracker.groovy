package org.kaliy.ratiocollector.dataprovider.torrentday

import org.kaliy.ratiocollector.dataprovider.data.Tracker
import org.kaliy.ratiocollector.dataprovider.data.TrackerType

class TorrentDayTracker implements Tracker {
    @Override
    String getName() {
        "TorrentDay"
    }

    @Override
    String getUrl() {
        "www.td.af"
    }

    @Override
    TrackerType getType() {
        TrackerType.RATIO_BASED
    }
}

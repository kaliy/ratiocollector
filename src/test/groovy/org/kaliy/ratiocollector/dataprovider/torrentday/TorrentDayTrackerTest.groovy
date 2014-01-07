package org.kaliy.ratiocollector.dataprovider.torrentday

import org.kaliy.ratiocollector.dataprovider.data.TrackerType

class TorrentDayTrackerTest extends GroovyTestCase {

    void testTrackerConfigNameIstorrentday() {
        assert "torrentday" == new TorrentDayTracker().configName
    }

    void testTrackerNameIsTorrentDay() {
        assert "TorrentDay" == new TorrentDayTracker().name
    }

    void testTrackerUrlIsWwwTdAf() {
        assert "www.td.af" == new TorrentDayTracker().url
    }

    void testTrackerTypeIsRatioBased() {
        assert TrackerType.RATIO_BASED == new TorrentDayTracker().type
    }
}

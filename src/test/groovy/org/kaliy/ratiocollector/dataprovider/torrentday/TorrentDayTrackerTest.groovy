package org.kaliy.ratiocollector.dataprovider.torrentday

class TorrentDayTrackerTest extends GroovyTestCase {

    void testTrackerConfigNameIstorrentday() {
        assert "torrentday" == new TorrentDayTracker().configName
    }

}

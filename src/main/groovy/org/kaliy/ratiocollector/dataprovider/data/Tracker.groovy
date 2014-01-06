package org.kaliy.ratiocollector.dataprovider.data

abstract class Tracker {
    /**
     * Tracker name (TorrentDay)
     */
    abstract String getName()

    /**
     * Tracker address (www.td.af)
     */
    abstract String getUrl()

    /**
     * Tracker ratio policy (ratio-based/ratioless)
     */
    abstract TrackerType getType()

    /**
     * Tracker name for configuration files (torrentday)
     */
    String getConfigName() {
        name.toLowerCase() - ~/[^a-zA-Z]/
    }

}

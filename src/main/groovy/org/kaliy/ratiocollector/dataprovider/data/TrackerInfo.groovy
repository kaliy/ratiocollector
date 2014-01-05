package org.kaliy.ratiocollector.dataprovider.data

import groovy.transform.ToString

@ToString(includeNames = true)
class TrackerInfo {
    /**
     * Download amount in bytes
     */
    Long download
    /**
     * Upload amount in bytes
     */
    Long upload
    /**
     * Tracker ratio (upload/download)
     */
    Double ratio
    /**
     * Tracker bonus points amount (cigars in CG or points in TD)
     */
    Double bonusPoints
    /**
     * Invites number
     */
    Integer invites
}

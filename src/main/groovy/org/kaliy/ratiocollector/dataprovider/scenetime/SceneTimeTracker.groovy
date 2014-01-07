package org.kaliy.ratiocollector.dataprovider.scenetime

import org.kaliy.ratiocollector.dataprovider.data.Tracker
import org.kaliy.ratiocollector.dataprovider.data.TrackerType

class SceneTimeTracker extends Tracker {
    @Override
    String getName() {
        "SceneTime"
    }

    @Override
    String getUrl() {
        "www.scenetime.com"
    }

    @Override
    TrackerType getType() {
        TrackerType.RATIO_BASED
    }
}

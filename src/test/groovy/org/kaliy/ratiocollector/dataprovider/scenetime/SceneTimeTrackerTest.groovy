package org.kaliy.ratiocollector.dataprovider.scenetime

import org.kaliy.ratiocollector.dataprovider.data.TrackerType

class SceneTimeTrackerTest extends GroovyTestCase {
    void testTrackerConfigNameIsscenetime() {
        assert "scenetime" == new SceneTimeTracker().configName
    }

    void testTrackerNameIsSceneTime() {
        assert "SceneTime" == new SceneTimeTracker().name
    }

    void testTrackerUrlIsWwwScenetimeCom() {
        assert "www.scenetime.com" == new SceneTimeTracker().url
    }

    void testTrackerTypeIsRatioBased() {
        assert TrackerType.RATIO_BASED == new SceneTimeTracker().type
    }
}

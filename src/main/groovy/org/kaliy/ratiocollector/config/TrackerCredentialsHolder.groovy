package org.kaliy.ratiocollector.config

import com.google.inject.ImplementedBy
import org.kaliy.ratiocollector.dataprovider.data.Tracker

@ImplementedBy(ConfigObjectCredentialsHolder)
interface TrackerCredentialsHolder {
    Map getCredentials(Tracker tracker)
}

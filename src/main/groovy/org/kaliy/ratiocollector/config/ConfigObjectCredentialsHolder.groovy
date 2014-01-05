package org.kaliy.ratiocollector.config

import org.kaliy.ratiocollector.dataprovider.data.Tracker

class ConfigObjectCredentialsHolder implements TrackerCredentialsHolder {

    ConfigObject credentials

    ConfigObjectCredentialsHolder() {
        def realm = new File("config.groovy")
        if (!realm.exists()) {
            throw new Exception("Can't find config file in ${realm.canonicalPath}")
        }
        credentials = new ConfigSlurper().parse(realm.toURI().toURL())
    }

    @Override
    Map getCredentials(Tracker tracker) {
        credentials."${tracker.configName}"
    }
}

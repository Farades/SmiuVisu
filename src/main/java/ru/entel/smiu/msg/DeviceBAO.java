package ru.entel.smiu.msg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeviceBAO implements Serializable {
    private Map<String, String> channelsValue = new HashMap<>();
    private Set<String> activeAlarms = new HashSet<>();

    public Map<String, String> getChannelsValue() {
        return channelsValue;
    }

    public Set<String> getActiveAlarms() {
        return activeAlarms;
    }

    public void setChannelsValue(Map<String, String> channelsValue) {
        this.channelsValue = channelsValue;
    }

    public void setActiveAlarms(Set<String> activeAlarms) {
        this.activeAlarms = activeAlarms;
    }

    @Override
    public String toString() {
        return "DeviceBAO{" +
                "channelsValue=" + channelsValue +
                ", activeAlarms=" + activeAlarms +
                '}';
    }
}

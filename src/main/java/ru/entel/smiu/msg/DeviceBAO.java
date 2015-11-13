package ru.entel.smiu.msg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeviceBAO implements Serializable {
    private Map<String, String> channelsValue = new HashMap<>();
    private Set<String> activeAlarms = new HashSet<>();


    public DeviceBAO() {

    }

    public synchronized void addChannel(String name, String value) {
        this.channelsValue.put(name, value);
    }

}

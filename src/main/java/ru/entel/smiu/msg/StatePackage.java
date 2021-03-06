package ru.entel.smiu.msg;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class StatePackage implements Serializable {
    private Map<String, DeviceBAO> allDevicesByName = new HashMap<>();

    public StatePackage() {

    }

    public StatePackage(Map<String, DeviceBAO> allDevicesByName) {
        this.allDevicesByName = allDevicesByName;
    }

    public Map<String, DeviceBAO> getAllDevicesByName() {
        return allDevicesByName;
    }

    public void setAllDevicesByName(Map<String, DeviceBAO> allDevicesByName) {
        this.allDevicesByName = allDevicesByName;
    }

    @Override
    public String toString() {
        return "StatePackage{" +
                "allDevicesByName=" + allDevicesByName +
                '}';
    }
}

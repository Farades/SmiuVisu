package ru.entel.smiu.visu.model;

import javafx.scene.control.Button;

import java.awt.*;
import java.util.*;

public class Device {
    private String name;
    private String type;
    private Map<String, String> values = new HashMap<>();
    private Set<String> activeAlarms = new HashSet<>();

    public Device(String name, String type, Map<String, String> values) {
        this.name = name;
        this.type = type;
        this.values = values;
    }

    public void imitationWorking() {

//        EnumMap<DeviceType, String> map = new EnumMap<DeviceType, String>();
//        map.put(DeviceType.DIRIS, "divis");
//
//
//        map.get(DeviceType.DIRIS);

        Button btn = new Button();
        btn.setUserData(new Label("asdad"));

        btn.getUserData();


        for (Map.Entry<String, String> entry : values.entrySet()) {

            values.put(entry.getKey(), String.valueOf(getRandomFloat()));
        }
    }

    public float getRandomFloat() {
        float minX = 160.0f;
        float maxX = 280.0f;

        Random rand = new Random();

        return rand.nextFloat() * (maxX - minX) + minX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    public Set<String> getActiveAlarms() {
        return activeAlarms;
    }

    public void setActiveAlarms(Set<String> activeAlarms) {
        this.activeAlarms = activeAlarms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (name != null ? !name.equals(device.name) : device.name != null) return false;
        return !(type != null ? !type.equals(device.type) : device.type != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", values=" + values +
                '}';
    }
}

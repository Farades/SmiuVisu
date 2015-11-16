package ru.entel.smiu.visu.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Configurator {
    private static Configurator instance;

    public Map<String, Device> getDevices() {
        Map<String, Device> devices = new HashMap<>();

        Map<String, String> ips1Values = new HashMap<>();
        ips1Values.put("Входное напряжение L1", "");
        ips1Values.put("Входное напряжение L2", "");
        ips1Values.put("Входное напряжение L3", "");
        Device device1 = new Device("ИБПС1", "IPS", ips1Values);

        Map<String, String> ips2Values = new HashMap<>();
        ips2Values.put("Входное напряжение L1", "");
        ips2Values.put("Входное напряжение L2", "");
        ips2Values.put("Входное напряжение L3", "");
        Device device2 = new Device("ИБПС2", "IPS", ips2Values);

        Map<String, String> mpx1Values = new HashMap<>();
        mpx1Values.put("Ток фазы L1", "");
        mpx1Values.put("Ток фазы L2", "");
        mpx1Values.put("Ток фазы L3", "");
        Device device3 = new Device("ИБПА1", "MPX", mpx1Values);

        Map<String, String> mpx2Values = new HashMap<>();
        mpx2Values.put("Ток фазы L1", "");
        mpx2Values.put("Ток фазы L2", "");
        mpx2Values.put("Ток фазы L3", "");
        Device device4 = new Device("ИБПА2", "MPX", mpx2Values);
//
//        devices.add(device1);
//        devices.add(device2);
//        devices.add(device3);
//        devices.add(device4);

        return devices;
    }

    public static synchronized Configurator getInstance() {
        if (instance == null) {
            instance = new Configurator();
        }
        return instance;
    }
}

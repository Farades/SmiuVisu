package ru.entel.smiu.visu.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.entel.smiu.msg.StatePackage;
import ru.entel.smiu.visu.engine.DeviceListener;
import ru.entel.smiu.visu.engine.MqttEngine;

import java.util.Map;
import java.util.Set;

/**
 * Created by farades on 15.11.15.
 */
public class TestEngine implements DeviceListener {
    private Map<String, Device> devices;

    private Gson gson;

    public TestEngine() {
        devices = Configurator.getInstance().getDevices();
        MqttEngine.getInstance().addDeviceListener(this);
        gson = new GsonBuilder().create();
    }

    @Override
    public void deviceUpdate(String devicesJson) {
        StatePackage statePackage = gson.fromJson(devicesJson, StatePackage.class);
    }
}

package ru.entel.smiu.visu.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import ru.entel.smiu.msg.DeviceBAO;
import ru.entel.smiu.msg.StatePackage;
import ru.entel.smiu.visu.controllers.VisuManager;
import ru.entel.smiu.visu.engine.DeviceListener;
import ru.entel.smiu.visu.engine.MqttEngine;

import java.util.*;

public class ModelEngine implements DeviceListener {
    private Map<String, Device> devices;
    private StatePackage actualState;
    private boolean linkToBackend = false;

    private Timer engineStateTimer;

    private Date lastUpdate = new Date();

    private Gson gson;

    public ModelEngine() {
        MqttEngine.getInstance().addDeviceListener(this);
        devices = Configurator.getInstance().getDevices();
        gson = new GsonBuilder().create();

        startStateChecker();

    }

    private void startStateChecker() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            Date date = new Date();
            if (date.getTime() - lastUpdate.getTime() > 1000) {
                setLinkToBackend(false);
//                MqttEngine
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setLinkToBackend(boolean linkToBackend) {
        this.linkToBackend = linkToBackend;
        if (linkToBackend == false) {
            VisuManager.getInstance().getHeaderController().setState("1");
        }
    }

    public HashMap<String, Set<String>> getActiveAlarms() {
        HashMap<String, Set<String>> res = null;
        if (actualState != null) {
            res = new HashMap<>();
            for (Map.Entry<String, DeviceBAO> entry : actualState.getAllDevicesByName().entrySet()) {
                String deviceName = entry.getKey();
                Set<String> activeAlarms = entry.getValue().getActiveAlarms();
                if (activeAlarms.size() > 0) {
                    res.put(deviceName, activeAlarms);
                }
            }
        }
        return res;
    }

    @Override
    public void deviceUpdate(String devicesJson) {
        actualState = gson.fromJson(devicesJson, StatePackage.class);
        VisuManager.getInstance().addDebugMsg(actualState.toString());
        System.out.println(actualState);
        lastUpdate = new Date();
        setLinkToBackend(true);
//        VisuManager.getInstance().addDebugMsg(getActiveAlarms().toString());
    }
}

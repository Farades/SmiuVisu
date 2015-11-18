package ru.entel.smiu.visu.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import ru.entel.smiu.msg.MqttService;
import ru.entel.smiu.visu.controllers.VisuManager;

import java.util.HashSet;
import java.util.Set;

public class MqttEngine implements MqttCallback {
    private static MqttEngine instance;

    private Set<DeviceListener> deviceListeners = new HashSet<>();

    public void addDeviceListener(DeviceListener deviceListener) {
        deviceListeners.add(deviceListener);
    }

    private static final Logger logger = Logger.getLogger(MqttEngine.class);

    private MqttClient client;

    private Gson gson;

    private final String CLIENT_ID = "smiu-visu-engine";

    private final String DEVICES_OUT_TOPIC = "smiu/DD/devices/out";

    public static synchronized MqttEngine getInstance() {
        if (instance == null) {
            instance = new MqttEngine();
        }
        return instance;
    }

    public static synchronized void reInit() {
        try {
            instance.getClient().close();
            instance = null;
            instance = new MqttEngine();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private MqttEngine() {
        mqttInit();
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public MqttClient getClient() {
        return client;
    }

    private void mqttInit() {
        try {
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);
            client = new MqttClient(MqttService.BROKER_URL, CLIENT_ID, new MemoryPersistence());

            client.setCallback(this);
            client.connect(connectOptions);

            client.subscribe(DEVICES_OUT_TOPIC, 0);
        } catch (MqttException e) {
            logger.error("Ошибка в функции mqttInit(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    private synchronized void send(String topicName, String data) {
        try {
            //Настройка топика и сообщения
            MqttTopic topic = client.getTopic(topicName);

     MqttMessage message = new MqttMessage(data.getBytes());
            message.setQos(MqttService.QOS);

            //Отправка сообщения
//            System.out.println("[" + Thread.currentThread().getName() + "] Publish msg: " + data);
            MqttDeliveryToken token = topic.publish(message);

            //Ждем пока сервер подтвердит получение сообщения
            token.waitForCompletion();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void notifyDeviceListener(String devicesJson) {
        for (DeviceListener deviceListener : deviceListeners) {
            deviceListener.deviceUpdate(devicesJson);
        }
    }

    @Override
    public void connectionLost(Throwable throwable) {
        VisuManager.getInstance().addDebugMsg("[Mqtt Engine] Connection Lost.");
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        if (s.equals(DEVICES_OUT_TOPIC)) {
            notifyDeviceListener(mqttMessage.toString());
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        client.disconnect();
    }
}

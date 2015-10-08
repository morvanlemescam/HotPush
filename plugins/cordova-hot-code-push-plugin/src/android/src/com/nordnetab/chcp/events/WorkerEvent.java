package com.nordnetab.chcp.events;

import com.nordnetab.chcp.config.ApplicationConfig;
import com.nordnetab.chcp.model.ChcpError;

import java.util.Map;

/**
 * Created by Nikolay Demyankov on 28.08.15.
 * <p/>
 * Base class for events, that generated by installation/download workers.
 *
 * @see com.nordnetab.chcp.updater.InstallationWorker
 * @see com.nordnetab.chcp.updater.UpdateLoaderWorker
 * @see IPluginEvent
 */
class WorkerEvent extends PluginEventImpl {

    private static final String CONFIG_KEY = "config";

    /**
     * Task identifier of the worker which dispatched this event.
     */
    public final String taskId;

    /**
     * Class constructor
     *
     * @param eventName string identifier of the event
     * @param error     error information
     * @param taskId    identifier of the worker
     * @param appConfig application config which this worker used
     * @see ChcpError
     * @see ApplicationConfig
     */
    protected WorkerEvent(String eventName, ChcpError error, String taskId, ApplicationConfig appConfig) {
        super(eventName, error);

        this.taskId = taskId;
        if (appConfig != null) {
            data().put(CONFIG_KEY, appConfig);
        }
    }

    /**
     * Getter for application config, attached to this event.
     * This config was used to perform download/installation work.
     *
     * @return application config
     */
    public ApplicationConfig applicationConfig() {
        final Map<String, Object> eventData = data();
        if (!eventData.containsKey(CONFIG_KEY)) {
            return null;
        }

        return (ApplicationConfig) eventData.get(CONFIG_KEY);
    }
}
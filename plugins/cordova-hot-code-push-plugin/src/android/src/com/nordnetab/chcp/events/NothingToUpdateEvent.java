package com.nordnetab.chcp.events;

import com.nordnetab.chcp.config.ApplicationConfig;
import com.nordnetab.chcp.model.ChcpError;

/**
 * Created by Nikolay Demyankov on 25.08.15.
 * <p/>
 * Event is send when there is nothing new to download from server.
 */
public class NothingToUpdateEvent extends WorkerEvent {

    private static final String EVENT_NAME = "chcp_nothingToUpdate";

    /**
     * Class constructor.
     *
     * @param taskId identifier of the current download task
     * @param config application config that was used for update download
     */
    public NothingToUpdateEvent(String taskId, ApplicationConfig config) {
        super(EVENT_NAME, ChcpError.NOTHING_TO_UPDATE, taskId, config);
    }

}

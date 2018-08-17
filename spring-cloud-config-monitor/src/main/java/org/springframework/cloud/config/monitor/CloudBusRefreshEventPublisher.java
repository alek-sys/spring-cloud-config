package org.springframework.cloud.config.monitor;

import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class CloudBusRefreshEventPublisher implements RefreshEventPublisher, ApplicationEventPublisherAware {

    private final String busId;
    private ApplicationEventPublisher applicationEventPublisher;

    CloudBusRefreshEventPublisher(String busId) {
        this.busId = busId;
    }

    @Override
    public void setApplicationEventPublisher(
            ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }


    @Override
    public void publishEvent(Object source, String destinationService) {
        this.applicationEventPublisher
                .publishEvent(new RefreshRemoteApplicationEvent(source, this.busId, destinationService));

    }
}

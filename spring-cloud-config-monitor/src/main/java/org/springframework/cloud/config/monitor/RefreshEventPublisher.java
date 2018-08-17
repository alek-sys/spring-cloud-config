package org.springframework.cloud.config.monitor;

public interface RefreshEventPublisher {
    void publishEvent(Object source, String destinationService);
}

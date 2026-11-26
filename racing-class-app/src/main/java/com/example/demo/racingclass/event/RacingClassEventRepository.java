package com.example.demo.racingclass.event;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;

import java.util.UUID;

@Repository
public class RacingClassEventRepository {
    private final RestClient restClient;

    public RacingClassEventRepository(@LoadBalanced RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://race-car-app").build();
    }

    public void create(UUID id) {
        restClient.put().uri("/api/racing-classes/{id}", id).retrieve().toBodilessEntity();
    }

    public void delete(UUID id) {
        restClient.delete().uri("/api/racing-classes/{id}", id).retrieve().toBodilessEntity();
    }
}

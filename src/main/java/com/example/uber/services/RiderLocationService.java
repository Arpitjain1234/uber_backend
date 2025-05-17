package com.example.uber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class RiderLocationService {

    @Autowired
    private StringRedisTemplate  stringRedisTemplate ;
    private static  final String REDIS_KEY = "riderLocation";

    public void addRiderLocation(String riderId, double riderLatitude, double riderLongitude){
        Point driverLocation = new Point(riderLongitude,riderLongitude);
        stringRedisTemplate.opsForGeo().add(REDIS_KEY,driverLocation,riderId);
    }

    public List<String> findNearestRiderFromUser(Double userLatitude, double userLongitude, double radius, int driverCount){
        Point userLocation = new Point(userLatitude,userLongitude);
        Distance circleRadius = new Distance(radius, Metrics.KILOMETERS);

        Circle searchArea = new Circle(userLocation,radius);
        RedisGeoCommands.GeoRadiusCommandArgs searchArgs = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs()
                .includeDistance()
                .sortAscending()
                .limit(driverCount);
        GeoResults<RedisGeoCommands.GeoLocation<String>> searchResults = stringRedisTemplate.opsForGeo()
                .radius(REDIS_KEY, searchArea, searchArgs);

        // Extract and return the list of driver IDs from the search results
        return searchResults.getContent().stream()
                .map(result -> result.getContent().getName())  // get the driver ID
                .collect(Collectors.toList());
    }
    public void removeRiderFromAvailability(String riderId) {
        stringRedisTemplate.opsForGeo().remove(REDIS_KEY, riderId);
    }
}

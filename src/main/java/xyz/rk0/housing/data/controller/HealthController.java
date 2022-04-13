package xyz.rk0.housing.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public final class HealthController {

    @GetMapping("/health")
    public String checkHealth() throws UnknownHostException {
        return "Hello my name is: " + InetAddress.getLocalHost().getHostName() + "!!!!";
    }
}

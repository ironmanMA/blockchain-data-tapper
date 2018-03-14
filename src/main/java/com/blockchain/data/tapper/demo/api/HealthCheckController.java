package com.blockchain.data.tapper.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HealthCheckController {
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String healthCheck() {
        return "OK";
    }
}

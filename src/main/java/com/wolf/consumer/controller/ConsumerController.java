package com.wolf.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wolf.common.service.ProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Reference(lazy = true,check = false)
    private ProviderService providerService;

    @GetMapping("/info")
    public String invokeProvider(){
        providerService.testDubbo();
        return "RPC";
    }
}

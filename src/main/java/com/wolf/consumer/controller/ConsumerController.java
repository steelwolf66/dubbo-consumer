package com.wolf.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wolf.common.entity.BaseController;
import com.wolf.common.service.ProviderService;
import com.wolf.common.utils.HttpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/consumer")
public class ConsumerController extends BaseController {

    @Reference(lazy = true)
    private ProviderService providerService;

    @GetMapping("/info")
    public String invokeProvider(){
        providerService.testDubbo();
        logger.info("after provider");
        HttpUtils.getResponse().setStatus(HttpServletResponse.SC_OK);
        return "Test Dubbo RPC success";
    }
}

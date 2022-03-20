package com.github.ls.seata.serviceb.controller;

import com.github.ls.seata.serviceb.response.ServiceBResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-b")
public interface IController {

  @GetMapping("t1")
  ServiceBResponse get();
}

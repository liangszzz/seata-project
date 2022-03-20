package com.github.ls.seata.serviceb.impl;

import com.github.ls.seata.serviceb.controller.IController;
import com.github.ls.seata.serviceb.dao.T1Dao;
import com.github.ls.seata.serviceb.model.T1;
import com.github.ls.seata.serviceb.response.ServiceBResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RequestMapping("/t1")
@RestController
public class ControllerImpl implements IController {

  @Resource private T1Dao t1Dao;

  @Transactional
  @GetMapping
  @Override
  public ServiceBResponse get() {
    T1 t1 = new T1();
    t1.setName(LocalDateTime.now().toString());
    t1Dao.save(t1);
    ServiceBResponse response = new ServiceBResponse();
    BeanUtils.copyProperties(t1, response);
    return response;
  }
}

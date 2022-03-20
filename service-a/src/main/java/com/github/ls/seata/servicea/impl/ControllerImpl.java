package com.github.ls.seata.servicea.impl;

import com.github.ls.seata.servicea.dao.T1Dao;
import com.github.ls.seata.servicea.model.T1;
import com.github.ls.seata.serviceb.controller.IController;
import com.github.ls.seata.serviceb.response.ServiceBResponse;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RequestMapping("/t1")
@RestController
public class ControllerImpl {

  @Resource private T1Dao t1Dao;

  @Resource private IController iController;

  @Transactional
  @GlobalTransactional(rollbackFor = Exception.class)
  @GetMapping
  public Integer insert() {

    long count = t1Dao.count();

    T1 t1 = new T1();
    t1.setName(LocalDateTime.now().toString());
    t1Dao.save(t1);

    long count2 = t1Dao.count();

    ServiceBResponse response = iController.get();
    System.out.println(response.toString());
    int a = 1 / 0;
    return t1.getId();
  }
}

package com.endeavor.demo.controller;


import com.endeavor.demo.service.RoleService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "角色接口",tags = "角色接口")
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);


}

package com.netcracker.name.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @RequestMapping(value = "/get-simple-object")
    SimpleObject getSimpleString() {
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setId("1");
        simpleObject.setName("name");
        return simpleObject;
    }

    class SimpleObject {

    }
}

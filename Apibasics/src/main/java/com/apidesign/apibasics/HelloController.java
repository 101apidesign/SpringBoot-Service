package com.apidesign.apibasics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apidesign.apibasics.pojo.Salutation;
 
@RestController
public class HelloController {
 
	@RequestMapping(method=RequestMethod.GET, path="/")
    public Salutation get() {
        return new Salutation("Hello World!");
    }
}


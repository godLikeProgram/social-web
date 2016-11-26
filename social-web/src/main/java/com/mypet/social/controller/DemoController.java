package com.mypet.social.controller;

import com.mypet.social.model.User;
import com.mypet.social.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mrhou on 2016/11/26.
 */
@RestController
@RequestMapping("/user")
public class DemoController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建用户", notes = "")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 500, message = "fail")
    })
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity index(@ApiParam @ModelAttribute User user){

        userService.insert(user);

        return new ResponseEntity(HttpStatus.CREATED);
    }
}

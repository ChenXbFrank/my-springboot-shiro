package com.cxb.myspringbootshiro.controller;

import com.cxb.myspringbootshiro.result.Result;
import com.cxb.myspringbootshiro.result.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <P></P>
 *
 * @author zhaodong zhaodongxx@outlook.com
 * @version v1.0
 * @since 2018/3/30 21:55
 */
@RestController
public class IndexController {

    @GetMapping("/helloworld")
    public Result helloWorld() {

        return ResultGenerator.genSuccessResult("helloworld");
    }
}

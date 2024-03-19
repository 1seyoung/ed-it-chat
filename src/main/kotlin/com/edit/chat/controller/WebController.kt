package com.edit.chat.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping



@Controller
class WebController {

    @GetMapping("/", "/error")
    fun index(): String {
        return "forward:/index.html"
    }

}
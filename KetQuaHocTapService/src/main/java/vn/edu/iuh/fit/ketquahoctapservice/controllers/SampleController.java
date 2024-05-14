package vn.edu.iuh.fit.ketquahoctapservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("SampleController")
public class SampleController {
    @GetMapping()
    public String SampleController(){
        return "SampleController";
    }
}

package vn.edu.iuh.fit.lichhocservice.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/LichHocService")
public class LichHocController {
    @GetMapping("/lichhoc")
    public String lichhoc() {
        System.out.println("alo alo");
        return "lichhoc";
    }
}

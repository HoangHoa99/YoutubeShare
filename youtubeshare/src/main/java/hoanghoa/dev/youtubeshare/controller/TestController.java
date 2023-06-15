package hoanghoa.dev.youtubeshare.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping()
    public String test(@RequestParam String name) {
        return "Hello " + name + ". I am youtube share application";
    }
}

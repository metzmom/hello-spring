//package org.launchcode.hellospring.controllers;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class HelloController {
//
//
////        @GetMapping //Tells springboot this should handle Get requests
////        @ResponseBody//returns a plain text response.. no template
////        public String hello() {
////            return "Hello, Spring!";
////        }
//    //Handles request at /hello  localhost:8080/hello
//    @GetMapping("hello") //path that tells request handler to live at hello
//    @ResponseBody//returns a plain text response.. no template
//    public String hello() {
//        return "Hello, Spring!";
//    }
//    // //Handles request at /goodbye  localhost:8080/goodbye
//    @GetMapping("goodbye") //path that tells request handler to live at goodbye currently only accepts GET requests
//    @ResponseBody//returns a plain text response.. no template
//    public String goodbye() {
//        return "Goodbye, Spring!";
//    }
//}
package org.launchcode.hellospring.controllers;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
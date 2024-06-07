package com.gustavofdasilva.sandbox;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @GetMapping("/helloworld")
    public String sayHello() {
        return "HELLO! from my first controller!";
    }

    @PostMapping("/sendOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendOrder(
        @RequestBody Order order
    ) {
        order.setCustomerName(order.getCustomerName().replace("A", "O"));
        return order.toString();
    }

    @PostMapping("/sendOrder-record")
    @ResponseStatus(HttpStatus.CREATED)
    public String sendOrderRecord(
        @RequestBody OrderRecord order
    ) {
        return order.toString();
    }

    @GetMapping("/hello/{page}")
    public String pathVar(
        @PathVariable String page,
        @RequestParam("id") String id
    ) {
        
        return "PATHVALUE: "+ page + "; PARAMS: "+id;
    }















    @GetMapping("/calculator/{operation}")
    public int calculate(
        @PathVariable String operation,
        @RequestParam("n1") int num1,
        @RequestParam("n2") int num2
    ) {
        switch(operation) {
            case "add":
                return num1 + num2;
        
            case "subtract":
                return num1 - num2;
            
            case "multiply":
                return num1 * num2;

            case "divide":
                return num1 / num2;

            default:
                return 0;
        }
    }
}

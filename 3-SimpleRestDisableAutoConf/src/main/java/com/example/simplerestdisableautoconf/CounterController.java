package com.example.simplerestdisableautoconf;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CounterController {

    int id = 0;
    private List<Counter> listCounter = new ArrayList<>();

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome - This is a Simple Rest Service developed with Spring framework!";
    }

    @PostMapping ("/zero_counter")
    public synchronized void addZeroCounter(@RequestParam(value = "name") String name) {
        listCounter.add(new Counter(id=+1, name, 0));
    }

    @PostMapping ("/counter")
    public synchronized void addCounter(@RequestParam(value = "name") String name, @RequestParam(value = "count") int count) {
        listCounter.add(new Counter(id=+1, name, count));
    }

    @GetMapping ("/getListCounter")
    ResponseEntity<List<Counter>> getListCounters(){
        if (listCounter.size()!=0)
            return new ResponseEntity<>(listCounter, HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.FAILED_DEPENDENCY);
    }

    @GetMapping ("/getCounter")
    ResponseEntity<Counter> getCounter(@RequestParam(value = "id") int id){
        for(int i=0; i< listCounter.size();i++)
            if (listCounter.get(i).getId() == id)
                return new ResponseEntity<>(listCounter.get(i), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.FAILED_DEPENDENCY);
    }


    @DeleteMapping("/delCounter")
    ResponseEntity<String> delCounter(@RequestParam(value = "id") int id){
        for(int i=0; i< listCounter.size();i++)
            if (listCounter.get(i).getId() == id){
                listCounter.remove(i);
                return new ResponseEntity<>("Counter removed", HttpStatus.OK);
            }
        return new ResponseEntity<>("Counter with index " + id + " not found", HttpStatus.FAILED_DEPENDENCY);
    }

}

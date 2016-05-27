package template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import template.service.NumberService;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @RequestMapping(value="average", method = RequestMethod.POST)
    public Double average(@RequestBody List<Double> numbers) {
        return numberService.average(numbers);
    }

    @RequestMapping(value="positiveNumbers", method = RequestMethod.POST)
    public List<Double> positiveNumbers(@RequestBody List<Double> numbers,
                                        @RequestParam(required = false) Boolean zeroIncluded) {
        return numberService.positiveNumbers(numbers, zeroIncluded);
    }

    @RequestMapping(value="sort", method = RequestMethod.POST)
    public List<Double> sort(@RequestBody List<Double> numbers,
                             @RequestParam(required = false) Boolean desc) {
        return numberService.sort(numbers, desc);
    }

}

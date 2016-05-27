package template.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class NumberService {

    /**
     * Returns the average of the given numbers
     */
    public Double average(List<Double> numbers) {
        return numbers.stream().reduce(0.0, (sum, num) -> sum + num) / numbers.size();
    }

    /**
     * Filters and returns positive values of the given numbers.
     * Value zero is included if parameter zeroIncluded is true.
     */
    public List<Double> positiveNumbers(List<Double> numbers, Boolean zeroIncluded) {
        Predicate<Double> predicate =
                (zeroIncluded == null || zeroIncluded == false) ? num -> num > 0 : num -> num >= 0;

        return numbers.stream().filter(num -> predicate.test(num)).collect(Collectors.toList());
    }

    /**
     * Returns the given numbers in a sorted order. Order is descending if parameter desc is true.
     */
    public List<Double> sort(List<Double> numbers, Boolean desc) {
        numbers.sort((num1, num2) ->
                (desc == null || desc == false) ? num1.compareTo(num2) : num2.compareTo(num1)
        );
        return numbers;
    }

}

package pl.sda.listopad.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeMockData {

    private final EmployeeService service;

    @PostConstruct
    void saveMockEmployees() {
        List<Employee> employees = List.of(
        createEmployee("Bananaman","Cameltoe","baca@gmial.com","12121212123",23),
        createEmployee("Bumblebee","Cumberbitch","bucu@gmial.com","1234567890",25),
        createEmployee("Bubbledil","Cumberflap","bucumber@gmial.com","80101001999",66),
        createEmployee("Buckingham","Scratch-n-sniff","buckscratch@gmial.com","12124562123",23),
        createEmployee("Congacrimp","Commonfap","congac@gmial.com","12121219753",54),
        createEmployee("Bourgeoisie","Camouflage","comuflage@gmial.com","13245212123",87),
        createEmployee("Bubblebutt","Chickenlegs","chickenbutt@gmial.com","77112276888",44)
        );
        service.saveEmployees(employees);
    }

    private Employee createEmployee(String name, String surname, String email, String pesel, Integer age) {
        return new Employee()
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setPesel(pesel)
                .setAge(age);
    }

}

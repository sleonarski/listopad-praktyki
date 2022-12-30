package pl.sda.listopad.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping
    String redirect() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    String getEmployees(final Model model) {
        List<Employee> employees = service.getAll();
        model.addAttribute("employees", employees);
        return "index";
    }
    @Valid
    @GetMapping("/add-employee-form")
    String addEmployeeForm(final Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping("/add-employee")
    String addEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()){
            return "add-employee";
        }
        service.saveEmployee(employee);
        return "redirect:/index";
    }
   @GetMapping("/update-employee-form/{id}")
    public String updateEmployeeForm(@PathVariable Long id, final Model model) {
        Employee employee = service.findById(id);
        model.addAttribute("employee", employee);
        return "update-employee";
   }

    @PostMapping("/update-employee")
    String updateEmployee(Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/delete-employee/{id}")
    String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/index";
    }

}

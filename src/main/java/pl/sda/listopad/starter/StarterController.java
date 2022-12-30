package pl.sda.listopad.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StarterController {

    @GetMapping("/starter/{name}")
    public String starterPage(@PathVariable String name, final Model model) {
        model
                .addAttribute("name",name)
                .addAttribute("message","Hello");

        return "starter";
    }




}

package edu.ap.spring;

import java.util.Map;

import edu.ap.spring.redis.InhaalExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javasampleapproach.redis.model.Customer;
import com.javasampleapproach.redis.repo.CustomerRepository;

@RestController
public class WebController {

    private InhaalExamenRepository repo;

    @RequestMapping("/save")
    public String save() {
        // save a single Customer
        repo.
    }
}
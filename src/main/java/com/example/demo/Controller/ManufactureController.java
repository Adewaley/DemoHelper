package com.example.demo.Controller;

import com.example.demo.Entity.Manufacture;
import com.example.demo.Service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manufacture")
public class ManufactureController {
    @Autowired
    private ManufactureService manufactureService;

    @GetMapping
    public Manufacture getManufactureById(@RequestParam("id") Integer manufactureId) {
        if (manufactureId == null) {
            return null;
        }
        return manufactureService.findOneById(manufactureId);
    }

    @PostMapping
    public Manufacture createManufacture(@RequestParam("department") String department,
                                         @RequestParam("phone") String phone,
                                         @RequestParam("email") String email,
                                         @RequestParam("web") String web) {
        if (department == null || phone == null || email == null || web == null) {
            return null;
        }
        Manufacture newManufacture = new Manufacture();
        newManufacture.setDepartment(department);
        newManufacture.setEmail(email);
        newManufacture.setPhone(phone);
        newManufacture.setWeb(web);
        return manufactureService.save(newManufacture);
    }
}

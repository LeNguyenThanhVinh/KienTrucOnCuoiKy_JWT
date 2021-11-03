package com.example.driverservice.Controller;

import com.example.driverservice.Entity.Driver;
import com.example.driverservice.Service.DriverService;
import com.example.driverservice.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
//@EnableEurekaClient
public class UserController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public Driver saveDriver(@RequestBody Driver driver){

        return driverService.saveDriver(driver);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getDriverWithCustomer(@PathVariable("id")
                                                            Long driverId){
        return driverService.getDriverWithCustomer(driverId);
    }
}

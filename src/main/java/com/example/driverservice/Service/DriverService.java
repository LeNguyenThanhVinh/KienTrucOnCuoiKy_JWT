package com.example.driverservice.Service;

import com.example.driverservice.Entity.Driver;
import com.example.driverservice.Repository.DriverRepository;
import com.example.driverservice.VO.Customer;
import com.example.driverservice.VO.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public ResponseTemplateVO getDriverWithCustomer(Long driverId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Driver driver = driverRepository.findById(driverId).get();
        vo.setDriver(driver);
        Customer customer =
                restTemplate.getForObject("http://localhost:9001/customer/"
                                + driver.getCustomerId(),
                        Customer.class);

        vo.setCustomer(customer);

        return vo;
    }
}

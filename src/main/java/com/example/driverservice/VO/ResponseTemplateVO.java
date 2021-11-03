package com.example.driverservice.VO;

import com.example.driverservice.Entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Driver driver;
    private Customer customer;
}

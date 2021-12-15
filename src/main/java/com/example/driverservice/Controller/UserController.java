package com.example.driverservice.Controller;

import com.example.driverservice.Entity.Driver;
import com.example.driverservice.Entity.Token;
import com.example.driverservice.Entity.User;
import com.example.driverservice.Service.DriverService;
import com.example.driverservice.Service.TokenService;
import com.example.driverservice.Service.UserService;
import com.example.driverservice.VO.ResponseTemplateVO;
import com.example.driverservice.authen.UserPrincipal;
import com.example.driverservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
//@EnableEurekaClient
public class UserController {
    @Autowired
    private DriverService driverService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public Driver saveDriver(@RequestBody Driver driver){

        return driverService.saveDriver(driver);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getDriverWithCustomer(@PathVariable("id")
                                                            Long driverId){
        return driverService.getDriverWithCustomer(driverId);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){

        UserPrincipal userPrincipal =
                userService.findByUsername(user.getUsername());

//        if (null == user || !new BCryptPasswordEncoder()
//                .matches(user.getPassword(), userPrincipal.getPassword())) {
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body("Account or password is not valid!");
//        }
        System.out.println(user.getPassword()+" "+ userPrincipal.getPassword());
        if (null == user||!user.getPassword().trim().equals(userPrincipal.getPassword().trim())) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Account or password is not valid!");
        }
        Token token = new Token();
        token.setToken(jwtUtil.generateToken(userPrincipal));

        token.setTokenExpDate(jwtUtil.generateExpirationDate());
        token.setCreatedBy(userPrincipal.getUserId());
        tokenService.createToken(token);

        return ResponseEntity.ok(token.getToken());
    }
}

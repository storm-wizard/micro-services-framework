package ucd.healthcare.yanpharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ucd.healthcare.yanpharmacy.service.YanPharmacyService;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping(value = "v1/pharmacy/")
public class YanPharmacyController {
    @Autowired
    private YanPharmacyService service;

    @RequestMapping(method = RequestMethod.GET, value = "/printsth")
    public void printSomething() {
        try {
            System.out.println("you are coming"  + InetAddress.getLocalHost().getHostName());
            service.print();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

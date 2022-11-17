package ucd.healthcare.yanpharmacy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ucd.healthcare.yanpharmacy.model.Medicine;
import ucd.healthcare.yanpharmacy.service.YanPharmacyService;

@RestController
@RequestMapping(value = "v1/pharmacy")
public class YanPharmacyController {
    @Autowired
    private YanPharmacyService service;

    @RequestMapping(method = RequestMethod.POST, value = "/m")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine obj) {
        service.print();
        return new ResponseEntity<>(service.addMedicine(obj), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/m")
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        service.print();
        return new ResponseEntity<>(service.getAllMedicines(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/m/names")
    public ResponseEntity<List<Medicine>> getAllMedicinesByNames(@RequestBody List<String> names) {
        service.print();
        return new ResponseEntity<>(service.getMedicinesByNames(names), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/m/name/${name}")
    public ResponseEntity<Medicine> getAllMedicinesByName(@PathVariable("name") String name) {
        service.print();
        return new ResponseEntity<>(service.getMedicinesByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/printsth")
    public void printSomething() {
        service.print();
    }
}

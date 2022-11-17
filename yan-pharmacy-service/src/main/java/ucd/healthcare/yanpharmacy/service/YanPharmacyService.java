package ucd.healthcare.yanpharmacy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import ucd.healthcare.yanpharmacy.model.Medicine;
import ucd.healthcare.yanpharmacy.repository.YanPharmacyRepository;

@Service
public class YanPharmacyService {
    private static final Logger logger = LoggerFactory.getLogger(YanPharmacyService.class);

    @Autowired
    private Environment env;

    @Autowired
    YanPharmacyRepository repository;

    public List<Medicine> getAllMedicines() {
        List<Medicine> medicines = repository.findAll();
        return medicines.size() > 0 ? medicines : new ArrayList<Medicine>();
    }

    public Medicine addMedicine(Medicine entity) {
        Optional<Medicine> medicine = repository.findByName(entity.getName());
        if (medicine.isPresent()) {
            Medicine newEntity = medicine.get();
            newEntity.setName(entity.getName());
            newEntity.setPrice(entity.getPrice());
            repository.save(newEntity);
            return newEntity;
        } else {
            repository.save(entity);
            return entity;
        }
    }

    public List<Medicine> getMedicinesByNames(List<String> names) {
        List<Medicine> medicines = repository.findByNames(names);
        return medicines.size() > 0 ? medicines : new ArrayList<Medicine>();
    }

    public Medicine getMedicinesByName(String name) {
        Optional<Medicine> medicine = repository.findByName(name);
        if (medicine.isPresent()) {
            return medicine.get();
        } else {
            return null;
        }
    }

    public void deleteMedicine(String name) {
        Optional<Medicine> opt = repository.findByName(name);
        if (opt.isPresent()) {
            repository.delete(opt.get());
        }
    }

    public void print() {
        System.out.println("I'm coming");
        System.out.println(env.getProperty("CONTAINER_NUMBER"));
    }
}

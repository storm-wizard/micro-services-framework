package ucd.healthcare.yanpharmacy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class YanPharmacyService {
    private static final Logger logger = LoggerFactory.getLogger(YanPharmacyService.class);

    @Autowired
    private Environment env;

    public void print(){
        System.out.println("I'm coming");
        System.out.println(env.getProperty("CONTAINER_NUMBER"));
    }
}

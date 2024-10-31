package org.rentapp.electricityservice.service;

import org.rentapp.electricityservice.entity.EBill;
import org.rentapp.electricityservice.exception.EBillNotFoundException;
import org.rentapp.electricityservice.repository.EBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EBillService {

    @Autowired
    EBillRepository ebillrepo;

    public EBill addEBill(EBill ebill){
        ebill.setAmount(ebill.calculateBillAmount());
        return ebillrepo.save(ebill);
    }

    public List<EBill> getAllEBill(){
        return ebillrepo.findAll();
    }

    public List<EBill> getEBillsByApartementId(Long apartmentId){
        return ebillrepo.findByApartmentId(apartmentId);
    }

    public EBill getEBillById(long id) throws EBillNotFoundException{
        return ebillrepo.findById(id).orElseThrow(()->new EBillNotFoundException("EBill Not found"));
    }

    public void deleteEBill(long id) throws EBillNotFoundException{
        if(!ebillrepo.existsById(id)){
            throw new EBillNotFoundException("EBill not found");
        }
        ebillrepo.deleteById(id);
    }
}

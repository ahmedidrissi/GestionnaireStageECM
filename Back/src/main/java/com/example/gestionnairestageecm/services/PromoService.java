package com.example.gestionnairestageecm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gestionnairestageecm.models.Promo;
import com.example.gestionnairestageecm.repositories.PromoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PromoService {
    
    @Autowired
    private PromoRepository promoRepository;

    public List<Promo> getAllPromos() {
        return promoRepository.findAll();
    }

    public Promo getPromoByYear(int year) {
        return promoRepository.findByYear(year).get();
    }

    public Promo savePromo(Promo promo) {
        return promoRepository.save(promo);
    }

    public Promo updatePromo(int year, Promo newPromo) {
        Promo promo = promoRepository.findByYear(year).get();
        promo.setProfessorId(newPromo.getProfessorId());
        promo.setRegistredNumber(newPromo.getRegistredNumber());
        promo.setReceiptsNumber(newPromo.getReceiptsNumber());
        return promoRepository.save(promo);
    }

    public void deletePromo(Long promoId) {
        promoRepository.deleteById(promoId);
    }

}

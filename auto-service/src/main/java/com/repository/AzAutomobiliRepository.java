package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.AzAutomobili;

@Repository
public interface AzAutomobiliRepository extends JpaRepository<AzAutomobili, Integer> {
    List<AzAutomobili> findByAzTipAutomobila_NazivTipa(String nazivTipa);
    List<AzAutomobili> findByKilometrazaLessThanEqual(int kilometraza);
    List<AzAutomobili> findByCenaLessThanEqual(int cena);
    List<AzAutomobili> findByCenaGreaterThanEqual(int cena);
    List<AzAutomobili> findByKilometrazaGreaterThanEqual(int kilometraza);
    List<AzAutomobili> findByMarka(String marka);
    List<AzAutomobili> findByGodinaProizvodnjeGreaterThanEqual(int godinaProizvodnje);
    List<AzAutomobili> findByGodinaProizvodnjeLessThanEqual(int godinaProizvodnje);


}
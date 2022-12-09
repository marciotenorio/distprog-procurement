package br.imd.distprog.procurement.repository;

import br.imd.distprog.procurement.model.SaleProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {
    void removeAllBySaleId(Long id);
}

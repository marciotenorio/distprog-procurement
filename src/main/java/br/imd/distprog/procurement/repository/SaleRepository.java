package br.imd.distprog.procurement.repository;

import br.imd.distprog.procurement.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}

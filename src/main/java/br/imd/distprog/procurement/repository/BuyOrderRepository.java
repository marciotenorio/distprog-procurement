package br.imd.distprog.procurement.repository;

import br.imd.distprog.procurement.model.BuyOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyOrderRepository extends JpaRepository<BuyOrder, Long> {
}

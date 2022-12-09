package br.imd.distprog.procurement.model;

import br.imd.distprog.procurement.util.DBSchema;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buy_order", schema = DBSchema.PROCUREMENT)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BuyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private boolean isApproved;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BuyOrder buyOrder = (BuyOrder) o;
        return id != null && Objects.equals(id, buyOrder.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package br.imd.distprog.procurement.model;

import br.imd.distprog.procurement.util.DBSchema;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sale_product", schema = DBSchema.PROCUREMENT)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long saleId;

    @NotNull
    private Long productId;

    @Transient
    private List<Product> products;

    @Transient
    private List<Sale> sales;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SaleProduct that = (SaleProduct) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package br.imd.distprog.procurement.model;

import br.imd.distprog.procurement.util.DBSchema;

import javax.persistence.*;

@Entity
@Table(name = "buy_order", schema = DBSchema.PROCUREMENT)
public class BuyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private boolean isApproved;
}

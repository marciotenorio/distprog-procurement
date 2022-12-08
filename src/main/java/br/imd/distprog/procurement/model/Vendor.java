package br.imd.distprog.procurement.model;

import lombok.Data;

@Data
public class Vendor {

    private Long id;

    private String name;

    private VendorType type;

    private boolean isApproved;
}

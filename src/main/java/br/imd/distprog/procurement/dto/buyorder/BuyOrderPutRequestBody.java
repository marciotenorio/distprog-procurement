package br.imd.distprog.procurement.dto.buyorder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyOrderPutRequestBody {

    private Long id;

    private String description;

    private boolean isApproved;
}

package br.imd.distprog.procurement.dto.sale;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class SalePutRequestBody {

    private Long id;

    private List<Long> productsId;

    private BigDecimal price;
}

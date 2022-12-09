package br.imd.distprog.procurement.dto.sale;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SalePostRequestBody {

    private List<Long> productsId;

}

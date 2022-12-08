package br.imd.distprog.procurement.dto.sale;

import br.imd.distprog.procurement.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SaleMapper {

    SaleMapper INSTANCE = Mappers.getMapper(SaleMapper.class);

    Sale postRequestBodyToSale(SalePostRequestBody salePostRequestBody);

    Sale putRequestBodyToSale(SalePutRequestBody salePutRequestBody);
}

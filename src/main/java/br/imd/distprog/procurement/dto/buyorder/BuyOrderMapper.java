package br.imd.distprog.procurement.dto.buyorder;

import br.imd.distprog.procurement.model.BuyOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuyOrderMapper {

    BuyOrderMapper INSTANCE = Mappers.getMapper(BuyOrderMapper.class);

    BuyOrder postRequestBody(BuyOrderPostRequestBody buyOrderPostRequestBody);

    BuyOrder putRequestBody(BuyOrderPutRequestBody buyOrderPutRequestBody);
}

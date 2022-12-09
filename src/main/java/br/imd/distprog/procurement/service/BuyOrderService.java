package br.imd.distprog.procurement.service;

import br.imd.distprog.procurement.dto.buyorder.BuyOrderMapper;
import br.imd.distprog.procurement.dto.buyorder.BuyOrderPostRequestBody;
import br.imd.distprog.procurement.dto.buyorder.BuyOrderPutRequestBody;
import br.imd.distprog.procurement.exception.BadRequestException;
import br.imd.distprog.procurement.model.BuyOrder;
import br.imd.distprog.procurement.repository.BuyOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuyOrderService {

    private BuyOrderRepository buyOrderRepository;

    public List<BuyOrder> findAll() {
        return buyOrderRepository.findAll();
    }

    public BuyOrder save(BuyOrderPostRequestBody buyOrderPostRequestBody) {
        BuyOrder buyOrder = BuyOrderMapper.INSTANCE.postRequestBodyToBuyOrder(buyOrderPostRequestBody);
        return buyOrderRepository.save(buyOrder);
    }

    public void deleteById(Long id) {
        findByIdOrThrowBadRequestException(id);
        buyOrderRepository.deleteById(id);
    }

    public void replace(BuyOrderPutRequestBody buyOrderPutRequestBody) {
        BuyOrder incomingBuyOrder = findByIdOrThrowBadRequestException(buyOrderPutRequestBody.getId());
        BuyOrder buyOrder = BuyOrderMapper.INSTANCE.putRequestBodyToBuyOrder(buyOrderPutRequestBody);
        buyOrder.setId(incomingBuyOrder.getId());
        buyOrderRepository.save(buyOrder);
    }

    public BuyOrder findByIdOrThrowBadRequestException(Long id) {
        return buyOrderRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Buy order not found!"));
    }

}

package br.imd.distprog.procurement.controller;

import br.imd.distprog.procurement.dto.buyorder.BuyOrderPostRequestBody;
import br.imd.distprog.procurement.dto.buyorder.BuyOrderPutRequestBody;
import br.imd.distprog.procurement.model.BuyOrder;
import br.imd.distprog.procurement.service.BuyOrderService;
import br.imd.distprog.procurement.util.Route;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Route.BUY_ORDERS)
public class BuyOrderController {

    private BuyOrderService buyOrderService;

    @GetMapping
    public ResponseEntity<List<BuyOrder>> findAll(){
        return ResponseEntity.ok(buyOrderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyOrder> findById(@PathVariable Long id){
        return ResponseEntity.ok(buyOrderService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<BuyOrder> save(@RequestBody BuyOrderPostRequestBody buyOrderPostRequestBody){
        return new ResponseEntity<>(buyOrderService.save(buyOrderPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody BuyOrderPutRequestBody buyOrderPutRequestBody){
        buyOrderService.replace(buyOrderPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        buyOrderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

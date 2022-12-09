package br.imd.distprog.procurement.controller;

import br.imd.distprog.procurement.dto.sale.SalePostRequestBody;
import br.imd.distprog.procurement.dto.sale.SalePutRequestBody;
import br.imd.distprog.procurement.model.Sale;
import br.imd.distprog.procurement.service.SaleService;
import br.imd.distprog.procurement.util.Route;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Route.SALES)
@AllArgsConstructor
public class SaleController {

    private SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> findAll(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id){
        return ResponseEntity.ok(saleService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody SalePostRequestBody salePostRequestBody){
        return new ResponseEntity<>(saleService.save(salePostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody SalePutRequestBody salePutRequestBody){
        saleService.replace(salePutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        saleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package br.imd.distprog.procurement.service;

import br.imd.distprog.procurement.client.inventorymanagement.ProductClient;
import br.imd.distprog.procurement.dto.sale.SalePostRequestBody;
import br.imd.distprog.procurement.dto.sale.SalePutRequestBody;
import br.imd.distprog.procurement.exception.BadRequestException;
import br.imd.distprog.procurement.model.Product;
import br.imd.distprog.procurement.model.Sale;
import br.imd.distprog.procurement.model.SaleProduct;
import br.imd.distprog.procurement.repository.SaleProductRepository;
import br.imd.distprog.procurement.repository.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;

    private SaleProductRepository saleProductRepository;

    private ProductClient productClient;


    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Transactional
    public Sale save(SalePostRequestBody salePostRequestBody) {
        List<Product> products = new ArrayList<>();

        // It's just to have more requests xD
        for (Long id : salePostRequestBody.getProductsId()){
            products.add(productClient.findById(id));
        }

        BigDecimal total =  products.stream()
                .map(Product::getPrice).toList()
                .stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        Sale sale = new Sale();
        sale.setPrice(total);

        Sale savedSale = saleRepository.save(sale);

        for (Product  product : products) {
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.setSaleId(savedSale.getId());
            saleProduct.setProductId(product.getId());
            saleProductRepository.save(saleProduct);
        }

        return savedSale;
    }

    public void deleteById(Long id) {
        findByIdOrThrowBadRequestException(id);
        saleRepository.deleteById(id);
    }

    @Transactional
    public void replace(SalePutRequestBody salePutRequestBody) {
        Sale incomingSale = findByIdOrThrowBadRequestException(salePutRequestBody.getId());

        saleProductRepository.removeAllBySaleId(incomingSale.getId());

        SalePostRequestBody salePostRequestBody = new SalePostRequestBody();
        salePostRequestBody.setProductsId(salePutRequestBody.getProductsId());

        save(salePostRequestBody);
    }

    public Sale findByIdOrThrowBadRequestException(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Sale not found!"));
    }
}

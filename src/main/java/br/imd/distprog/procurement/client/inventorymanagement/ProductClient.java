package br.imd.distprog.procurement.client.inventorymanagement;

import br.imd.distprog.procurement.model.Product;
import br.imd.distprog.procurement.util.Route;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductClient {

    public Product findById(Long id){
        return new RestTemplate()
                .getForObject(Route.INVENTORY_MANAGEMENT_PRODUCTS_BY_ID, Product.class, id);
    }

}

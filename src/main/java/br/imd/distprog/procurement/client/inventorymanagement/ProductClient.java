package br.imd.distprog.procurement.client.inventorymanagement;

import br.imd.distprog.procurement.exception.UnavailableResourceException;
import br.imd.distprog.procurement.model.Product;
import br.imd.distprog.procurement.util.Route;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductClient {

    public Product findById(Long id){
        try{
            return new RestTemplate()
                    .getForObject(Route.INVENTORY_MANAGEMENT_PRODUCTS_BY_ID, Product.class, id);
        } catch (ResourceAccessException e){
            throw new UnavailableResourceException("External dependecy unavailable.");
        }
    }

}

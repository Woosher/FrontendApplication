package application.controllers;
import application.models.ResponseBody;
import application.models.SearchProduct;
import application.models.SearchRule;
import application.networkservices.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SearchController {

    ProductService productService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public void setUserService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchRule search, Errors errors) {
        ResponseBody result = new ResponseBody();
        if (errors.hasErrors()) {
            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);
        }
        List<SearchProduct> products = productService.findProducts(search.getSearchtext());
        if (products.isEmpty()) {
            result.setMsg("no product found!");
        } else {
            result.setMsg("success");
        }
        result.setSearchProductList(products);
        return ResponseEntity.ok(result);

    }

}
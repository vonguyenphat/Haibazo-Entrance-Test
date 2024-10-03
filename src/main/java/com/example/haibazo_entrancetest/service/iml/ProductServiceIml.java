package com.example.haibazo_entrancetest.service.iml;

import com.example.haibazo_entrancetest.dto.ProductCreateRequestDTO;
import com.example.haibazo_entrancetest.model.*;
import com.example.haibazo_entrancetest.repository.*;
import com.example.haibazo_entrancetest.service.IProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class ProductServiceIml implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Autowired
    ICategoryRepository categoryRepository;
    @Autowired
    ImagesServiceIml imagesServiceIml;
    @Autowired
    IProductVariationsRepository variationsRepository;
    @Autowired
    IProductVariationOptionsRepository optionsRepository;
    @Autowired
    ISKUsRepository skUsRepository;
    @Autowired
    IAttributeValueRepository attributeValueRepository;
    public Page<Product> findAllProduct(Pageable pageable) {
        return null;
    }

    @Override
    public Product createProduct(ProductCreateRequestDTO productCreateRequestDTO) {
        Category category = categoryRepository.findById(productCreateRequestDTO.getCategory_id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        AttributeValue attributeValue = attributeValueRepository.findById(productCreateRequestDTO.getAttribute_value_id())
                .orElseThrow(() -> new IllegalArgumentException("attribute value not found"));
        Product product = new Product();
        product.setName(productCreateRequestDTO.getName());
        product.setDescription(productCreateRequestDTO.getDescription());
        product.setThumb(productCreateRequestDTO.getThumb());
        product.setSlug(productCreateRequestDTO.getSlug());
        product.setQuantity(productCreateRequestDTO.getQuantity());
        product.setRating(productCreateRequestDTO.getRating());
        product.setCategory(category);
        product.setPublished(false);
        product.setDraft(true);
        product.setDelete(false);
        product.setAttributeValue(attributeValue);
        Product newProduct = productRepository.save(product);

        List<Images> imagesList = productCreateRequestDTO.getImages().stream()
                .map(item -> {
                    Images image = new Images();
                    image.setSrc(item.getSrc());
                    image.setProduct(newProduct);
                    return image;
                })
                .collect(Collectors.toList());

        newProduct.setImages(new HashSet<>(imagesServiceIml.createProductImages(imagesList)));

        List<ProductVariations> variationsList = new ArrayList<>();

        for (ProductCreateRequestDTO.ProductVariationDTO item : productCreateRequestDTO.getProduct_variations()) {
            ProductVariations variation = new ProductVariations();
            variation.setName(item.getName());
            variation.setProduct(newProduct);
            ProductVariations newVariation = variationsRepository.save(variation);
            List<ProductVariationOptions> optionsList = new ArrayList<>();
            for (ProductCreateRequestDTO.ProductVariationDTO.OptionDTO value : item.getOptions()) {
                ProductVariationOptions option = new ProductVariationOptions();
                option.setName(value.getName());
                option.setProductVariations(newVariation);
                optionsList.add(optionsRepository.save(option));
            }
            newVariation.setOptions(new HashSet<>(optionsList));
            variationsList.add(newVariation);
        }
        newProduct.setProductVariations(new HashSet<>(variationsList));
        List<SKUs> skUsList = productCreateRequestDTO.getSku_list().stream()
                .map(item -> {
                    SKUs sku = new SKUs();
                    String temp = newProduct.getId()+"."+Math.random() * 899999 * 1000000;
                    sku.setSlug(item.getSlug()+"."+temp);
                    sku.setSku(temp);
                    sku.setStock(item.getStock());
                    sku.setPrice(item.getPrice());
                    sku.setProduct(newProduct);
                    sku.setSkuTierIdx(new Gson().toJson(item.getSku_tier_idx()));
                    return sku;
                })
                .collect(Collectors.toList());
        newProduct.setSku_list(new  HashSet<>(skUsRepository.saveAll(skUsList)));
        return newProduct;
    }
    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }
}

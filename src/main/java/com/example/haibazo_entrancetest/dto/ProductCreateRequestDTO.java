package com.example.haibazo_entrancetest.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProductCreateRequestDTO {
    String name;
    String thumb;
    String description;
    String slug;
    int quantity;
    float rating;
    Long category_id;
    Long product_type_id;
    List<ImageDTO> images;
    List<ProductVariationDTO> product_variations;
    List<SkuDTO> sku_list;
    @Getter
    @Setter
    public static class ImageDTO {
        private String src;
    }

    @Getter
    @Setter
    public static class ProductVariationDTO {
        private String name;
        private List<OptionDTO> options;

        @Getter
        @Setter
        public static class OptionDTO {
            private Long id;
            private String name;
        }
    }
    @Getter
    @Setter
    public static class SkuDTO {
        private String sku;
        private double price;
        private int stock;
        private String slug;
        private List<Integer> sku_tier_idx;
    }

}

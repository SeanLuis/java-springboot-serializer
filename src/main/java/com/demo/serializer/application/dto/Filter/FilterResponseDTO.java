package com.demo.serializer.application.dto.Filter;

import com.demo.serializer.application.view.Filter.AdvancedView;
import com.demo.serializer.application.view.Filter.BasicView;
import com.demo.serializer.application.view.Filter.FullView;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FilterResponseDTO {
    @JsonView(BasicView.class)
    private String category;

    @JsonView(AdvancedView.class)
    private Double minimumPrice;

    @JsonView(AdvancedView.class)
    private Double maximumPrice;

    @JsonView(FullView.class)
    private List<String> brands;

    @JsonView(FullView.class)
    private Integer minimumRating;

    @JsonView(BasicView.class)
    private Boolean availability;

    @JsonView(BasicView.class)
    private String color;

    @JsonView({AdvancedView.class, FullView.class})
    private String size;

    @JsonView(FullView.class)
    private Integer minimumQuantityInStock;

    @JsonView({AdvancedView.class, FullView.class})
    private String countryOfOrigin;

    @JsonView(BasicView.class)
    private Boolean freeShipping;

    @JsonView(FullView.class)
    private String material;

    @JsonView({AdvancedView.class, FullView.class})
    private String type;

    @JsonView(BasicView.class)
    private String launchDateFrom;

    @JsonView(BasicView.class)
    private String launchDateTo;

    public FilterResponseDTO(FilterRequestDTO request) {
      this.category = request.getCategory();
      this.minimumPrice = request.getMinimumPrice();
      this.maximumPrice = request.getMaximumPrice();
      this.brands = request.getBrands();
      this.minimumRating = request.getMinimumRating();
      this.availability = request.getAvailability();
      this.color = request.getColor();
      this.size = request.getSize();
      this.minimumQuantityInStock = request.getMinimumQuantityInStock();
      this.countryOfOrigin = request.getCountryOfOrigin();
      this.freeShipping = request.getFreeShipping();
      this.material = request.getMaterial();
      this.type = request.getType();
      this.launchDateFrom = request.getLaunchDateFrom();
      this.launchDateTo = request.getLaunchDateTo();
  }
}


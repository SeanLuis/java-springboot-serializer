package com.demo.serializer.application.dto.Filter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.demo.serializer.application.validation.Filter.AdvancedInfo;
import com.demo.serializer.application.validation.Filter.BasicInfo;
import com.demo.serializer.application.validation.Filter.FullInfo;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class FilterRequestDTO {
    @NotNull(groups = {BasicInfo.class, FullInfo.class})
    private String category;

    @Min(value = 0, groups = {AdvancedInfo.class, FullInfo.class})
    private Double minimumPrice;

    @Min(value = 0, groups = {AdvancedInfo.class, FullInfo.class})
    private Double maximumPrice;

    private List<String> brands;

    @NotNull(groups = {FullInfo.class})
    private Integer minimumRating;

    private Boolean availability;
    private String color;

    @NotNull(groups = {BasicInfo.class, FullInfo.class})
    private String size;

    private Integer minimumQuantityInStock;
    private String countryOfOrigin;

    @NotNull(groups = {FullInfo.class})
    private Boolean freeShipping;

    private String material;
    private String type;

    @NotNull(groups = {BasicInfo.class, AdvancedInfo.class})
    private String launchDateFrom;

    @NotNull(groups = {BasicInfo.class, AdvancedInfo.class})
    private String launchDateTo;
}


package com.demo.serializer.Filter;

import com.demo.serializer.application.dto.Filter.FilterRequestDTO;
import com.demo.serializer.application.dto.Filter.FilterResponseDTO;
import com.demo.serializer.presentation.controller.Filter.FilterController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(FilterController.class)
public class FilterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private FilterRequestDTO createTestFilter() {
      FilterRequestDTO filterRequest = new FilterRequestDTO();
      filterRequest.setCategory("Electronics");
      filterRequest.setMinimumPrice(100.0);
      filterRequest.setMaximumPrice(500.0);
      filterRequest.setBrands(Arrays.asList("BrandA", "BrandB"));
      filterRequest.setMinimumRating(4);
      filterRequest.setAvailability(true);
      filterRequest.setColor("Black");
      filterRequest.setSize("Medium");
      filterRequest.setMinimumQuantityInStock(10);
      filterRequest.setCountryOfOrigin("USA");
      filterRequest.setFreeShipping(true);
      filterRequest.setMaterial("Plastic");
      filterRequest.setType("Gadget");
      filterRequest.setLaunchDateFrom("2021-01-01");
      filterRequest.setLaunchDateTo("2021-12-31");
      return filterRequest;
  }

    @Test
    public void whenPostRequestToBasic_thenCorrectResponse() throws Exception {
        FilterRequestDTO filterRequest = createTestFilter();
        MvcResult mvcResult = mockMvc.perform(post("/api/filters/basic")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filterRequest)))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        FilterResponseDTO response = objectMapper.readValue(responseBody, FilterResponseDTO.class);

        assertThat(response.getCategory()).isEqualTo(filterRequest.getCategory());
        assertThat(response.getAvailability()).isEqualTo(filterRequest.getAvailability());
        assertThat(response.getColor()).isEqualTo(filterRequest.getColor());
        assertThat(response.getFreeShipping()).isEqualTo(filterRequest.getFreeShipping());
        assertThat(response.getLaunchDateFrom()).isEqualTo(filterRequest.getLaunchDateFrom());
        assertThat(response.getLaunchDateTo()).isEqualTo(filterRequest.getLaunchDateTo());

        assertThat(response.getMinimumPrice()).isNull();
        assertThat(response.getMaximumPrice()).isNull();
        assertThat(response.getBrands()).isNull();
    }


    @Test
    public void whenPostRequestToAdvanced_thenCorrectResponse() throws Exception {
        FilterRequestDTO filterRequest = createTestFilter();
        MvcResult mvcResult = mockMvc.perform(post("/api/filters/advanced")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filterRequest)))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        FilterRequestDTO response = objectMapper.readValue(responseBody, FilterRequestDTO.class);

        assertThat(response).hasFieldOrPropertyWithValue("category", filterRequest.getCategory());
        assertThat(response).hasFieldOrPropertyWithValue("minimumPrice", filterRequest.getMinimumPrice());
        assertThat(response).hasFieldOrPropertyWithValue("maximumPrice", filterRequest.getMaximumPrice());
        assertThat(response).hasFieldOrPropertyWithValue("size", filterRequest.getSize());
        assertThat(response).hasFieldOrPropertyWithValue("countryOfOrigin", filterRequest.getCountryOfOrigin());
        assertThat(response).hasFieldOrPropertyWithValue("type", filterRequest.getType());
    }

    @Test
    public void whenPostRequestToFull_thenCorrectResponse() throws Exception {
        FilterRequestDTO filterRequest = createTestFilter();
        MvcResult mvcResult = mockMvc.perform(post("/api/filters/full")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(filterRequest)))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        FilterRequestDTO response = objectMapper.readValue(responseBody, FilterRequestDTO.class);

        assertThat(response).hasFieldOrPropertyWithValue("category", filterRequest.getCategory());
        assertThat(response).hasFieldOrPropertyWithValue("minimumPrice", filterRequest.getMinimumPrice());
        assertThat(response).hasFieldOrPropertyWithValue("maximumPrice", filterRequest.getMaximumPrice());
        assertThat(response).hasFieldOrPropertyWithValue("brands", filterRequest.getBrands());
        assertThat(response).hasFieldOrPropertyWithValue("minimumRating", filterRequest.getMinimumRating());
        assertThat(response).hasFieldOrPropertyWithValue("minimumQuantityInStock", filterRequest.getMinimumQuantityInStock());
        assertThat(response).hasFieldOrPropertyWithValue("material", filterRequest.getMaterial());
    }
}

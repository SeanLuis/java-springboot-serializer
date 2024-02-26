package com.demo.serializer.presentation.controller.Filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.serializer.application.dto.Filter.FilterRequestDTO;
import com.demo.serializer.application.dto.Filter.FilterResponseDTO;
import com.demo.serializer.application.validation.Filter.AdvancedInfo;
import com.demo.serializer.application.validation.Filter.BasicInfo;
import com.demo.serializer.application.validation.Filter.FullInfo;
import com.demo.serializer.application.view.Filter.AdvancedView;
import com.demo.serializer.application.view.Filter.BasicView;
import com.demo.serializer.application.view.Filter.FullView;
import com.fasterxml.jackson.annotation.JsonView;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/filters")
public class FilterController {

    @PostMapping("/basic")
    @JsonView(BasicView.class)
    public ResponseEntity<FilterResponseDTO> applyBasicFilter(@Validated(BasicInfo.class) @RequestBody FilterRequestDTO filter) {
        FilterResponseDTO response = new FilterResponseDTO(filter);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/advanced")
    @JsonView(AdvancedView.class)
    public ResponseEntity<FilterResponseDTO> applyAdvancedFilter(@Validated(AdvancedInfo.class) @RequestBody FilterRequestDTO filter) {
        FilterResponseDTO response = new FilterResponseDTO(filter);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/full")
    @JsonView(FullView.class)
    public ResponseEntity<FilterResponseDTO> applyFullFilter(@Validated(FullInfo.class) @RequestBody FilterRequestDTO filter) {
        FilterResponseDTO response = new FilterResponseDTO(filter);
        return ResponseEntity.ok(response);
    }
}

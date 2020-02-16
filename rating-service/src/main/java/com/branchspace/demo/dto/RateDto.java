package com.branchspace.demo.dto;

import com.branchspace.demo.model.Rating;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RateDto {
    Integer rate;

    public static RateDto from(Rating rating) {
        return RateDto.builder()
                .rate(rating.getRate())
                .build();
    }
}

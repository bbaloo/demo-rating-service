package com.branchspace.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Value
@Builder
@AllArgsConstructor
public class VoteDto {
    @NotBlank
    String movieId;
    @Min(1)
    @Max(10)
    Integer rate;
}

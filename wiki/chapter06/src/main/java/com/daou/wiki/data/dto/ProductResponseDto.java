package com.daou.wiki.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductResponseDto {
    private Long number;

    private String name;

    private int price;

    public int stock;
}

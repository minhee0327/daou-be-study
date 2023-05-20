package com.daou.wiki.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChangeProductNameDto {

    private Long number;

    private String name;
}

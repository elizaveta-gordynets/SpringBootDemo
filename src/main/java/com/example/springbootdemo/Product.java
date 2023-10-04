package com.example.springbootdemo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class Product {
    private long id;
    @NonNull
    private String name;
    private long quantity;
    private String description;
}

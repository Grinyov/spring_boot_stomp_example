package com.grinyov.stomp_example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vgrinyov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Greeting {
    private String content;
}
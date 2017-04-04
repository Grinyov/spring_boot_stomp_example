package com.grinyov.stomp_example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by grinyov
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelloMessage {
    private String name;
}
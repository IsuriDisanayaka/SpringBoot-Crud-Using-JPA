package com.wixis.springbootcrud.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Isuri Disanayaka
 * @date:30/08/2021
 * @since : 0.0.1
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private String code;
    private String message;
    private Object data;
}

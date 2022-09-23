package org.binar.SpringJPA.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData<T> {
    private String status;
    private String messagge;
    private T data;
}

package com.client.client.dto;

import com.sun.org.apache.xpath.internal.objects.XString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {
    private long id;
    private String name;
    private String CPF;
    private String email;
    private String phone;
    private String address;
    private String district;
    private String city;
    private String state;
}

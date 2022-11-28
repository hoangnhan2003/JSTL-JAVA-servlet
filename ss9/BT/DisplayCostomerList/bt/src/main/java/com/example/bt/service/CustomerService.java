package com.example.bt.service;

import com.example.bt.model.Customer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public static List<Customer> customerList;
    static{
        customerList = new ArrayList<>();
        customerList.add(new Customer("Ngô","2003-05-23","Quảng Bình","adfsdfsa"));
        customerList.add(new Customer("Hoàng","2003-05-23","Quảng Bình","adfsdfsa"));
        customerList.add(new Customer("Nhận","2003-05-23","Quảng Bình","adfsdfsa"));
        customerList.add(new Customer("Nhàn","2003-05-23","Quảng Bình","adfsdfsa"));
        customerList.add(new Customer("Thanh","2003-05-23","Quảng Bình","adfsdfsa"));

    }
}

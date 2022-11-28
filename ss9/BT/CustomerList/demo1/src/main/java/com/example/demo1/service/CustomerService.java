package com.example.demo1.service;

import com.example.demo1.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public static List<Customer> customerList;
    static{
        customerList = new ArrayList<>();
        customerList.add(new Customer("Ngô","2003-05-23","Quảng Bình","https://img.freepik.com/premium-photo/astronaut-outer-open-space-planet-earth-stars-provide-background-erforming-space-planet-earth-sunrise-sunset-our-home-iss-elements-this-image-furnished-by-nasa_150455-16829.jpg?w=2000"));
        customerList.add(new Customer("Hoàng","2003-05-23","Quảng Bình","https://imageskin.vn/wp-content/uploads/2021/11/ava-image-vital-c.jpg?is-pending-load=1"));
        customerList.add(new Customer("Nhận","2003-05-23","Quảng Bình","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJ_g0OG6hKM5hkprFaa0fwxG9UpA7rY8NNHQ&usqp=CAU"));
        customerList.add(new Customer("Nhàn","2003-05-23","Quảng Bình","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSus3RdXOgcfIS7iTbhoda4O1cDVcUZGS5AvSKtDK5DdCslvn4EVws95RHdon1tOxiYXyU&usqp=CAU"));
        customerList.add(new Customer("Thanh","2003-05-23","Quảng Bình","https://thumbs.dreamstime.com/z/modern-angel-boy-wings-walking-clouds-youth-power-young-casual-clothes-sky-pushed-up-take-shape-71003958.jpg"));

    }

}

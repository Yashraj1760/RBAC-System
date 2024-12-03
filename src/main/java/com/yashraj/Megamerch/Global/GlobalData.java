package com.yashraj.Megamerch.Global;

import com.yashraj.Megamerch.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Product> cart;
    static {
        cart=new ArrayList<Product>();
    }
}

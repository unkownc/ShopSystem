package com.bigjava.shopping.view;

import com.bigjava.shopping.entity.Product;
import com.bigjava.shopping.facotry.ObjectFactory;
import com.bigjava.shopping.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class Start {

    Scanner input = new Scanner(System.in);
    private ProductService productService = (ProductService) ObjectFactory.getObject("productServiceProxy");

    /**
     * 显示系统菜单
     */
    public void showSystemMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("1.登陆\t\t2.注册\t\t3.查看商品列表");
        System.out.println("--------------------------------------------------");
        System.out.println("请选择:");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                login();
                break;
            case 2:
                regist();
                break;
            case 3:
                showProductList();
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }

    /**
     * 显示商品列表
     */
    private void showProductList() {
        System.out.println("--------------------------------------------------");
        List<Product> products = productService.findAll();
        System.out.println("编号\t商品\t价格");
        for (Product product : products) {
            System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice());
        }
    }

    private void regist() {
    }

    private void login() {
    }

    public static void main(String[] args) {
        System.out.println("=========================欢迎使用购物系统========================");
        new Start().showSystemMenu();
    }

}

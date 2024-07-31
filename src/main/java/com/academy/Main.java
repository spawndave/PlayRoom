package com.academy;

import com.academy.model.dao.ProductDao;
import com.academy.model.dao.RoomDao;
import com.academy.model.dao.SizeDao;
import com.academy.model.dao.impl.*;
import com.academy.model.entity.*;

public class Main {
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        RoomDao roomDao = new RoomDaoImpl();
        ToyDaoImpl toyDao = new ToyDaoImpl();
        SizeDao sizeDao = new SizeDaoImpl();
        /*Toy toy = toyDao.findById(1, Toy.class);
        Room room = roomDao.findById(1, Room.class);
        System.out.println(room);

        Size size = sizeDao.findById(1, Size.class);
        System.out.println(size);*/

        //User user= userDao.findById(1L, User.class);


        //Toy toy2 = toyDao.findById(1L, Toy.class);
        //toy2.setId(1);
        //toy2.setDescription("Carsdfsd");
        //toy2.setPrice(34);
        //toy2.setAgeGroupId(2);
        //toy2.setSize(size2);
        //toyDao.createOrUpdate(toy2);

        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product();
        ProductId productId = new ProductId();
        productId.setBrand("new brand");
        productId.setName("test");
        product.setId(productId);
        product.setPrice(333);
        System.out.println(product);
        productDao.createOrUpdate(product);
        //userDao.createOrUpdate(user1);

        //System.out.println(userDao.getById(2));
        //System.out.println(userDao.loadById(3));
    }
}

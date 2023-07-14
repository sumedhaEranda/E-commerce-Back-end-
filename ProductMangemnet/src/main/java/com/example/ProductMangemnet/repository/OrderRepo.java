package com.example.ProductMangemnet.repository;

import com.example.ProductMangemnet.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {

    @Query("SELECT invoice.id,invoice.createOrderDate, c.name, c.contactNo, c.email, invoice.totalAmount " +
            "FROM Order invoice " +
            "INNER JOIN invoice.customer c")
    List<Object[]> getCustomersWithAddresses();


//    @Query("SELECT p.category, c.quantity, p.title " +
//            "FROM Product p " +
//            "INNER JOIN Cart c ON p.pid = c.pid")
//    List<Object[]> getSalesOrderforCategory();

        @Query("SELECT MONTHNAME(po.createOrderDate) AS month, p.category, SUM(c.quantity) AS totalSales " +
                "FROM Product p " +
                "INNER JOIN Cart c ON p.pid = c.pid " +
                "INNER JOIN Order po ON c.order_id = po.id " +
                "GROUP BY p.category, MONTH(po.createOrderDate)")
    List<Object[]> getSalesOrderforCategory();


//    @Query("SELECT p.category, SUM(c.quantity) AS total_quantity, FUNCTION('DATE_FORMAT', po.createOrderDate, '%M') AS order_month " +
//            "FROM Product p " +
//            "INNER JOIN Cart c ON p.pid = c.product.pid " +
//            "INNER JOIN PlaceOrder po ON c.order.id = po.id " +
//            "GROUP BY p.category, order_month " +
//            "ORDER BY p.category")
//    List<Object[]> getHHNMHMJHMJHNM();


    @Query("SELECT p.pid, p.category,p.title, p.imgpath, p.price, c.quantity,o.totalAmount " +
            "FROM Cart c " +
            "INNER JOIN Order o ON c.order_id = o.id " +
            "INNER JOIN Product p ON c.pid = p.pid " +
            "WHERE c.order_id = :id")
    List<Object[]> getOrderId(@Param("id") Integer orderId);


//    @Query("DELETE FROM Order po " +"Cart c"+"customer cu"+
//            "JOIN Cart c ON po.id = c.order_id " +
//            "JOIN customer cu ON po.customer_id = cu.id " +
//            "WHERE po.id = :id")
//    Integer deleteOrderId(@Param("oid") Integer orderId);


}



select * from OrderList as ol 
inner join OrderDetail as od in ol.Order_id = od.Order_id


select * from Product 
inner join OrderDetail on OrderDetail.Product_code = Product.Product_code
where OrderDetail.Order_id = orderId
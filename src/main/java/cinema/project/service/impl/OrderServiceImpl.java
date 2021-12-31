package cinema.project.service.impl;

import cinema.project.dao.OrderDao;
import cinema.project.lib.Inject;
import cinema.project.lib.Service;
import cinema.project.model.Order;
import cinema.project.model.ShoppingCart;
import cinema.project.model.Ticket;
import cinema.project.model.User;
import cinema.project.service.OrderService;
import cinema.project.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        List<Ticket> tickets = shoppingCart.getTickets();
        User user = shoppingCart.getUser();
        Order order = new Order();
        order.setUser(user);
        order.setTickets(tickets);
        order.setOrderDate(LocalDateTime.now());
        shoppingCartService.clearShoppingCart(shoppingCart);
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.getByUser(user);
    }
}

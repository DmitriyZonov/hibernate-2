package dao;

import entity.store.Customer;
import entity.store.Payment;
import entity.store.Rental;
import entity.store.Staff;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDAO extends GenericDAO<Payment> {
    public PaymentDAO(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }

    public void createPayment(Customer customer, Staff staff, Rental rental, BigDecimal amount) {
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setStaff(staff);
        payment.setRental(rental);
        payment.setAmount(amount);
        payment.setPaymentDate(LocalDateTime.now());

        save(payment);
    }
}

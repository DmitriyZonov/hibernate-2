package dao;

import entity.address.Address;
import entity.address.City;
import org.hibernate.SessionFactory;

public class AddressDAO extends GenericDAO<Address>{
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }

    public Address createAddress(String address,String address2, String district, City city, String postal_code, String phone) {
        Address address1 = new Address();
        address1.setAddress(address);
        address1.setAddress2(address2);
        address1.setDistrict(district);
        address1.setCity(city);
        address1.setPostalCode(postal_code);
        address1.setPhone(phone);

        return address1;
    }
}

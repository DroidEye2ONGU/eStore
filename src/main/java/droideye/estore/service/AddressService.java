package droideye.estore.service;

import java.util.List;

import droideye.estore.pojo.Address;

public interface AddressService {

    public List<Address> queryAllAddressOwnedByOneUser(String userId);

    public boolean deleteSingleAddressByAddressId(String addressId);

    public boolean addSingleAddress(Address address);

    Address querySingleAddressByAddressId(Integer addressId);
}

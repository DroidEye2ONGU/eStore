package droideye.estore.mapper;

import java.util.List;

import droideye.estore.pojo.Address;

public interface AddressMapper {

    //根据用户编号查找这个用户的所有地址信息
    List<Address> queryAllAddressOwnedByOneUser(Integer userId);

    //根据地址编号来删除数据库中对应的数据
    boolean deleteSingleAddressByAddressId(Integer id);

    //添加一个Address
    boolean addSingleAddress(Address address);

    //通过AddressID来查找特定的地址信息
    Address querySingleAddressByAddressId(Integer addressId);
}

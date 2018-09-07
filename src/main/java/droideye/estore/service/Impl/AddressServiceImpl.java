package droideye.estore.service.Impl;

import com.sun.xml.internal.bind.v2.model.core.ID;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.AddressMapper;
import droideye.estore.pojo.Address;
import droideye.estore.service.AddressService;

public class AddressServiceImpl implements AddressService {
    @Override
    public List<Address> queryAllAddressOwnedByOneUser(String userId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        List<Address> addresses = addressMapper.queryAllAddressOwnedByOneUser(Integer.parseInt(userId));

        sqlSession.close();
        return addresses;
    }

    @Override
    public boolean deleteSingleAddressByAddressId(String addressId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        boolean result = addressMapper.deleteSingleAddressByAddressId(Integer.parseInt(addressId));

        sqlSession.close();

        return result;
    }

    @Override
    public boolean addSingleAddress(Address address) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        boolean result = addressMapper.addSingleAddress(address);

        sqlSession.close();

        return result;
    }

    @Override
    public Address querySingleAddressByAddressId(Integer addressId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        Address address = addressMapper.querySingleAddressByAddressId(addressId);

        sqlSession.close();

        return address;
    }
}

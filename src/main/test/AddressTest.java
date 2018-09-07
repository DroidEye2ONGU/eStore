import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.AddressMapper;
import droideye.estore.pojo.Address;

public class AddressTest {

    @Test
    public void queryAllAddressOwnedByOneUserTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        List<Address> addresses = addressMapper.queryAllAddressOwnedByOneUser(5);

        System.out.println(addresses.size());
        for (Address a :
                addresses) {
            System.out.println(a);
        }
    }

    @Test
    public void deleteSingleAddressByAddressIdTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        boolean b = addressMapper.deleteSingleAddressByAddressId(3);

        System.out.println(b);
    }

    @Test
    public void addSingleAddressTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        Address address = new Address();
        address.setUserId(2);
        address.setName("老王");
        address.setPhone("10293829123");
        address.setInfo("ShanXi TaiYuan");

        boolean result = addressMapper.addSingleAddress(address);

        System.out.println(result);
    }

    @Test
    public void querySingleAddressByAddressIdTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        AddressMapper addressMapper = sqlSession.getMapper(AddressMapper.class);

        Address address = addressMapper.querySingleAddressByAddressId(10);

        System.out.println(address);
    }
}

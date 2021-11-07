import com.week7.jdbc.work3.annotation.DynamicRoutingDataSource;
import com.week7.jdbc.work3.datasource.MultiDataSource;
import com.week7.jdbc.work3.entity.OrderEntity;
import com.week7.jdbc.work3.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mvc.xml",
        "classpath:spring-mybatis.xml"})
public class TestWork2 {
    @Autowired
    private OrderService orderService;

    /**
     * 工具类切换数据源
     */
    @Test
    public void getOrder(){
        //使用默认数据源
        MultiDataSource.toDefault();
        OrderEntity orderEntity=orderService.queryById(2999979);
        System.out.println("手动切换数据源"+orderEntity);
        //切换数据源
        MultiDataSource.setDataSourceKey("dataSource2");
        OrderEntity orderEntity1=new OrderEntity();
        orderEntity1.setId(2999979);
        orderEntity1.setOrder_sts("OR01");
        orderService.undifyOrder(orderEntity1);
    }

    /**
     * 注解切换数据源
     */
    @Test
    @DynamicRoutingDataSource("dataSource2")
    public void getOrder1(){
        OrderEntity orderEntity=orderService.queryById(2999979);
        System.out.println("注解切换数据源"+orderEntity);
    }


}

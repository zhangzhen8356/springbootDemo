package com.zzhen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * <p>功能描述：</p>
 * <p>类名称：PACKAGE_NAME.SpringbootException</p>
 * <p>创建时间：2019/11/21 10:00</p>
 * @author zzhen
 */

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class}) //去掉springboot自动配置数据库
public class SpringbootException {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootException.class,args);
    }
}

package com.zzhen.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>功能描述：MyBatis配置类</p>
 * <p>类名称：com.zzhen.config.mybatisConfig</p>
 * <p>创建时间：2019/11/28 16:55</p>
 * @author zzhen
 */
@Configuration
@MapperScan("com.zzhen.dao")
public class mybatisConfig {
}

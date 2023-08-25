package com.musanli.practice.spring.register;

import com.musanli.practice.spring.register.impl.UserEventImpl;
import com.musanli.practice.spring.register.inter.UserEventInterface;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

@Slf4j
@Configuration
@Import(AutoConfiguredMapperScannerRegistrar.class) // 会执行 指定类的 ImportBeanDefinitionRegistrar.registerBeanDefinitions方法
public class AutoConfiguredMapperScannerRegistrar implements BeanFactoryAware, ImportBeanDefinitionRegistrar {

    private BeanFactory beanFactory;
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        MybatisAutoConfiguration mybatisAutoConfiguration = null;

//        if (!AutoConfigurationPackages.has(this.beanFactory)) {
//            log.debug("Could not determine auto-configuration package, automatic mapper scanning disabled.");
//            return;
//        }
//
//        log.debug("Searching for mappers annotated with @Mapper");
//
//        List<String> packages = AutoConfigurationPackages.get(this.beanFactory);
//        if (log.isDebugEnabled()) {
//            packages.forEach(pkg -> log.debug("Using auto-configuration base package '{}'", pkg));
//        }
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserEventImpl.class);
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        registry.registerBeanDefinition("abcd", beanDefinition);
        builder.addPropertyValue("name","cc");
//      BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MapperScannerConfigurer.class);
//      builder.addPropertyValue("processPropertyPlaceHolders", true);
//      builder.addPropertyValue("annotationClass", Mapper.class);
//      builder.addPropertyValue("basePackage", StringUtils.collectionToCommaDelimitedString(packages));
//      BeanWrapper beanWrapper = new BeanWrapperImpl(MapperScannerConfigurer.class);
//      Stream.of(beanWrapper.getPropertyDescriptors())
//          // Need to mybatis-spring 2.0.2+
//          .filter(x -> x.getName().equals("lazyInitialization")).findAny()
//          .ifPresent(x -> builder.addPropertyValue("lazyInitialization", "${mybatis.lazy-initialization:false}"));
//      registry.registerBeanDefinition(MapperScannerConfigurer.class.getName(), builder.getBeanDefinition());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

}
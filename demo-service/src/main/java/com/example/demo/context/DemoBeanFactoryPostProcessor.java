package com.example.demo.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: gaozl
 * Date: 2017/11/9
 * Time: 上午11:05
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DemoBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Iterator<String> beanNamesIterator = configurableListableBeanFactory.getBeanNamesIterator();
        while (beanNamesIterator.hasNext())
        {
            System.out.println(beanNamesIterator.next());
        }
    }
}
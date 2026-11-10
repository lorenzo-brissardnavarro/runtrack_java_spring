package com.example.demo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;

import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.engine.builder.ViewFactoryCreator;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.webflow.view.AjaxThymeleafViewResolver;
import org.thymeleaf.spring6.webflow.view.FlowAjaxThymeleafView;

@Configuration
public class WebFlowConfig extends AbstractFlowConfiguration {

    // Résolveur des vues Thymeleaf pour Spring Web Flow
    @Bean
    public ViewResolver webFlowThymeleafViewResolver(
            SpringTemplateEngine templateEngine) {

        AjaxThymeleafViewResolver resolver =
                new AjaxThymeleafViewResolver();

        resolver.setViewClass(FlowAjaxThymeleafView.class);
        resolver.setTemplateEngine(templateEngine);

        return resolver;
    }

    // Créateur de vues MVC
    @Bean
    public ViewFactoryCreator viewFactoryCreator(
            ViewResolver webFlowThymeleafViewResolver) {

        MvcViewFactoryCreator creator = new MvcViewFactoryCreator();

        creator.setViewResolvers(
                Collections.singletonList(webFlowThymeleafViewResolver));

        creator.setUseSpringBeanBinding(true);

        return creator;
    }

    // Services de construction des flows
    @Bean
    public FlowBuilderServices flowBuilderServices(
            ViewFactoryCreator viewFactoryCreator) {

        return getFlowBuilderServicesBuilder()
                .setViewFactoryCreator(viewFactoryCreator)
                .build();
    }

    // Registre des flows
    @Bean
    public FlowDefinitionRegistry flowRegistry(
            FlowBuilderServices flowBuilderServices) {

        return getFlowDefinitionRegistryBuilder()
                .addFlowLocation(
                    "classpath:/flows/purchase/purchase-flow.xml",
                    "purchase")
                .setFlowBuilderServices(flowBuilderServices)
                .build();
    }

    // Exécuteur des flows
    @Bean
    public FlowExecutor flowExecutor(
            FlowDefinitionRegistry flowRegistry) {

        return getFlowExecutorBuilder(flowRegistry).build();
    }

    // Mapping des requêtes
    @Bean
    public FlowHandlerMapping flowHandlerMapping(
            FlowDefinitionRegistry flowRegistry) {

        FlowHandlerMapping mapping = new FlowHandlerMapping();

        mapping.setFlowRegistry(flowRegistry);
        mapping.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return mapping;
    }

    // Adaptateur des requêtes
    @Bean
    public FlowHandlerAdapter flowHandlerAdapter(
            FlowExecutor flowExecutor) {

        FlowHandlerAdapter adapter = new FlowHandlerAdapter();

        adapter.setFlowExecutor(flowExecutor);

        return adapter;
    }
}

package com.example.demo.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

public class YamlAwarePropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        if (resource.getResource().getFilename().endsWith(".yml") ||
            resource.getResource().getFilename().endsWith(".yaml"))
        {
            try {
                YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
                yamlPropertiesFactoryBean.setResources(resource.getResource());
                return new PropertiesPropertySource(name == null ? getNameForResource(resource.getResource()) : name,
                    yamlPropertiesFactoryBean.getObject());
            } catch (IllegalStateException ex) {
                if (ex.getCause() != null && ex.getCause() instanceof FileNotFoundException) {
                    throw (FileNotFoundException)(ex.getCause());
                } else {
                    throw new IllegalArgumentException(ex);
                }
            } catch (Throwable ex2) {
                throw new IllegalArgumentException(ex2);
            }
        }

        return super.createPropertySource(name, resource);
    }

    private static String getNameForResource(Resource resource) {
        String name = resource.getDescription();
        if (!StringUtils.hasText(name)) {
            name = resource.getClass().getSimpleName() + "@" + System.identityHashCode(resource);
        }
        return name;
    }
}

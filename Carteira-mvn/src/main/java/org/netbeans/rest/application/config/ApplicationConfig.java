package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;

import nocash.Cliente.ClienteResource;
import nocash.Parceiro.ParceiroResource;
import nocash.usuarios.UsuarioResource;

@javax.ws.rs.ApplicationPath("wb")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(nocash.Cliente.ClienteResource.class);
        resources.add(nocash.Parceiro.ParceiroResource.class);
        resources.add(nocash.usuarios.UsuarioResource.class);
    }
    
}

package com.nujabness.katawemanity.api.configuration;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import java.io.IOException;
import java.util.Arrays;

/**
 * Cette classe permet de customizer le traitement sur les fichiers properties en fonction du profile,
 * <p>
 * tout nouveau fichier qui se rajoute dans ce projet, doit être spécifier dans la variable EXTRA_CONFIG_PROPERTY_FILES,
 * <p>
 * pour que le fichier de profile qui va avec soit pris en compte dynamiquement.
 *
 * @author abeskri
 */
public class CustomApplicationContextInitializer
        implements org.springframework.context.ApplicationContextInitializer<ConfigurableWebApplicationContext> {


    private static final String EXTRA_CONFIG_PROPERTY_FILES = "classpath:services.properties,classpath:data.properties";
    private static final String FILE_EXTENSION_SEPARATOR = ".";
    private static final String EXTRA_CONFIG_PROPERTY_FILES_SEPARATOR = ",";
    private static final String PROPERTY_FILE_SUFFIX = ".properties";

    @Override
    public void initialize(ConfigurableWebApplicationContext applicationContext) {
        //
        String[] sourceProperties = EXTRA_CONFIG_PROPERTY_FILES.split(EXTRA_CONFIG_PROPERTY_FILES_SEPARATOR);

        // traitement du fichier de base
        final ConfigurableEnvironment env = applicationContext.getEnvironment();

        // Ajout des profiles
        Arrays.stream(sourceProperties).forEach(location -> {
            // Récupération de la liste des profiles
            String[] activeProfiles = env.getActiveProfiles();
            Arrays.stream(activeProfiles).forEach(activeProfileName -> {
                    // traitement du fichier correspondant au profile trouvé
                    String newLocation = location.substring(0, location.indexOf(FILE_EXTENSION_SEPARATOR)) + "-"
                            + activeProfileName + PROPERTY_FILE_SUFFIX;
                    addResourcePropertySource(applicationContext, newLocation, env);
            });
        });

        // Ajout des fichiers hors profiles
        Arrays.stream(sourceProperties).forEach(location -> {
            // Ajouter le fichier properties
            if (location.endsWith(PROPERTY_FILE_SUFFIX)) {
                addResourcePropertySource(applicationContext, location, env);
            }
        });

    }

    private MutablePropertySources addResourcePropertySource(ConfigurableWebApplicationContext applicationContext,
                                                             String fileName, final ConfigurableEnvironment env) {
        final MutablePropertySources mps = env.getPropertySources();
        Resource resource = applicationContext.getResource(env.resolvePlaceholders(fileName));
        if (resource.isReadable()) {
            try {
                // Ajout en fin de chaine, pour que les System properties (-Dxxx=yyy) et les properties d'environnement
                // (.bashrc, export, etc.) restent prioriaires
                mps.addLast(new ResourcePropertySource(resource.getDescription(), resource));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return mps;
    }
}

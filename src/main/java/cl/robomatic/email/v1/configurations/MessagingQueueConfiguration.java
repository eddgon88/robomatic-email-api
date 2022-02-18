package cl.robomatic.email.v1.configurations;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Configuration
public class MessagingQueueConfiguration {

    /**
     * Metodo que permite crear la fabrica de contenedores de oyentes. Esto no es necesario si se esta conforme  con la
     * fabrica creada por defecto por Spring Boot, pero como se esta usando la propiedad {@code containerFactory} de la
     * anotacion {@code @JmsListener} en los metodos oyentes, se crea este Bean.
     *
     * @param connectionFactory La fabrica de conexiones.
     * @param configurer        El configurador de la fabrica de conexiones.
     * @return La fabrica de contenedores de oyentes.
     */
    @Bean
    public JmsListenerContainerFactory defaultJmsFactory(ConnectionFactory connectionFactory,
                                                         DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        return factory;
    }

}

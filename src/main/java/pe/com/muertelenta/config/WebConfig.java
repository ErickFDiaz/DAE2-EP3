
package pe.com.muertelenta.config;

//convierte a la clase WebConfig en una clase de configuracion

import jdk.jfr.Description;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

//convierte a la clase WebConfig en una clase de configuracion
//de spring, eso significa que Spring utilizara la clase para
//diferentes aspectos del proyecto
@Configuration
//WebMvcConfigurer permite agregar o modificar funcionalidades del 
//framework Spring MVC.
public class WebConfig implements WebMvcConfigurer {

    //marca el metodo como un bean de Spring, Spring manejara y
    //podra inyectarse en otras partes del codigo
    @Bean
    @Description("Ejemplo de HTML")
    //ClassLoaderTemplateResolver es una clase proporcionada por
    //Thymeleaf que se utiliza para resolver plantillas que se 
    //encuentran en el classpath de la aplicacion, como archivos
    //HTML u otros recursos de plantillas
    public ClassLoaderTemplateResolver templateResolver() {
        var templateResolver = new ClassLoaderTemplateResolver();
        //carpeta donde se encuentra las paginas web(plantilla) de Thymeleaf
        templateResolver.setPrefix("templates/");
        //Thymeleaf no debe de cachear las plantillas HTML, cada
        //vez que se solicite una pagina la va a procesar desde 0
        templateResolver.setCacheable(false);
        //tipo de paginas que se van a cargar
        templateResolver.setSuffix(".html");
        //modo de plantilla de las paginas sera HTML 5
        templateResolver.setTemplateMode("HTML5");
        //permitir caracteres especiales
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    @Description("Motor de integracion")
    public SpringTemplateEngine templateEngine() {
        //SpringTemplateEngine es el motor principal del Thymeleaf
        //que procesa las plantillas y genera la vista
        var templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        return templateEngine;
    }

    @Bean
    @Description("Resolucion de vistas en Thymeleaf")
    //ViewResolver es un cpomonente de Spring MVC se encarga de resolver
    //las vistas(views) que la aplicacion debe de renderizar. Su principal
    //funcion es determinar que vista( por ejemplo una pagina HTML o un JSP)
    //debe de mostrarse en funcion del nombre que se devuelve en el Controller
        public ViewResolver viewResolver() {
        //ThymeleafViewResolver permite que Spring utilice
        //Thymeleaf como motor de vistas
        var viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //habilitamos el acceso a la carpeta static donde estas los recursos
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

}

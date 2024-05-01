//package br.com.projeto.ecommerce.integrationtests.testcontainers;
//
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.env.ConfigurableEnvironment;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.test.context.ContextConfiguration;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.lifecycle.Startables;
//
//import java.util.Map;
//import java.util.stream.Stream;
//
//@ContextConfiguration(inheritInitializers = AbstractIntegrationTest.Initializer.class)
//public class AbstractIntegrationTest {
//
//    public class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>();
//
//        @SuppressWarnings({"unchecked", "rawtypes"})
//        @Override
//        public void initialize(ConfigurableApplicationContext applicationContext) {
//            startContainers();
//            ConfigurableEnvironment environment = applicationContext.getEnvironment();
//            MapPropertySource testContainers = new MapPropertySource("testContainers", (Map) createConnectionConfiguration());
//
//            environment.getPropertySources().addFirst(testContainers);
//        }
//
//        private static void startContainers() {
//            Startables.deepStart(Stream.of(postgreSQLContainer)).join();
//        }
//
//        private Map<String, String> createConnectionConfiguration() {
//            return Map.of("  spring.datasource.url", postgreSQLContainer.getJdbcUrl(),
//                    "  spring.datasource.username", postgreSQLContainer.getJdbcUrl(),
//                    "  spring.datasource.password", postgreSQLContainer.getJdbcUrl());
//        }
//    }
//}

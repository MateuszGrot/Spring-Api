package pl.mateuszgrot.workoutapp.domain;


import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;


public class MongoTestContainerInitializer implements
    ApplicationContextInitializer<ConfigurableApplicationContext> {

    final MongoDBContainer mongoDBContainer = new MongoDBContainer(
        DockerImageName.parse("mongo:4.4.17"));

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        mongoDBContainer.withReuse(true);
        mongoDBContainer.start();

        TestPropertyValues values = TestPropertyValues.of(
            "spring.data.mongodb.uri=" + mongoDBContainer.getReplicaSetUrl());

        values.applyTo(applicationContext);

    }
}

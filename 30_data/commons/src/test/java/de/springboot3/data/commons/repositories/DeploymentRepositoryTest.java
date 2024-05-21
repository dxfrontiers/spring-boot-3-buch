package de.springboot3.data.commons.repositories;

import de.springboot3.data.commons.model.Deployment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DeploymentRepositoryTest {

    @Autowired
    private DeploymentRepository cut;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void verifyFindNewestDeploymentByDescription() {
        Deployment oldDeployment = new Deployment()
                .setHostName("localhost")
                .setJobName("frontend-deploy")
                .setCreationDate(ZonedDateTime.parse("2024-04-08T10:00:00+01:00"));
        Deployment newDeployment = new Deployment()
                .setHostName("localhost")
                .setJobName("frontend-deploy")
                .setCreationDate(ZonedDateTime.parse("2024-04-09T15:00:00+01:00"));
        Deployment otherDeployment = new Deployment()
                .setHostName("127.0.0.1")
                .setJobName("frontend-stop")
                .setCreationDate(ZonedDateTime.parse("2024-04-09T15:00:00+01:00"));
        Deployment newestDeploymentOtherCase = new Deployment()
                .setHostName("LOCALHOST")
                .setJobName("frontend-deploy")
                .setCreationDate(ZonedDateTime.parse("2024-04-10T18:00:00+01:00"));

        entityManager.persistAndFlush(oldDeployment);
        entityManager.persistAndFlush(newDeployment);
        entityManager.persistAndFlush(otherDeployment);
        entityManager.persistAndFlush(newestDeploymentOtherCase);

        Assertions.assertThat(cut.findNewestDeploymentByDescription("frontend-deploy", "localhost"))
                .hasValue(newestDeploymentOtherCase);
    }

    @Test
    public void verifyFindNewestDeploymentByDescriptionQuery() {
        Deployment oldDeployment = new Deployment()
                .setHostName("localhost")
                .setJobName("frontend-deploy")
                .setCreationDate(ZonedDateTime.parse("2024-04-08T10:00:00+01:00"));
        Deployment newDeployment = new Deployment()
                .setHostName("localhost")
                .setJobName("frontend-deploy")
                .setCreationDate(ZonedDateTime.parse("2024-04-09T15:00:00+01:00"));
        Deployment otherDeployment = new Deployment()
                .setHostName("127.0.0.1")
                .setJobName("frontend-stop")
                .setCreationDate(ZonedDateTime.parse("2024-04-09T15:00:00+01:00"));
        Deployment newestDeploymentOtherCase = new Deployment()
                .setHostName("LOCALHOST")
                .setJobName("frontend-deploy")
                .setCreationDate(ZonedDateTime.parse("2024-04-10T18:00:00+01:00"));

        entityManager.persistAndFlush(oldDeployment);
        entityManager.persistAndFlush(newDeployment);
        entityManager.persistAndFlush(otherDeployment);
        entityManager.persistAndFlush(newestDeploymentOtherCase);

        Assertions.assertThat(cut.findNewestDeploymentByDescriptionQuery("frontend-deploy", "localhost"))
                .hasValue(newestDeploymentOtherCase);
    }
}

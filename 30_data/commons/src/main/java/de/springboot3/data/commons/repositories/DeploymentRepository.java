package de.springboot3.data.commons.repositories;

import de.springboot3.data.commons.model.Deployment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeploymentRepository extends CrudRepository<Deployment, Long> {
    Optional<Deployment> findFirstByJobNameAndHostNameAllIgnoreCaseOrderByCreationDateDesc(
            String jobName,
            String hostName
    );

    @Query(
            value = """
                    SELECT * FROM deployment d
                    WHERE UPPER(d.job_name) = UPPER(?1)
                    AND UPPER(d.host_name) = UPPER(?2)
                    ORDER BY d.creation_date DESC LIMIT 1
                    """,
            nativeQuery = true
    )
    Optional<Deployment> findNewestDeploymentByDescriptionQuery(
            String jobName,
            String hostName
    );

    default Optional<Deployment> findNewestDeploymentByDescription(
            String jobName,
            String hostName
    ) {
        return findFirstByJobNameAndHostNameAllIgnoreCaseOrderByCreationDateDesc(jobName, hostName);
    }
}

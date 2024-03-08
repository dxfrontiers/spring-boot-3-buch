package de.springbootbuch.data.commons.repositories;

import de.springbootbuch.data.commons.model.Deployment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DeploymentRepository extends CrudRepository<Deployment, Long> {
    Optional<Deployment> findFirstByJobNameAndHostNameAllIgnoreCaseOrderByCreationDateDesc(
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

package com.organization.repository;

import com.organization.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {


   Organization findByOrganizationCode(String organizationCode);
}

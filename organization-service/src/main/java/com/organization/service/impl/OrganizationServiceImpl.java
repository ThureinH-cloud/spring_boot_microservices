package com.organization.service.impl;

import com.organization.dto.OrganizationDto;
import com.organization.entity.Organization;
import com.organization.mapper.OrganizationMapper;
import com.organization.repository.OrganizationRepository;
import com.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private final OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization organization=organizationRepository.findByOrganizationCode(organizationCode);
        if(organization==null){
            throw new RuntimeException("Organization not found");
        }
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}

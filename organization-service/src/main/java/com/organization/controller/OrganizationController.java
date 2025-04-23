package com.organization.controller;

import com.organization.dto.OrganizationDto;
import com.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;
    @PostMapping
    public ResponseEntity<OrganizationDto> addOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto organization=organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(organization, HttpStatus.CREATED);
    }
    @GetMapping("/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode) {
        OrganizationDto organization=organizationService.getOrganizationByCode(organizationCode);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }
}

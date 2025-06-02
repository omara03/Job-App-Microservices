package com.project.JobApplication.company.Impl;

import com.project.JobApplication.company.Company;
import com.project.JobApplication.company.CompanyReposatory;
import com.project.JobApplication.company.CompanyService;
import com.project.JobApplication.job.Job;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyReposatory companyReposatory;
    public CompanyServiceImpl(CompanyReposatory companyReposatory) {
        this.companyReposatory = companyReposatory;
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyReposatory.findAll();
    }

    @Override
    public Boolean updateCompany(Company company, long id) {
        Optional<Company> companyOptional=companyReposatory.findById(id);

        if (companyOptional.isPresent()){
            Company companyToUpdate=companyOptional.get();
            companyToUpdate.setName(company.getName());
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setJobs(company.getJobs());
            companyReposatory.save(companyToUpdate);
            return true;
        }

        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyReposatory.save(company);
    }

    @Override
    public boolean deleteCompanyById(long id) {
        if (companyReposatory.existsById(id)){
            companyReposatory.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company getCompanyById(long id) {
        return companyReposatory.findById(id).orElse(null);
    }
}

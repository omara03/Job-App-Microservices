package com.Project1.companyms.company.Impl;

import com.Project1.companyms.company.Company;
import com.Project1.companyms.company.CompanyReposatory;
import com.Project1.companyms.company.CompanyService;
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

package com.Project1.companyms.company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    Boolean updateCompany(Company company, long id);
    void createCompany(Company company);
    boolean deleteCompanyById(long id);
    Company getCompanyById(long id);
}

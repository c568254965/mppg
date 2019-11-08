package com.csrr.mppg.repository.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csrr.mppg.entity.Company;
import com.csrr.mppg.repository.mapper.CompanyMapper;
import com.csrr.mppg.repository.service.ICompanyService;
import org.springframework.stereotype.Service;

@Service
public class ICompanyServiceImp  extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {
}

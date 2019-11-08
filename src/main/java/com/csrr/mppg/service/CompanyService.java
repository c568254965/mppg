package com.csrr.mppg.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csrr.mppg.converter.CompanyConverter;
import com.csrr.mppg.dto.CompanyDTO;
import com.csrr.mppg.entity.Company;
import com.csrr.mppg.repository.mapper.CompanyMapper;
import com.csrr.mppg.repository.service.imp.ICompanyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    @Resource
    ICompanyServiceImp iCompanyServiceImp;



    public Company findById(Integer id) {

       return companyMapper.selectById(id);
    }

    public void add(Company company) {

        companyMapper.insert(company);
        System.out.println("插入成功....");
        System.out.println(company.getId());
    }

    public IPage<Company> searchWithPage(CompanyDTO dto, Integer startPage, Integer pageSize) {

        Company company = CompanyConverter.INSTANCE.DtoToEn(dto);

        QueryWrapper<Company> wrapper = Wrappers.query(company).orderByDesc("id");


        QueryWrapper queryWrapper = new QueryWrapper();

        queryWrapper.like("name",company.getName());
        queryWrapper.gt("age",30);
        IPage<Company> page = iCompanyServiceImp.page(new Page<>(startPage, pageSize),queryWrapper);


        return page;
    }
}

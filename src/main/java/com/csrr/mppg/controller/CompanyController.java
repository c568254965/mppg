package com.csrr.mppg.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.csrr.mppg.dto.CompanyDTO;
import com.csrr.mppg.dto.RequestWithPageDTO;
import com.csrr.mppg.entity.Company;
import com.csrr.mppg.service.CompanyService;
import com.csrr.mppg.converter.CompanyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @GetMapping("/search.do")
    public JSONObject search()  {

        Company company = companyService.findById(1);
        CompanyDTO companyDTO = CompanyConverter.INSTANCE.EnToDTO(company);
        JSONObject json = new JSONObject();
        json.put("result",companyDTO);
        return json;

    }

    @GetMapping("/checkForConsul")
    public String checkForConsul()  {


        return "jump...";

    }



    @PostMapping("/searchWithPage.do")
    public JSONObject searchWithPage(@RequestBody RequestWithPageDTO<CompanyDTO> dto)  {

        IPage<Company> page = companyService.searchWithPage(dto.getData(),dto.getStartPage(),dto.getPageSize());

        JSONObject json = new JSONObject();
        json.put("result",page);
        return json;

    }


    @PostMapping("/add.do")
    public String add(@RequestBody CompanyDTO dto){
        CompanyDTO d = new CompanyDTO();
        companyService.add(CompanyConverter.INSTANCE.DtoToEn(dto));
        return null;
    }
}

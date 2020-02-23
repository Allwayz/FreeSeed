package com.allwayz.freeseed.JSPController;

import com.allwayz.freeseed.model.entity.CityDtl;
import com.allwayz.freeseed.model.entity.NationalDtl;
import com.allwayz.freeseed.model.entity.ProvinceDtl;
import com.allwayz.freeseed.model.mapper.CityDtlMapper;
import com.allwayz.freeseed.model.mapper.NationalDtlMapper;
import com.allwayz.freeseed.model.mapper.ProvinceDtlMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//TODO show location servlet
@Controller
public class LocationSelectController {
    @Autowired
    NationalDtlMapper nationalDtlMapper;
    @Autowired
    ProvinceDtlMapper provinceDtlMapper;
    @Autowired
    CityDtlMapper cityDtlMapper;

    /**
     *
     * @return
     */
    @RequestMapping("/locationSelect")
    @ResponseBody
    public List<NationalDtl> showLocation() {
        List<NationalDtl> nationalDtlList = nationalDtlMapper.selectList(new QueryWrapper<NationalDtl>());
        return nationalDtlList;
    }

    /**
     *
     * @param national
     * @return
     */
    @RequestMapping("/showProvince")
    @ResponseBody
    public List<ProvinceDtl> showProvince(String national){
        NationalDtl nationalDtl = nationalDtlMapper.selectOne(new QueryWrapper<NationalDtl>().eq("national_dtl_name",national));
        List<ProvinceDtl> provinceDtlList = provinceDtlMapper.selectList(new QueryWrapper<ProvinceDtl>().eq("national_dtl_id",nationalDtl.getNationalDtlId()));
        return provinceDtlList;
    }

    /**
     *
     * @param province
     * @return
     */
    @RequestMapping("/showCity")
    @ResponseBody
    public List<CityDtl> showCity(String province){
        ProvinceDtl provinceDtl = provinceDtlMapper.selectOne(new QueryWrapper<ProvinceDtl>().eq("province_dtl_name",province));
        List<CityDtl> cityDtlList = cityDtlMapper.selectList(new QueryWrapper<CityDtl>().eq("province_dtl_id",provinceDtl.getProvinceDtlId()));
        return cityDtlList;
    }

}


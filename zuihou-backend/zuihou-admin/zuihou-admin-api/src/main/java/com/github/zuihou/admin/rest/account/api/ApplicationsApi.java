package com.github.zuihou.admin.rest.account.api;

import com.github.zuihou.admin.rest.account.dto.ApplicationsDTO;
import com.github.zuihou.admin.rest.account.api.hystrix.ApplicationsApiHystrix;
import com.github.zuihou.base.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zuihou
 * @createTime 2017-12-08 16:07
 */
@FeignClient(name = "${zuihou.feign-server.gateway:zuihou-gateway-server}", fallback = ApplicationsApiHystrix.class)
public interface ApplicationsApi {
    /**
     * 根据appid 和 密码 查找应用
     *
     * @param appId     appId
     * @param appSecret appSecret
     * @return
     */
    @RequestMapping(value = "/api/admin/app", method = RequestMethod.GET)
    Result<ApplicationsDTO> getBySecret(@RequestParam(value = "appId") String appId, @RequestParam(value = "appSecret") String appSecret);

}

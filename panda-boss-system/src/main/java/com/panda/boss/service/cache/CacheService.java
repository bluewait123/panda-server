package com.panda.boss.service.cache;

import com.panda.boss.constant.SystemRedisKey;
import com.panda.common.redis.service.RedisService;
import com.panda.common.utils.StringUtils;
import com.panda.mybatis.mapper.SystemParamMapper;
import com.panda.mybatis.mapper.SystemResourceMapper;
import com.panda.mybatis.mapper.SystemRoleMapper;
import com.panda.mybatis.po.SystemParam;
import com.panda.mybatis.po.SystemResource;
import com.panda.mybatis.po.SystemRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 缓存服务设置
 * @author w
 * @date 2020-07-01
 */
@Slf4j
@Service
public class CacheService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private SystemParamMapper systemParamMapper;

    @Autowired
    private SystemRoleMapper systemRoleMapper;

    @Autowired
    private SystemResourceMapper systemResourceMapper;


    /**
     * 缓存系统参数信息
     */
    public void setSystemParameter(){
        log.debug("缓存系统参数信息...");
        List<SystemParam> list = systemParamMapper.selectAll();
        if(StringUtils.isNotEmpty(list)){
            redisService.set(SystemRedisKey.checkSystemParamKey(),"1");
            for(SystemParam param : list){
                redisService.putObject(SystemRedisKey.getSystemParamKey(param.getParaCode()),param);
            }
        }
    }

    /**
     * 缓存系统资源信息
     */
    public void setSystemResource(){
        log.debug("缓存系统资源信息...");
        List<SystemRole> roles = systemRoleMapper.selectAll();
        if(StringUtils.isNotEmpty(roles)){
            redisService.set(SystemRedisKey.checkSystemResourceKey(),"1");
            List<SystemResource> resources;
            for(SystemRole role : roles){
                resources = systemResourceMapper.selectByRoleId(role.getId());
                if(StringUtils.isNotEmpty(resources)){
                    redisService.putObject(SystemRedisKey.getSystemResourceKey(role.getId()),resources);
                }
            }
        }
    }

    /**
     * 获取系统参数
     * 优先从redis读取，为空读取数据库并写入缓存
     * @param paraCode 系统参数编码
     * @return SystemParam
     */
    public SystemParam getSystemParameter(String paraCode){
        String redisKey = SystemRedisKey.getSystemParamKey(paraCode);
        SystemParam param = redisService.getObject(redisKey,SystemParam.class);
        if(StringUtils.isEmpty(param)){
            param = systemParamMapper.selectByParaCode(paraCode);
            if(StringUtils.isNotEmpty(param)){
                redisService.putObject(redisKey,param);
            }
        }
        return param;
    }

    /**
     * 获取系统资源
     * 优先从redis读取，为空读取数据库并写入缓存
     * @param roleId 角色ID
     * @return List<SystemResource>
     */
    public List<SystemResource> getSystemResource(String roleId){
        String redisKey = SystemRedisKey.getSystemResourceKey(roleId);
        List<SystemResource> list = redisService.getList(redisKey,SystemResource.class);
        if(StringUtils.isEmpty(list)){
            list = systemResourceMapper.selectByRoleId(roleId);
            if(StringUtils.isNotEmpty(list)){
                redisService.putObject(redisKey,list);
            }
        }
        return list;
    }

    /**
     * 更新系统参数
     * @param param 系统参数信息
     */
    public void updateSystemParameter(SystemParam param){
        String redisKey = SystemRedisKey.getSystemParamKey(param.getParaCode());
        redisService.putObject(redisKey,param);
    }

    /**
     * 删除缓存中的系统资源信息
     * @param roleId 角色ID
     */
    public void deleteSystemResource(String roleId){
        redisService.delete(SystemRedisKey.getSystemResourceKey(roleId));
    }

}

package com.tl.service.impl;

import com.tl.entity.SysUser;
import com.tl.mapper.UserInfoMapper;
import com.tl.service.TimeTaskService;
import com.tl.utils.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: tl
 * @description: 定时发送邮件
 * @author:
 * @create: 2018-11-27 16:05
 **/
@Component
public class TimeTaskServiceImpl implements TimeTaskService {
    Logger logger = LoggerFactory.getLogger(TimeTaskService.class);

    @Autowired
    UserInfoMapper userInfoMapper;

    /**
     * 发送天气定时任务
     *
     * @return
     */
    @Scheduled(cron = "0 0 0 * * ?")
    @Override
    public SysUser findByEmailType() {
        logger.info("进入天气定时任务");
        SysUser sysUser = userInfoMapper.findByEmailType();
        if (sysUser.isEmailType()) {
            Integer[] city = {101020300, 101020500};
            String email = "927920568@qq.com";
            try {
                EmailUtil.emailSend(email, city);
                logger.info("发送完成");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e.getMessage());
            }
        } else {
            logger.info("没有开启天气邮件发送任务");
        }
        return null;
    }
}

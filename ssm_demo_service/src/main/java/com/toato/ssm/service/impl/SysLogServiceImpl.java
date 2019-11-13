package com.toato.ssm.service.impl;

import com.toato.ssm.dao.ISysLogDao;
import com.toato.ssm.domain.SysLog;
import com.toato.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/11/12 21:09
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;


    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}

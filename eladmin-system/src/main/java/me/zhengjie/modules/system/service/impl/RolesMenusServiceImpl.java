package me.zhengjie.modules.system.service.impl;

import lombok.AllArgsConstructor;
import me.zhengjie.base.impl.CommonServiceImpl;
import me.zhengjie.modules.system.domain.RolesMenus;
import me.zhengjie.modules.system.service.RolesMenusService;
import me.zhengjie.modules.system.service.mapper.RolesMenusMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jinjin on 2020-09-25.
 */
@AllArgsConstructor
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class RolesMenusServiceImpl extends CommonServiceImpl<RolesMenusMapper, RolesMenus> implements RolesMenusService {

    private final RolesMenusMapper rolesMenusMapper;

    @Override
    public List<Long> queryMenuIdByRoleId(Long id) {
        return lambdaQuery().eq(RolesMenus::getRoleId, id).list().stream().map(RolesMenus::getMenuId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> queryRoleIdByMenuId(Long id) {
        return lambdaQuery().eq(RolesMenus::getMenuId, id).list().stream().map(RolesMenus::getRoleId)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByRoleId(Long id) {
        return lambdaUpdate().eq(RolesMenus::getRoleId, id).remove();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByMenuId(Long id) {
        return lambdaUpdate().eq(RolesMenus::getMenuId, id).remove();
    }

}

package me.zhengjie.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.toolkit.ChainWrappers;

/**
* 公共抽象Mapper接口类
* @author fanglei
* @date 2021/07/28
*/
public interface CommonMapper<E> extends BaseMapper<E> {
    default QueryChainWrapper<E> query() {
        return ChainWrappers.queryChain(this);
    }
    
    default LambdaQueryChainWrapper<E> lambdaQuery() {
        return ChainWrappers.lambdaQueryChain(this);
    }
    
    default UpdateChainWrapper<E> update() {
        return ChainWrappers.updateChain(this);
    }
    
    default LambdaUpdateChainWrapper<E> lambdaUpdate() {
        return ChainWrappers.lambdaUpdateChain(this);
    }
}

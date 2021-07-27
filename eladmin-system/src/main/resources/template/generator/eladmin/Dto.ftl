package ${package}.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
<#if hasTimestamp>
import java.sql.Timestamp;
</#if>
<#if hasBigDecimal>
import java.math.BigDecimal;
</#if>
import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModelProperty;
<#if !auto && pkColumnType == 'Long'>
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
</#if>

/**
* @author ${author}
* @date ${date}
*/
@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ${className}Dto implements Serializable {
    private static final long serialVersionUID = 1L;
<#if columns??>
    <#list columns as column>

    <#if column.remark != ''>
    @ApiModelProperty(value = "${column.remark}")
    </#if>
    <#if column.columnKey = 'PRI'>
    <#if !auto && pkColumnType = 'Long'>
    /** 防止精度丢失 */
    @JSONField(serializeUsing = ToStringSerializer.class)
    </#if>
    </#if>
    <#if column.changeColumnName != 'delFlag'>
    private ${column.columnType} ${column.changeColumnName};
    </#if>
    </#list>
</#if>
}

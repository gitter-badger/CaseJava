<#include "_.ftl">
<@header title="数学相关">
    <#assign nums=[0, 1, -1, 0.5, 1.5, -0.5, -1.5, 0.25, -0.25, 1.75, -1.75, 1000, 1000.1, 999.9]>
    <#list nums as num>
    ${num} 的绝对值是 ${num?abs}
    ${num} ${num?is_nan?string('不', '')}是数字
    ${num} ${num?is_infinite?string('', '不')}是无穷值
    ${num} 取整计算 ?floor=${num?floor} ?ceiling=${num?ceiling} ?round=${num?round}
    ${num} 数字格式 ${num?string.number}
    ${num} 货币格式 ${num?string.currency}
    ${num} 百分数 ${num?string.percent}
    ${num} 百分数 ${num?string.computer}

    </#list>
</@header>
<#include "_.ftl">
<#macro toCN num><#switch num><#case 1>壹<#break ><#case 2>贰<#break ><#case 3>叁<#break ></#switch></#macro>
<@header title="Data Model & Tags">
    1 + 1 = ${1 + 1}
    Template + data-model = output

    Array tests:
    <#assign array = [1, 2, 3]>
    <#list  array as item>
        array[${item_index}] = ${item} - ${(item > 0 && item % 2 == 0)?string('偶数','奇数')} - <@toCN item />
    </#list>

    Hash tests:
    <#assign hash = {"a": 1, "b": 2}>
    <#list hash?keys as key>
        hash[${key}] = ${hash[key]} - ${key_index} - ${key_has_next?string('不是', '')}最后一个元素
    </#list>
</@header>
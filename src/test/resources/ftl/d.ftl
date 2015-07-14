<#include "b.ftl">

<@header title="空值表达式测试">
    <#if a?exists && a.a?exists>
        ${a.a!'空值'}
    </#if>
    <#if a?? && a.a??>
        ${a.a!'空值'}
    </#if>
</@header>

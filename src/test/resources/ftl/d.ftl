<#include "b.ftl">

<@header>
    <#if a?exists && a.a?exists>
        ${a.a!'空值'}
    </#if>
</@header>

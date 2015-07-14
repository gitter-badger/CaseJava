<#include "b.ftl">

<@header>
    <#assign txt = '1234567890' />
    ${(txt?length > 5)?string(txt?substring(0, 5), txt)?trim}
    ${txt?number!0?string.currency}
    <#if txt??>
        <#assign price =txt?number>
    <#else>
        <#assign price =0>
    </#if>
    ${price?string.number}
</@header>
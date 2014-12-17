<#assign txt = '1234567890' />

${(txt?length > 5)?string(txt?substring(0, 5), txt)?trim}

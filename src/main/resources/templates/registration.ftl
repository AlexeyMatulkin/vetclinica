<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-4">Регистрация</div>
${employee?ifExists }
<@l.login "/registration" true />
</@c.page>

<#import "parts/common.ftl" as c>

<@c.page "none">
    Список пользователей


    <table class="table table-striped table-bordered">
        <thead class="thead-inverse">
        <tr>
            <th>Иия пользователя</th>
            <th>Роль</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>

                <td>${user.username}</td>

                <td><#list user.roles as role>${role}<#sep>, </#list></td>

                <td><a href="/user/${user.id}">edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>

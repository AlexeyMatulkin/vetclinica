<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page "none">
    <h5>Список услуг</h5>
    <div>    </div>



    <#if isAdmin>
    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Добавить услугу
    </a>
    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <input type="text" class="form-control" name="procedure" placeholder="Услуга"/>
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="cost" placeholder="Стоимость">
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    </#if>
    <table  class="table table-striped table-bordered mt-3">
        <thead>
        <tr>
            <th>
                Услуга
            </th>
            <th>Стоимость</th>
            <#--<th>Пользователь</th>-->
        </tr>
        </thead>
        <tbody>
        <#list prices as price>
            <tr>
                <td>${price.procedur}</td>
                <td>${price.cost}</td>
            </tr>
        </#list>

        </tbody>
    </table>


</@c.page>

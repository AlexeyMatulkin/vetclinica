<#import "parts/common.ftl" as c>

<@c.page "none">
    <h5>Hello, guest</h5>
    <div></div>

    <a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
       aria-controls="collapseExample">
        Добавить новость
    </a>

    <div class="collapse" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <textarea class="form-control" name="text" placeholder="Введите новость"></textarea>
                </div>
                <div class="form-group">
                    <input type="date" class="form-control" name="date_post" placeholder="Введите дату">
                </div>
                <div class="form-group">
                    <div class="custom-file">
                        <input type="file" name="file" id="customFile">
                        <label class="custom-file-label" for="customFile">Выбрать файл</label>
                    </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Добавить</button>
                </div>
            </form>
        </div>
    </div>
    <table class="table table-striped table-bordered mt-3">
        <thead>
        <tr>
            <th>
                Последние новости
            </th>
            <th>Дата</th>
            <#--<th>Пользователь</th>-->
        </tr>
        </thead>
        <tbody>
        <#list novosts as novost>
            <tr>
                <td><span style="white-space: pre-line">${novost.text}</span></td>
                <td>${novost.date_post}</td>
            </tr>
        </#list>

        </tbody>
    </table>


</@c.page>

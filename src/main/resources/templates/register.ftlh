<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2  class="h2_for_css">Please register</h2>
    <div>
    <form action="/register" method="post">

        <form action="register.ftlh" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>
            <label>Name</label>
            <input type="text" name="fullName">
            <br><label>Email</label>
            <input type="email" name="email"><br>
            <label>Password</label>
            <input type="password" name="password">
            <input type="submit" value="register"><br>

        </form>

        <div>
            <#if errors?? >
                <p>Входные данные с ошибками!</p>
                <#list errors as fieldError>
                    <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                </#list>
            </#if>
        </div>
    </form>
    </div>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>
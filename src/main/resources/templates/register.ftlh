<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h2 class="h2_for_css">Please register</h2>
    <div class="d-flex justify-content-center">
    <div class="mx-3">
        <form action="/registration" method="post">

            <form action="register.ftlh" method="post">
                <#if _csrf??>
                    <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                           value="${(_csrf.token)!'--no-token--'}"/>
                </#if>
                <div>
                    <label class="flex flex-v-center">Name</label>
                    <input  class="form-control mb-2" type="text" name="fullName">
                </div>

                <div>
                    <label class="flex flex-v-center">Email</label>
                    <input  class="form-control mb-2" type="email" name="email">
                </div>
                <div>
                    <label class="flex flex-v-center">Password</label>
                    <input  class="form-control mb-2" type="password" name="password">
                </div>
                <div>
                    <input class="btn btn-outline-primary btn-block" type="submit" value="register"><br>
                </div>


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
</div>
</@main.renderWith>
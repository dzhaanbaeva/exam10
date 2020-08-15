<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h3 class="mb-3" id="add-category-header" style="text-align: center">Add new place</h3>
    <form action="addPlace" method="post" class="">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"></input>
            </#if>

            <div class="add-form">
                <div class="add-form-row">
                    <p>Title</p>
                    <input type="text" class="form-control" name="name"  required="required" value=""/>
                </div>
                <div class="add-form-row">
                    <p>Description</p>
                    <textarea class="form-control" name="description"  required="required" value=""></textarea>
                </div>
                <div class="add-form-row">
                    <p>Main photo</p>
                    <input type="file" name="photo" required="required" value=""/>
                </div>
            </div>
            <button class="btn btn-outline-primary mb-2 add-form-button" id="add-category-button"  type="submit">Submit new place</button>
        </form>
</@main.renderWith>


<#import "partials/main.ftlh" as main />

<@main.renderWith >
    <h3 id= 'goods-text' style="text-align: center">All Place</h3>

<div class="row"
        <#list place as p>
        <div class="col md-3 ">
<img src=${p.photo}>
        </div>

        </#list>

    <#include "partials/pagination.ftlh">

</@main.renderWith>



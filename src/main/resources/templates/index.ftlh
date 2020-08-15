<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h3 id= 'goods-text' style="text-align: center">All Place</h3>

    <div class="main-places-row">
    <#list place as p>
        <div class="place-card">
            <img class="place-img" src="${"http://localhost:9090/images/" + p.photo}" alt="#">
            <a href=""><h6>${p.name}</h6></a>
            <div class="start-icon-row">
                <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
            </div>
            <p class="reviews-counts">(4.6, 220 review)</p>
            <div class="photos-row">
                <img class="camera-img" src="${"http://localhost:9090/images/camera-icon.png"}" alt="">
                <p class="photos-size">20 photos</p>
            </div>
        </div>
    </#list>
</div>
    <#include "partials/pagination.ftlh">



</@main.renderWith>
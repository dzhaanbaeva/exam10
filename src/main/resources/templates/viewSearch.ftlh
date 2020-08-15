<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <h1 class="mb-3 place-name">${place.name}</h1>
    <h1 class="mb-3 place-description">${place.description}</h1>
    <form action="addReview" method="post" class="">
        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"></input>
        </#if>

        <div class="add-form-review">
            <div class="add-form-row-review">
                <img class="place-img" src="${"http://localhost:9090/images/" + place.photo}" alt="#">
            </div>

            <div class="place-rating-row">
                <p>Rating: </p>
                <div class="rating-stars">
                    <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                    <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                    <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                </div>
                <span>3.5</span>
            </div>

            <div class="reviews-place">
                <h6>Reviews:</h6>

                <div class="review-item">
                    <div class="review-head">
                        On&nbsp;<span class="date">15.15.2020</span>,&nbsp;
                        <span class="name">John Snow</span>&nbsp;said:
                        <p>It was soooo goooood!!!</p>
                    </div>
                    <div class="review-stars">
                        <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                        <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                        <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                        <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">
                        <img class="star-icon" src="${"http://localhost:9090/images/star-icon.png"}" alt="">

                        <span>5.0</span>
                    </div>

                    <form action="">
                        <div class="add-review-field">
                            <h5>Add review:</h5>
                            <textarea name="" id="" cols="30" rows="10"></textarea>
                        </div>
                        <div class="add-review-options">
                            <div class="select">
                                <label for="selectRatingId">Rating: </label>
                                <select name="rating" id="selectRatingId">
                                    <option value="1">1</option>
                                    <option value="1">2</option>
                                    <option value="1">3</option>
                                    <option value="1">4</option>
                                    <option value="1">5</option>
                                </select>
                            </div>

                            <button class="btn btn-outline-primary" type="submit">Submit</button>

                        </div>
                    </form>

                    <form action="" class="upload-images">
                        <p>Upload new photo</p>
                        <label for="uploadId">Choose file</label>
                        <input type="file" id="uploadId"/>
                        <button class="btn btn-outline-primary" type="submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </form>
</@main.renderWith>


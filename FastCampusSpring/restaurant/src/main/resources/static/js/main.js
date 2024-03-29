(function ($) {
    var search_result = new Vue({
        el: '#search-result',
        data: {
            search_result : {}
        },
        method: {
            wishButton: function (event) {
                console.log("add");
            }
        }
    });

    var wish_list = new Vue({
        el: '#wish-list',
        data: {
            wish_list : {}
        },
        methods: {
            addVisit: function (index) {
                $.ajax({
                    type: "POST" ,
                    async: true ,
                    url: `/api/food/${index}`,
                    timeout: 3000
                });

                getWishList();
            },
            deleteWish: function (index) {
                $.ajax({
                    type: "DELETE" ,
                    async: true ,
                    url: `/api/food/${index}`,
                    timeout: 3000
                });
                getWishList();
            }
        }
    });

    // search
    $("#searchButton").click(function () {
        const query = $("#searchBox").val();
        $.get(`/api/food/search?query=${query}`, function (response) {
            search_result.search_result = response;
            $('#search-result').attr('style','visible');
        });
    });

    // Enter
    $("#searchBox").keydown(function(key) {
        if (key.keyCode === 13) {
            const query = $("#searchBox").val();
            $.get(`/api/food/search?query=${query}`, function (response) {
                search_result.search_result = response;
                $('#search-result').attr('style','visible');
            });
        }
    });

    $("#wishButton").click(function () {
        $.ajax({
            type: "POST" ,
            async: true ,
            url: "/api/food",
            timeout: 3000,
            data: JSON.stringify(search_result.search_result),
            contentType: "application/json",
            error: function (request, status, error) {

            },
            success: function (response, status, request) {
                getWishList();
            }
        });
    });

    function getWishList(){
        $.get(`/api/food/all`, function (response) {
            wish_list.wish_list = response;
        });
    }

    $(document).ready(function () {
        console.log("init")
    });

})(jQuery);


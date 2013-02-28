(function ($) {
    var recentItemList = [];
    var idx = 0;

    $.fn.updateRecentItem = function (recentItem) {

        if (recentItemList.length == 5) {
            recentItemList.shift();
        }
        recentItemList.push(recentItem); // maintain item in the list

        $(this).empty();

        for (var i = 0; i < recentItemList.length; i++) {
            $(this).append("<li>" + "testing" + idx.toString() + recentItemList[i].companyId + "</li>");
        }

        idx++;

    }

})(jQuery);
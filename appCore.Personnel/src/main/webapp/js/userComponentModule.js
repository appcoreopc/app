(function ($) {
    function extractData(data1) {

        var data = [
            { 'title':'title1', description:'you are getting new alert' },
            { 'title':'title2', description:'yoga instructor' }
        ];

        var alertContentMarkup = "";
        if (data != null) {

            for (var i=0; i < data.length; i++)
            {
                alertContentMarkup += "<div class='alert'>";
                alertContentMarkup += "<button data-dismiss='alert' class='close' type='button'>×</button>";
                alertContentMarkup += "<strong>" + data[i].title + "</strong>" + data[i].description + "</div>";
            }
        }
        return alertContentMarkup;
    }

    $.fn.loadControl = function (userId) {

        var serviceUrl = globalUserLandingServiceUrlGet;
        var alertContentMarkup = "";
        var requestData = { 'userId':userId};

        /*var ajaxCore = new AjaxCore();
         var requestMenu = ajaxCore.sendRequest(serviceUrl, requestData, 'get');
         requestMenu.done(function (data) {

         extractData(data);
         });*/

        var alertContentMarkup = extractData('');
        var controlMarkup = "<div>";
        controlMarkup += alertContentMarkup;
        controlMarkup += "</div>";
        $(controlMarkup).appendTo(".cellColumnRight");

    };
})(jQuery);
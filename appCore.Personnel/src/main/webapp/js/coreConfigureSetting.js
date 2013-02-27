(function ($) {
    var menuLoaded = false;
    $.fn.configureSettings = function (targetClickElementId) {

        if (targetClickElementId != undefined) {

            var menuDialog = $("<div id='configureSetupView'><div id='configureSetupHeader'></div><div id='configureSetupContent'></div></div>");
            menuDialog.appendTo(document.body);
            $("#configureSetupView").css('visibility', 'hidden');

            $("#" + targetClickElementId).click(function (e) {

                e.preventDefault();

                $("#configureSetupView").css('visibility', 'visible');
                $("#configureSetupView").show(10);
                $("#configureSetupView").offset({left:e.pageX - 40, top:e.pageY + 20});

                if (!menuLoaded) {
                    $("#configureSetupContent").append("<div id='configureSetupAccordian'></div>");

                    menuLoaded = true;

                    var ajaxCore = new AjaxCore();
                    var requestMenu = ajaxCore.sendRequest(globalHostname + globalMenuServiceUrl, null, 'get');

                    requestMenu.done(function (data) {
                        menuDataSource = data;
                        if (menuDataSource != undefined) {

                            for (var i = 0; i < menuDataSource.length; i++) {
                                if (menuDataSource[i].text != null) {

                                    $("#configureSetupAccordian").append("<h3>" + menuDataSource[i].text + "</h3>");
                                    $("#configureSetupAccordian").append("<div><p></p></div>");
                                    for (var j = 0; j < menuDataSource[i].items.length; j++) {
                                        $("#configureSetupAccordian div p").append("<a data-link='" + menuDataSource[i].items[j].link + "'>" + menuDataSource[i].items[j].text + "</a>");
                                    }
                                }
                            }

                            $("#configureSetupAccordian").accordion();

                            $("#configureSetupAccordian.ui-accordion div.ui-accordion-content p a").click(function () {
                                e.preventDefault();

                                var link = $(this).attr('data-link');

                                if (link) {
                                    preparePageForLoading(link);
                                }
                            });
                        }
                    });
                }
                else {
                    $("#configureSetupView").show(10);
                }

                $(document.body).on('click', function (e) {
                    console.log("document click event setup!");
                    if (
                        !$(e.target).is('#configureSetupView')
                            && !$(e.target).is("#" + targetClickElementId)
                            && !$(e.target).is("#" + "configureSetupAccordian")
                            && !$(e.target).is("#" + "configureSetupView")
                            && !$(e.target).is("#" + "configureSetupAccordian h3")

                        ) {
                        console.log("hide element");
                        $("#configureSetupView").hide();
                        $(document.body).off('click');
                    }
                });

            });
        }
    };

})(jQuery);
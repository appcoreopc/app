(function ($) {
    // anything here would be global scope //
    $.fn.configurePopupMenu = function (targetClickElementId, popupElementName, serviceUrl) {

        var menuLoaded = false;
        var popupSetupHeader = popupElementName + "Header"
        var popupSetupContent = popupElementName + "Content"
        var popupSetupAccordian = popupElementName + "Accordian"
        var popupSetupView = popupElementName;

        if (targetClickElementId != undefined) {

            var menuDialog = $("<div id='" + popupSetupView + "'><div id='" + popupSetupHeader +  "'></div><div id='" + popupSetupContent + "'></div></div>");
            menuDialog.appendTo(document.body);
            $("#"+ popupSetupView).css('visibility', 'hidden');

            $("#" + targetClickElementId).click(function (e) {

                e.preventDefault();

                $("#" + popupSetupView).css('visibility', 'visible');
                $("#" + popupSetupView).show(10);
                $("#" + popupSetupView).offset({left:e.pageX - 10, top:e.pageY + 20});

                if (!menuLoaded) {
                    $("#" + popupSetupContent).append("<div id='" + popupSetupAccordian + "'></div>");

                    menuLoaded = true;

                    var ajaxCore = new AjaxCore();
                    var requestMenu = ajaxCore.sendRequest(serviceUrl, null, 'get');

                    requestMenu.done(function (data) {
                        menuDataSource = data;
                        if (menuDataSource != undefined) {

                            for (var i = 0; i < menuDataSource.length; i++) {
                                if (menuDataSource[i].text != null) {

                                    $("#" + popupSetupAccordian).append("<h3>" + menuDataSource[i].text + "</h3>");
                                    $("#" + popupSetupAccordian).append("<div><p></p></div>");
                                    for (var j = 0; j < menuDataSource[i].items.length; j++) {
                                        $("#" + popupSetupAccordian +" div p").append("<a data-link='" + menuDataSource[i].items[j].link + "'>" + menuDataSource[i].items[j].text + "</a>");
                                    }
                                }
                            }

                            $("#" + popupSetupAccordian).accordion();

                            $("#" + popupSetupAccordian + ".ui-accordion div.ui-accordion-content p a").click(function () {
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
                    $("#" + popupSetupView).show(10);
                }

                $(document.body).on('click', function (e) {
                    if (
                        !$(e.target).is('#' + popupSetupView)
                            && !$(e.target).is("#" + targetClickElementId)
                            && !$(e.target).is("#" + popupSetupAccordian)
                            && !$(e.target).is("#" + popupSetupView)
                            && !$(e.target).is("#" + popupSetupAccordian + " h3")

                        ) {
                        $("#" + popupSetupView).hide();
                        $(document.body).off('click');
                    }
                });

            });
        }
    };
})(jQuery);